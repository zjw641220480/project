package org.shiro.spring.service;

import org.shiro.spring.dao.PermissionDaoImpl;
import org.shiro.spring.dao.inter.PermissionDao;
import org.shiro.spring.entity.Permission;
import org.shiro.spring.service.inter.PermissionService;

public class PermissionServiceImpl implements PermissionService{

	private PermissionDao permissionDao = new PermissionDaoImpl();

    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }

}
