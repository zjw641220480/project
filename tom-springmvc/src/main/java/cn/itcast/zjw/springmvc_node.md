# tom-springmvc
controller.returns:此类演示了基本的SpringMvc三种返回方式的书写,以及他们实现请求转发和重定向的各种实现方式;
controller.original:此包演示了,使用原始适配器时候的两种Handler编写方式,以及一种现在情况的Handler;
controller.items:此包中讲述的比较多,主要可以分为如下几个方面:
	A:演示RequestMapping的使用以及注解(@Controller)开发;
	B:简单的使用SpringMvc进行增删改查;
	C:最原始方式的参数绑定,initBinder方法,以及使用@initBinder注解来开发;
	D:数据回显的三种凡是;1:使用Model,2:name和controller中一致,和第一个方法差不多,需要设置到Model中,3:使用ModelAttribute注解,将返回值回显给页面,
controller.upload:此包主要讲述的是上传下载;需要文件上传的解析器,但并不需要再注册到适配器中;
controller.json:此包主要讲述了json数据的交互,需要加入jackson包支持,老版本处理器适配器中需要注入SpringMvc的json解析类,新版本中不再需要,已经内置;配置完成后,只需要在bean上添加即可;最后在Controller中在要校验的Bean前面加上@Validated注解进行校验,而且后面也还需要添加上BindingResult参数;校验分组时候,只需要定义一个空接口;
exception:统一异常处理,自己定义的异常类,应用中抛出自己定义的异常;实现HandlerExceptionResolver接口的异常处理类,统一转到一个页面;需要在springmvc里面;
controller.interceptor:拦截器的实现,实现HandlerInterceptor接口,在springmvc中进行配置;

util.propertyeditor:第二种方式属性编辑器(实现PropertyEditorRegistrar类);
	此种方式需要注入将自己编写的属性编辑器绑定到ConfigurableWebBindingInitializer上并且注册到适配器中;
util.converter:第三种是使用转换器来实现自定义参数绑定;
	使用此种方式需要在最新的注解适配器中进行配置,并且需要将这些转换器(Converter)注入到FormattingConversionServiceFactoryBean类的converters属性中
	
在web.xml中使用filter过滤器解决了POST乱码问题,


最新的mvc适配器解析器中需要注入的基本只有自定义参数转换器和校验器两个了;老版本的适配器中通过ConfigurableWebBindingInitializer类注入自定义参数转换器和检验器,最后将这个类注入到适配器中,然后再加上一个json解析器;