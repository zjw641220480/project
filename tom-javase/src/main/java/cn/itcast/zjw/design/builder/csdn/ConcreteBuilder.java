package cn.itcast.zjw.design.builder.csdn;

/**
 * 
 * <p>Titile:ConcreteBuilder</p>
 * <p>Description:具体的建造者 </p>
 * @author TOM
 * @date 2017年7月1日 下午3:51:42
 */
public class ConcreteBuilder implements Builder{
	private Product product = new Product();
	public void buildPart1() {
		//构建产品的第一个零件
        product.setPart1("编号：007");
	}

	public void buildPart2() {
		//构建产品的第二个零件
        product.setPart2("名称：暗黑者");
	}
	//返回产品
	public Product retrieveResult() {
		return product;
	}

}
