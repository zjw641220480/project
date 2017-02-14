package cn.itcast.zjw.mybatis.pojo;

import java.util.List;

/**
 * ClassName: UserQueryVo
 * 
 * @Description: 用户包装类型,主要用于高级查询
 * @author Tom
 * @date 2015-12-21
 */
public class UserQueryVo {
	// 在这里包装所需要的查询条件
	private List<Integer> ids;
	// 用户查询条件;
	private UserCustomer userCustomer;
	// 可以包装其他查询条件,订单,商品;

	public UserCustomer getUserCustomer() {
		return userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
}
