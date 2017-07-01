package cn.itcast.zjw.design.builder.csdn;

/**
 * 
 * <p>Titile:Builder</p>
 * <p>Description: 抽象出来的建造者角色</p>
 * @author TOM
 * @date 2017年7月1日 下午3:50:55
 */
public interface Builder {
	//产品零件一建造方法
    public void buildPart1();
    //产品零件二建造方法
    public void buildPart2();
    //返回产品的方法
    public Product retrieveResult();
}
