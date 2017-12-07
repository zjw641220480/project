package cn.itcast.zjw.druid;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidDBConfig {
	@Value("${spring.datasource.url}")  
    private String dbUrl;  
  
    @Value("${spring.datasource.username}")  
    private String username;  
  
    @Value("${spring.datasource.password}")  
    private String password;  
  
    @Value("${spring.datasource.driver-class-name}")  
    private String driverClassName;  
    
    @Value("${spring.datasource.poolPreparedStatements}")  
    private boolean poolPreparedStatements;  
  
    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")  
    private int maxPoolPreparedStatementPerConnectionSize;  
  
    @Value("${spring.datasource.filters}")  
    private String filters;  
  
    @Value("{spring.datasource.connectionProperties}")  
    private String connectionProperties;  
    
    @Bean     //声明其为Bean实例  
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource  
    public DataSource dataSource() {  
        DruidDataSource datasource = new DruidDataSource();  
        datasource.setUrl(this.dbUrl);  
        datasource.setUsername(username);  
        datasource.setPassword(password);  
        datasource.setDriverClassName(driverClassName);  
        //configuration  
        try {  
            datasource.setFilters(filters);  
        } catch (SQLException e) {  
        	e.printStackTrace();
        }  
        datasource.setConnectionProperties(connectionProperties);  
        return datasource;  
    }  
    @Bean  
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {  
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();  
        sqlSessionFactoryBean.setDataSource(dataSource());  
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();  
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mappers/*.xml"));  
        return sqlSessionFactoryBean.getObject();  
    }  
  
    @Bean  
    public PlatformTransactionManager transactionManager() {  
        return new DataSourceTransactionManager(dataSource());  
    }  
}
