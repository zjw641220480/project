# tom-javase-design
**装饰模式**:
在装饰模式中的相关角色:
1)抽象构建角色(Component):给出一个抽象接口,以规范准备接收附加责任的对象;
2)具体构建角色(ConcreteComponent):定义一个将要接收附加责任的类;
3)装饰角色(Decorator):持有一个构件(Component)对象的实例,并定义一个与抽象构件接口一致的接口;
4)具体装饰角色(ConcreteDecorator):负责给构件贴上附加的责任

按照自己方式总结的话,可以说是三类;
第一类:超类,被装饰的目标类的接口(父类);
第二类:目标类,被装饰的目标类,实现上面的超累,并且具有基本的功能;
第三类:装饰者类,其也要实现目标类的接口,而且这个具有自己的继承体系,有一个基类,以组合的方式,拥有最初的目标类,(可以设计成abstract)
	然后会有具体的装饰类,去继承这个装饰者类;

装饰模式的特点:
1)装饰对象和真实对象之间具有相同的接口,这样客户端就可以以真实对象相同的方式和装饰对象交互
2)装饰对象基类中包含一个真实对象的引用;
3)装饰对象接受所有来自客户端的请求,它把这些请求转发给真实的对象;
4)装饰对象可以在转发这些请求以前或者以后增加一些附加功能;(有一些SpringAop的意味)