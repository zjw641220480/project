/**
 * @Project: tom-shiro @(#) SysServiceImpl.java
 * 
 * Copyright (c) 2016, Credan-版权所有
 * 
 */
package cn.itcast.zjw.shiro.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.zjw.shiro.dao.SysUserMapper;
import cn.itcast.zjw.shiro.exception.CustomException;
import cn.itcast.zjw.shiro.po.ActiveUser;
import cn.itcast.zjw.shiro.po.SysUser;
import cn.itcast.zjw.shiro.po.SysUserExample;
import cn.itcast.zjw.shiro.service.SysService;
import cn.itcast.zjw.shiro.util.MD5;

/**
 * @ClassName: SysServiceImpl
 * @Description:
 * @Time 2016年6月29日 下午9:40:21
 * @author: TOM
 * @version 1.0.0
 * @since 1.6
 */
@Service(value = "sysServiceImpl")
public class SysServiceImpl implements SysService {
	@Resource(name="sysUserMapper")
	private SysUserMapper sysUserMapper;
	
	public ActiveUser authenticat(String userCode, String password)
			throws Exception {
		// 根据用户账号查询用户信息;
		SysUser sysUser = this.findSysUserByUserCode(userCode);
		if(sysUser==null){
			//跑出异常
			throw new CustomException("用户账号不存在");
		}
		// 数据库中的密码(md5加密)
		
		String password_db = sysUser.getPassword();
		String password_input_md5 = new MD5().getMD5ofStr(password);
		if(!password_input_md5.equalsIgnoreCase(password_db)){
			// 抛出异常
			throw new CustomException("用户名或密码错误");
		}
		// 认证通过
		ActiveUser activeUser = new ActiveUser();
		activeUser.setUserid(sysUser.getId());
		activeUser.setUsercode(userCode);
		activeUser.setUsername(sysUser.getUsername());
		return activeUser;
	}
	
	//根据用户账号查询用户信息
	public SysUser findSysUserByUserCode(String userCode) throws Exception{
		SysUserExample sysUserExample = new SysUserExample();
		SysUserExample.Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo(userCode);
		List<SysUser> list = this.sysUserMapper.selectByExample(sysUserExample);
		if(list!=null && list.size()==1){
			return list.get(0);
		}
		return null;
	}
}
