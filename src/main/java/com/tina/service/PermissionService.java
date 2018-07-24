/**
 * 
 */
package com.tina.service;

import java.util.List;
import java.util.Map;

import com.tina.entity.Permission;
import com.tina.entity.PermissionExample;

/**
 * @author 何悟隆
 *
 */
public interface PermissionService {

	int addPermission(Permission permission);

	int removePermissionByPerid(Integer perid, Integer oldParent);

	int removePermissionByPername(String pername);

	int removeBatchPermission(Integer[] perids);

	int modifyPermissionByPrimaryKey(Permission permission, Integer oldParent);

	int modifyPermissionByExample(Permission permission, PermissionExample permissionExample);

	List<Permission> queryPermissionsAll();

	List<Permission> queryPermissionByPage(Map<String, Object> map);
	
	List<Integer> queryPeridByRoleId(Integer roleId);

	Permission querySinglePermissionByPerid(Integer perid);

	Permission querySinglePermissionBypername(String pername);
	
	String queryPerURLByPerid(Integer perid);

}
