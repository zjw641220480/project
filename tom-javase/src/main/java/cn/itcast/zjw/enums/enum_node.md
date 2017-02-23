# tom-javase-enum
java中的枚举类;
	ColorEnum:Color枚举类
	EnumTest:只是对Color枚举类的测试
	Season:Season枚举类
	SimpleEnum:一个简单的枚举类对象,
	SimpleEnumTest:对简单枚举类SimpleEnum的测试
	SitchSeacon:对Season枚举类的测试
类中定义的每一个都是一个实例,每个实例都是一个对象,默认的这个对象中有一个String类型的name和一个int类型的ordinal;
枚举类本身没有任何构造方法的时候,调用的是自身的无参构造方法,并调用父类的构造方法对该对象进行赋值;

枚举类中的抽象方法,针对每一个实例,其都需要实现这个抽象方法;

每一个枚举类实例的创建,不论这个实例是使用何种构造方法进行创建,都需要调用父类的构造方法,对name和ordinal进行赋值,
多出来的变量值,是赋值给枚举类中其他变量的;

枚举在单独定义或使用的时候,不允许只有右边部分,而不写左边部分;