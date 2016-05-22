package org.shiro.spring.service.inter;

import org.shiro.spring.entity.Permission;


public interface PermissionService {
	public Permission createPermission(Permission permission);
	public void deletePermission(Long permissionId);
}
