package cn.itcast.zjw.design.builder.csdn;

public class Client {
	public static void main(String[] args) {
		//这个类的实现是具体的创建者
        Builder builder = new ConcreteBuilder();
        //这个类中进行指导创建者如何创建相关对象
        Director director = new Director(builder);
        //指导创建者进行创建的具体方法
        director.construct();
        //充创建者手中拿到这个对象
        Product product = builder.retrieveResult();
        System.out.println(product.getPart1());
        System.out.println(product.getPart2());
    }
}
