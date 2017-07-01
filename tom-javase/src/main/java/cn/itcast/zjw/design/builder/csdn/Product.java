package cn.itcast.zjw.design.builder.csdn;

/**
 * 
 * <p>Titile:Product</p>
 * <p>Description: 产品角色,产品类product,也就是要生产的产品</p>
 * @author TOM
 * @date 2017年7月1日 下午3:49:57
 */
public class Product {
	//定义一些产品的部件
	private String part1;
    private String part2;

    public String getPart1() {
        return part1;
    }
    public void setPart1(String part1) {
        this.part1 = part1;
    }
    public String getPart2() {
        return part2;
    }
    public void setPart2(String part2) {
        this.part2 = part2;
    }
}
