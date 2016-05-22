package cn.itcast.zjw.mybatis.domain;

/**
 * ClassName: OrdersCustomer 
 * @Description: 订单的扩展类;演示一对一查询.
 * @author Tom
 * @date 2015-12-24
 */
//通过此类能映射订单和用户查询的结果;让此类去继承较多的pojo
public class OrdersCustomer extends Orders{
	//添加用户的属性
	private String username;
	private String sex;
	private String address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "OrdersCustomer [username=" + username + ", sex=" + sex
				+ ", address=" + address + "]";
	}
}
