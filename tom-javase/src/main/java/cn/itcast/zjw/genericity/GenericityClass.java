package cn.itcast.zjw.genericity;

/**
 * 泛型类泛型方法的说明
 * 泛型类---->当类中要操作的引用数据类型不确定的时候,早期定义Object来完成扩展,现在定义泛型来完成扩展,泛型变量放置在返回值的前面
 * 泛型类定义的泛型,在整个类中有效,如果被方法使用,那么泛型类的对象,明确要操作的具体类型后,所有要操作的类型就已经是固定了;
 * 泛型变量定义在泛型类上,其作用范围相当于实例变量(全局变量),并不能直接使用;
 * 为了让不同的方法可以操作不同类型,而且类型还不确定,那么将泛型定义在方法上;
 * 
 * 特殊地方,静态方法不可以访问类上定义的泛型;如果静态方法如果静态方法操作的应用数据类型不确定,可以将泛型定义在方法上, ClassName:
 * GenericityClass
 * 
 * @Description: TODO
 * @author Tom
 * @date 2016年4月9日
 */
public class GenericityClass<T> {
	// 这里在定义的时候,只有是在泛型类中才能这样来定义T变量
	private T t;

	public T getT() {
		System.out.println(this.toString());
		System.out.println("GenericityClass.getT()");
		System.out.println("泛型类中的getT()方法运行");
		return t;
	}

	public void setT(T t) {
		System.out.println(this.toString());
		System.out.println("GenericityClass.setT()");
		System.out.println("泛型类中的setT()方法运行");
		this.t = t;
	}

	/**
	 * 泛型方法并不要求一定定义在泛型类中,泛型可以看成是一个自己定义的变量类型; 方法中的泛型变量,和方法中的变量作用范围一致
	 * @param <E>
	 * 
	 * @Description: TODO
	 * @param e
	 * @return void
	 * @author Tom
	 * @date 2016年4月9日
	 */
	public <E> void show(E e) {
		System.out.println(this.toString());
		System.out.println("GenericityClass.show()");
		System.out.println("泛型类中的show方法运行");
		System.out.println("传递的泛型方法中的参数E的hash值为:\t" + e);
	}

	/**
	 * @Description: 静态泛型方法中的泛型
	 * @param s
	 * @return void
	 * @throws @author
	 *             Tom
	 * @date 2016年4月9日
	 */
	public static <S> void staticMethos(S s) {
		System.out.println(GenericityClass.class);
		System.out.println("GenericityClass.staticMethos()");
		System.out.println("传递的 静态泛型 方法中的参数S:\t" + s);
	}
}
