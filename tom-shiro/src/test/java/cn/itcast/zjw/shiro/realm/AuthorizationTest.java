package cn.itcast.zjw.shiro.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class AuthorizationTest {

	public static void main(String[] args) {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:ini/shiro_permission.ini");

		// 创建SecurityManager
		SecurityManager securityManager = factory.getInstance();

		// 将SecurityManager设置到系统运行环境，和Spring整合后将SecurityManager配置到Spring容器中，一般是单例管理
		SecurityUtils.setSecurityManager(securityManager);

		// 从SecurityUtils里边创建一个subject
		Subject subject = SecurityUtils.getSubject();

		// 执行认证
		// 在认证提交前准备token（令牌）
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123456");

		try {
			// 执行认证提交
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		System.out.println(subject.isAuthenticated());
		// 认证通过后才执行授权
		// 基于角色的授权，传入的是角色标识符
		boolean isHasRole = subject.hasRole("role2");
		System.out.println(isHasRole);
		// 基于资源的授权,传入的是资源标识符
		boolean isPermissioned = subject.isPermitted("user:create");
		System.out.println(isPermissioned);
	}
}
