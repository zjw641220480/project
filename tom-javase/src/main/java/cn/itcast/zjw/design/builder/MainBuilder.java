package cn.itcast.zjw.design.builder;

/**
 * @Description <p>
 *              Builder设计模式测试
 *              </p>
 * @author TOM
 * @date 2016年5月20日 下午3:58:36
 * @version V1.3.1
 */
public class MainBuilder {
	public static void main(String[] args) {
		StudentBuilderDemo.Builder builder = new StudentBuilderDemo.Builder();
		StudentBuilderDemo builderClass = builder.name("name").age(123).builder();
		System.out.println(builderClass);
		StudentBuilderDemo builderDemo = builder.name("张三").sex("nan").builder();
		System.out.println(builderDemo);
	}
}
