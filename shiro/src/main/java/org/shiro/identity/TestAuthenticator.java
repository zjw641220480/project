package org.shiro.identity;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.shiro.util.ShiroUtil;

public class TestAuthenticator {
	@Test
	public void testAll(){
		Subject subject = ShiroUtil.getSubject("classpath:shiro\\identity\\shiro-authenticator-all-success.ini");
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		subject.login(token);
		System.out.println("TestAuthenticator.testAll()");
		subject.logout();
	}
	@Test
	public void testFirst(){
		Subject subject = ShiroUtil.getSubject("classpath:shiro\\identity\\shiro-authenticator-first-success.ini");
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		subject.login(token);
		System.out.println(subject.getPreviousPrincipals());
		System.out.println("TestAuthenticator.testAll()");
		subject.logout();
	}
}
