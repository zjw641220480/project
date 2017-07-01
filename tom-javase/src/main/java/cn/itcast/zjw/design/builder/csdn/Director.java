package cn.itcast.zjw.design.builder.csdn;

/**
 * 
 * <p>Titile:Director</p>
 * <p>Description:导演者角色 </p>
 * @author TOM
 * @date 2017年7月1日 下午3:53:16
 */
public class Director {
	/**
     * 持有当前需要使用的建造器对象
     */
    private Builder builder;
    /**
     * 构造方法，传入建造器对象
     * @param builder 建造器对象
     */
    public Director(Builder builder){
        this.builder = builder;
    }
    /**
     * 产品构造方法，负责调用各个零件建造方法,比如产品的生产顺序等
     */
    public void construct(){
        builder.buildPart1();
        builder.buildPart2();
    }
}
