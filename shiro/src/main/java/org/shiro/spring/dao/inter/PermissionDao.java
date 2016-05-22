package org.shiro.spring.dao.inter;

import org.shiro.spring.entity.Permission;

public interface PermissionDao {
	public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);
}
