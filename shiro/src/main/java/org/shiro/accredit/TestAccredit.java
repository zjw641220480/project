package org.shiro.accredit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;
import org.tom.util.shiro.ShiroUtil;

public class TestAccredit {
	/**
	 * 判断用户权限第一例
	 */
	@Test
	public void testHasRole() {

		String shiroConfigPath = "classpath:shiro\\accredit\\shiro-role.ini";
		Subject subject = ShiroUtil.getSubject(shiroConfigPath);
		UsernamePasswordToken token = new UsernamePasswordToken("wang", "123");
		subject.login(token);
		// 判断拥有角色role1
		Assert.assertTrue(subject.hasRole("role1"));
		// 判断拥有角色role1和role2
		// 不具有role2角色,所以抛出异常
		System.out.println((subject.hasAllRoles(Arrays.asList("role1","role2"))));
		// 判断拥有角色：role1 and role2 and !role3
		boolean[] result = subject.hasRoles(Arrays.asList("role1", "role2",
				"role3"));
		Assert.assertEquals(true, result[0]);
		// 也不具有role2角色,所以跑出异常
		// Assert.assertEquals(true, result[1]);
		Assert.assertEquals(false, result[2]);
		for (boolean b : result) {
			System.out.println(b);
		}
	}
	/**
	 * 断言是否拥有角色
	 */
	@Test
	public void testCheckRole(){
		String shiroConfigPath = "classpath:shiro\\accredit\\shiro-role.ini";
		Subject subject = ShiroUtil.getSubject(shiroConfigPath);
		UsernamePasswordToken token = new UsernamePasswordToken("wang", "123");
		subject.login(token);
		subject.checkRole("role1");
		subject.checkRoles("role1","role3");
	}
	/**
	 * 权限判断
	 */
	@Test
	public void testIsPermitted() {
		String shiroConfigPath = "classpath:shiro\\accredit\\shiro-permission.ini";
		Subject subject = ShiroUtil.getSubject(shiroConfigPath);
		UsernamePasswordToken token = new UsernamePasswordToken("wang", "123");
		subject.login(token);
		// 判断拥有权限：user:create
		System.out.println(subject.isPermitted("user:create"));
		// 判断拥有权限：user:update anduser:delete
		System.out.println(subject.isPermittedAll("user:update", "user:delete"));
		// 判断没有权限：user:view
		System.out.println(subject.isPermitted("user:view"));
	}

	/**
	 * 断言拥有权限
	 */
	@Test
	public void testCheckPermission() {
		String shiroConfigPath = "classpath:shiro\\accredit\\shiro-permission.ini";
		Subject subject = ShiroUtil.getSubject(shiroConfigPath);
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		subject.login(token);
		// 断言拥有权限：user:create
		subject.checkPermission("user:create");
		// 断言拥有权限：user:delete and user:update
		subject.checkPermissions("user:delete", "user:update");
		// 断言拥有权限：user:view 失败抛出异常
		System.out.println(subject.isPermittedAll("user:view"));
		System.out.println(subject.isPermitted("user:update"));
		System.out.println(subject.isPermitted("system:user:update"));
	}
}
