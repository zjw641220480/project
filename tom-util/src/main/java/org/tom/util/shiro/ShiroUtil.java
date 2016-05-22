package org.tom.util.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;


public class ShiroUtil {
	private ShiroUtil(){}
	public static Subject getSubject(String shiroConfigPath){
		Factory<?> factory = new IniSecurityManagerFactory(shiroConfigPath);
		org.apache.shiro.mgt.SecurityManager securityManager =  (SecurityManager) factory.getInstance();
		SecurityUtils.setSecurityManager( securityManager);
		return SecurityUtils.getSubject();
	}
}
