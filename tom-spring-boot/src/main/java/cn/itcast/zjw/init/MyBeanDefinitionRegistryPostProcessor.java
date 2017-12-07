package cn.itcast.zjw.init;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.bind.RelaxedDataBinder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.AnnotationScopeMetadataResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;

import cn.itcast.zjw.datasource.multiple.DynamicDataSource;
import cn.itcast.zjw.datasource.multiple.DynamicDataSourceContextHolder;
import cn.itcast.zjw.datasource.simple.ShanhyA;
import cn.itcast.zjw.datasource.simple.ShanhyB;

/**
 * @Configuration 中，不能使用注入属性的方式注入，只能通过参数的方式注入，
 * 其原因就是@Configuration的类一开始变被加载，此时你想进行属性注入，需要注入的bean对象都还不存在呢。
 * 也就是说被该注解所注解的话，其内不能使用resource等注解来注入Bean
 */
/**
 * 
 * @ClassName: MyBeanDefinitionRegistryPostProcessor.java
 * @Description:在所有的Bean初始化之前便开始运行，在这三个类中第一个运行 扩展为多Spring boot多数据源,
 * @Time 2017年12月6日
 * @author: Tom
 */
@Configuration
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, EnvironmentAware {
	// 若配置文件中未指定数据源类型，使用该默认值
	private static final Object DATASOURCE_TYPE_DEFAULT = "com.alibaba.druid.pool.DruidDataSource";

	private ConversionService conversionService = new DefaultConversionService();
	private PropertyValues dataSourcePropertyValues;

	// 默认数据源
	private DataSource defaultDataSource;
	// 其他数据源
	private Map<String, DataSource> customDataSources = new HashMap<String, DataSource>();

	private ScopeMetadataResolver scopeMetadataResolver = new AnnotationScopeMetadataResolver();
	private BeanNameGenerator beanNameGenerator = new AnnotationBeanNameGenerator();

	/**
	 * 在本类中第二个运行，对Bean进行组装
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanFactory()");
		System.out.println("所有Bean创建之前启动    postProcessBeanFactory");
		/*beanFactory.getBeanDefinition("dataSource").setPrimary(true);
		BeanDefinition bd = null;
		Map<String, Object> dsMap = null;
		for (Entry<String, Map<String, Object>> entry : dataSourceMap.entrySet()) {
			bd = beanFactory.getBeanDefinition(entry.getKey());
			MutablePropertyValues mpv = bd.getPropertyValues();
			dsMap = entry.getValue();
			mpv.addPropertyValue("driverClassName", dsMap.get("url"));
			mpv.addPropertyValue("url", dsMap.get("url"));
			mpv.addPropertyValue("username", dsMap.get("username"));
			mpv.addPropertyValue("password", dsMap.get("password"));
		}*/
	}

	/**
	 * 在本类中第一个运行，将Bean进行初始化
	 */
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry()");
		System.out.println("所有Bean创建之前启动    postProcessBeanDefinitionRegistry");
		registerBean(registry, "shanhyA", ShanhyA.class);
		registerBean(registry, "shanhyB", ShanhyB.class);
		Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        // 将主数据源添加到更多数据源中
        targetDataSources.put("dataSource", defaultDataSource);
        DynamicDataSourceContextHolder.dataSourceIds.add("dataSource");
        // 添加更多数据源
        targetDataSources.putAll(customDataSources);
        for (String key : customDataSources.keySet()) {
            DynamicDataSourceContextHolder.dataSourceIds.add(key);
        }

        // 创建DynamicDataSource
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        mpv.addPropertyValue("defaultTargetDataSource", defaultDataSource);
        mpv.addPropertyValue("targetDataSources", targetDataSources);
        registry.registerBeanDefinition("dataSource", beanDefinition);
		/*
		只创建Bean，不做任何其他操作
		try {
            if(!dataSourceMap.isEmpty()){
                for (Entry<String, Map<String, Object>> entry : dataSourceMap.entrySet()) {

                    Object type = entry.getValue().get("type");
                    if(type == null)
                        type = DATASOURCE_TYPE_DEFAULT;// 默认DataSource
                    registerBean(registry, entry.getKey(), (Class<? extends DataSource>)Class.forName(type.toString()));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
	}

	/**
	 * 加载多数据源配置
	 */
	@Override
	public void setEnvironment(Environment environment) {
		//初始化默认数据源
		initDefaultDataSource(environment);
		initCustomDataSources(environment);
		
		/*RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env, "custom.datasource.");
        String dsPrefixs = propertyResolver.getProperty("names");
        for (String dsPrefix : dsPrefixs.split(",")) {// 多个数据源
            Map<String, Object> dsMap = propertyResolver.getSubProperties(dsPrefix + ".");
            dataSourceMap.put(dsPrefix, dsMap);
        }*/
	}
	/**
	 * 
	 * @Method:initCustomDataSources
	 * @Description:加载更多数据源
	 * @Time 2017年12月6日 下午3:02:55
	 * @author: Tom
	 * @param environment
	 */
	private void initCustomDataSources(Environment environment) {
		// 读取配置文件获取更多数据源，也可以通过defaultDataSource读取数据库获取更多数据源
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment, "custom.datasource.");
        String dsPrefixs = propertyResolver.getProperty("names");
        for (String dsPrefix : dsPrefixs.split(",")) {// 多个数据源
            Map<String, Object> dsMap = propertyResolver.getSubProperties(dsPrefix + ".");
            DataSource ds = buildDataSource(dsMap);
            customDataSources.put(dsPrefix, ds);
            dataBinder(ds, environment);
        }
	}
	/**
	 * 
	 * @Method:initDefaultDataSource
	 * @Description:数据源初始化
	 * @Time 2017年12月6日 下午3:03:29
	 * @author: Tom
	 * @param environment
	 */
	private void initDefaultDataSource(Environment environment) {
		// 读取主数据源
		RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
		Map<String, Object> dsMap = new HashMap<String, Object>();
		dsMap.put("type", propertyResolver.getProperty("type"));
		dsMap.put("driver-class-name", propertyResolver.getProperty("driver-class-name"));
		dsMap.put("url", propertyResolver.getProperty("url"));
		dsMap.put("username", propertyResolver.getProperty("username"));
		dsMap.put("password", propertyResolver.getProperty("password"));

		// 创建数据源;
		defaultDataSource = buildDataSource(dsMap);
		// 为数据库连接创建更多属性
		dataBinder(defaultDataSource, environment);
	}

	/**
	 * 
	 * @Method:buildDataSource
	 * @Description:创建数据源
	 * @Time 2017年12月6日 下午3:00:24
	 * @author: Tom
	 * @param dsMap
	 * @return
	 */
	private DataSource buildDataSource(Map<String, Object> dsMap) {
		Object type = dsMap.get("type");
		if (type == null) {
			type = DATASOURCE_TYPE_DEFAULT;// 默认DataSource
		}
		Class<? extends DataSource> dataSourceType;

		try {
			dataSourceType = (Class<? extends DataSource>) Class.forName((String) type);
			String driverClassName = dsMap.get("driver-class-name").toString();
			String url = dsMap.get("url").toString();
			String username = dsMap.get("username").toString();
			String password = dsMap.get("password").toString();
			DataSourceBuilder factory = DataSourceBuilder.create().driverClassName(driverClassName).url(url)
					.username(username).password(password).type(dataSourceType);
			return factory.build();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 为DataSource绑定更多数据
	 * 
	 * @param dataSource
	 * @param env
	 */
	private void dataBinder(DataSource dataSource, Environment env) {
		RelaxedDataBinder dataBinder = new RelaxedDataBinder(dataSource);
		dataBinder.setConversionService(conversionService);
		dataBinder.setIgnoreNestedProperties(false);// false
		dataBinder.setIgnoreInvalidFields(false);// false
		dataBinder.setIgnoreUnknownFields(true);// true

		if (dataSourcePropertyValues == null) {
			Map<String, Object> rpr = new RelaxedPropertyResolver(env, "spring.datasource").getSubProperties(".");
			Map<String, Object> values = new HashMap<>(rpr);
			// 排除已经设置的属性
			values.remove("type");
			values.remove("driver-class-name");
			values.remove("url");
			values.remove("username");
			values.remove("password");
			dataSourcePropertyValues = new MutablePropertyValues(values);
		}
		dataBinder.bind(dataSourcePropertyValues);
	}

	/**
	 * 
	 * @Method:registerBean
	 * @Description:注册Bean到Spring
	 * @Time 2017年12月6日 上午11:55:27
	 * @author: Tom
	 * @param registry
	 * @param name
	 * @param beanClass
	 */
	private void registerBean(BeanDefinitionRegistry registry, String name, Class<?> beanClass) {
		AnnotatedGenericBeanDefinition abd = new AnnotatedGenericBeanDefinition(beanClass);

		ScopeMetadata scopeMetadata = this.scopeMetadataResolver.resolveScopeMetadata(abd);
		abd.setScope(scopeMetadata.getScopeName());
		// 可以自动生成name
		String beanName = (name != null ? name : this.beanNameGenerator.generateBeanName(abd, registry));

		AnnotationConfigUtils.processCommonDefinitionAnnotations(abd);

		BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(abd, beanName);
		BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, registry);
	}

}
