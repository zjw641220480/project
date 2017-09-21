package cn.itcast.zjw.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
/**
 * 
 * @ClassName: CustomerRealm.java
 * @Description:自定义Realm
 * @Time 2017年9月5日
 * @author: Tom
 */
public class CustomerRealm extends AuthorizingRealm{
	
	
	@Override
	public void setName(String name) {
		super.setName("customerRealm");
	}
	//用户认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//token是用户输入的(userName)
		String userCode = (String) token.getPrincipal();
		//根据用户输入的userCode从数据库查询
		//模拟从数据库查询到的密码
		String passWord = "123456";
		//如果查询不到返回null
		//如果查询到则返回认证信息AuthenticationInfo
		/**
		 * 三个参数：用户名，密码，
		 */
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userCode, passWord, this.getName());
		return authenticationInfo;
	}
	//用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 从principals中获取主身份信息
		// 将getPrimaryPrincipal方法返回值转为真实身份信息，在上边的doGetAuthenticationInfo认证通过后填充到SimpleAuthenticationInfo的userCode
		String userCode = (String) principals.getPrimaryPrincipal();
		// 根据身份信息获取权限信息
		
		// 模拟从数据库获取到的数据
		List<String> permissionLists = new ArrayList<String>();
		permissionLists.add("user:create");
		permissionLists.add("items:add");
		//将查到的权限数据,
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		//将上边查询到的授权信息填充到SimpleAuthorizationInfo对象中，
		authorizationInfo.addStringPermissions(permissionLists);
		
		return authorizationInfo;
	}


}
