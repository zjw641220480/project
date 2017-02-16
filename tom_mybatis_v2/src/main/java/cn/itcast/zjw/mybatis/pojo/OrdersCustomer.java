package cn.itcast.zjw.mybatis.pojo;

import java.util.List;

/**
 * ClassName: OrdersCustomer
 * 
 * @Description: 订单的扩展类;演示一对一查询.
 * @author Tom
 * @date 2015-12-24
 */
// 通过此类能映射订单和用户查询的结果;让此类去继承较多的pojo
public class OrdersCustomer extends Orders {
	// 添加用户的属性
	private String username;
	private String sex;
	private String address;
	//一对一的查询
	private User user;
	//一对多的resultMap
	private List<OrderDetail> orderDetails;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "OrdersCustomer [username=" + username + ", sex=" + sex + ", address=" + address + ", user=" + user
				+ ", orderDetails=" + orderDetails + "]";
	}

}
