/**
 * @Project: tom-shiro @(#) SysService.java
 * 
 * Copyright (c) 2016, Credan-版权所有
 * 
 */
package cn.itcast.zjw.shiro.service;

import cn.itcast.zjw.shiro.po.ActiveUser;

/** 
 * @ClassName: SysService
 * @Description:认证授权服务接口
 * @Time 2016年6月29日 下午9:36:44
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public interface SysService {
	// 根据用户的身份和密码进行认证,如果认证通过,返回用户身份信息;
	public ActiveUser authenticat(String userCode,String password) throws Exception;
	
}
