package org.shiro.spring.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;
import org.shiro.spring.entity.User;

public class MyRealm3 implements Realm{

	public String getName() {
		return "c"; //realm name 为 “c”
	}

	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}

	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		User user = new User("zhang", "123");
        return new SimpleAuthenticationInfo(
                user, //身份 User类型
                "123",   //凭据
                getName() //Realm Name
        );
	}

}
