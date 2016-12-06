package cn.itcast.zjw.mybatis.pojo;

import java.util.Date;
import java.util.List;

public class Orders {
	private Integer id;
	private Integer userId;
	private String number;
	private Date createtime;
	private String note;
	private String ordername;
	// 使用resultMap的时候映射User对象;
	private User user;
	// 订单明细;
	private List<Orderdetail> orderDetails;

	public List<Orderdetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<Orderdetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + userId + ", number=" + number + ", createtime=" + createtime
				+ ", note=" + note + ", user=" + user + "]";
	}
}
