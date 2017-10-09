package cn.itcast.zjw.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.annotation.Configuration;

import cn.itcast.zjw.shiro.po.ActiveUser;
import cn.itcast.zjw.shiro.po.SysPermission;
import cn.itcast.zjw.shiro.po.SysUser;
import cn.itcast.zjw.shiro.service.SysService;
/**
 * 
 * @ClassName: CustomerRealm.java
 * @Description:自定义Realm
 * @Time 2017年9月5日
 * @author: Tom
 */
@Configuration
public class CustomerRealm extends AuthorizingRealm{
	@Resource(name="sysServiceImpl")
	private SysService sysService;
	
	@Override
	public void setName(String name) {
		super.setName("customerRealm");
	}
	//用户认证,需要从数据库查询用户信息,查询用户表,以及菜单表；
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		try {
			// token是用户输入的(userName)
			String userCode = (String) token.getPrincipal();
			// 根据用户输入的userCode从数据库查询
			SysUser sysUser = sysService.findSysUserByUserCode(userCode);
			if (null == sysUser) {
				//throw new RuntimeException("用户不存在");
				return null;
			}
			String passWord = sysUser.getPassword();
			ActiveUser activeUser = new ActiveUser();
			activeUser.setUserId(sysUser.getId());
			activeUser.setUserCode(sysUser.getUsercode());
			activeUser.setUserName(sysUser.getUsername());
			// 根据用户Id查询用户相关菜单
			List<SysPermission> menus = sysService.findMenuListByUserId(sysUser.getId());
			// 将用户的菜单设置到activeuser
			activeUser.setMenus(menus);
			/**
			 * 三个参数：用户名，密码，
			 */
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(activeUser, passWord,ByteSource.Util.bytes(sysUser.getSalt()),
					this.getName());
			return authenticationInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//用于授权，需要查询权限表，
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 从principals中获取主身份信息
		// 将getPrimaryPrincipal方法返回值转为真实身份信息，在上边的doGetAuthenticationInfo认证通过后填充到SimpleAuthenticationInfo的userCode
		ActiveUser activeUser = (ActiveUser) principals.getPrimaryPrincipal();
		// 根据身份信息获取权限信息
		List<SysPermission> permissions = sysService.findPermissionListByUserId(activeUser.getUserId());
		//单独定义一个权限的集合，用于存放用户所拥有的权限
		List<String> permissionList = new ArrayList<String>();
		for(SysPermission permission:permissions) {
			//将数据库中的权限标识符放入集合
			System.out.println("用户拥有的权限：\t"+permission.getPercode());
			permissionList.add(permission.getPercode());
		}
		//将查到的权限数据,
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		//将上边查询到的授权信息填充到SimpleAuthorizationInfo对象中，
		authorizationInfo.addStringPermissions(permissionList);
		return authorizationInfo;
	}

}
