package org.shiro.spring.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.shiro.spring.entity.User;

public class PasswordHelper {
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

	private String algorithmName = "md5";
	private final int hashIterations = 2;

	/**
	 * 这个方法就是对User进行加密罢了
	 * @param user
	 */
	public void encryptPassword(User user) {

		user.setSalt(randomNumberGenerator.nextBytes().toHex());

		String newPassword = new SimpleHash(algorithmName, user.getPassword(),
				ByteSource.Util.bytes(user.getCredentialsSalt()),
				hashIterations).toHex();

		user.setPassword(newPassword);
	}
}
