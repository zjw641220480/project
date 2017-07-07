# tom-javase-reflect
base.hello:首个Spring的案例;简单Bean的创建;
base.createobject:Spring三种创建Bean的方式;
	A:默认构造方法;
	B:静态工厂方法;
	C:实例工厂方法;
base.scope:Spring中对象的scope,(单例还是多例)
	A:singleton(默认值,为单例)
	B:prototype(每次使用都创建一个新的,对象的释放是客户自己的事情)
	C:Request
	D:Session
	E:GlobalSession
base.lazyscope:Spring中对象的延迟加载,对象的scope属性为prototype,默认采用延迟加载,正常的Bean都是在Spring容器启动时候进行创建
base.initdestory:Spring中初始化对象或销毁对象时候,需要做的事情,当对象为prototype时候,Spring中定义销毁方法是没有意义的;销毁方法只对singleton状态的Bean有效;
zjw.base.di:Spring注入,两种方式,通过构造方法和类中的set方法两种方式
	使用构造方法注入:
		A:根据构造方法顺序注入,从0开始,
		B:根据构造方法中参数名称注入,
		C:根据构造方法中参数类型注入,
	使用Set方法注入,
base.annotation:Spring相关注解开发,@Service,@Controller,@Repository,@Component
	@Resource,@PostConstruct在构造器之后执行,@PreDestroy在对象销毁之前,
	@Autowired,@Qualifier("student")对象注入
base.extend:Spring继承,不使用继承时候,在配置文件新增parent属性,注解开发不需要新增什么


		
		
		
		