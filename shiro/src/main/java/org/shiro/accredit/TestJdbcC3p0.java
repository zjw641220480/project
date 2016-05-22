package org.shiro.accredit;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.tom.util.shiro.ShiroUtil;

public class TestJdbcC3p0 {
	@Test
	public void testJdbc(){
		Subject subject = ShiroUtil.getSubject("classpath:shiro\\accredit\\shiro-jdbc.ini");
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		subject.login(token);
		subject.logout();
	}
}
