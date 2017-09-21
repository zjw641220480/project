package cn.itcast.zjw.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
/**
 * 
 * @ClassName: CustomerRealm.java
 * @Description:自定义Realm
 * @Time 2017年9月5日
 * @author: Tom
 */
public class CustomerRealmMd5 extends AuthorizingRealm{
	
	
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
		//模拟从数据库查询到的密码,散列值		这个散列后队名的明文密码为111111;
		String passWord = "f3694f162729b7d0254c6e40260bf15c";
		
		//如果查询不到返回null
		//如果查询到则返回认证信息AuthenticationInfo
		String salt = "qwerty";
		/**
		 * 三个参数：用户名，密码，
		 */
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userCode, passWord,ByteSource.Util.bytes(salt), this.getName());
		return authenticationInfo;
	}
	//用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		return null;
	}


}
