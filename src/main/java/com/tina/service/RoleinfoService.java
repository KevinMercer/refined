/**
 * 
 */
package com.tina.service;

import java.util.List;
import java.util.Map;

import com.tina.entity.Permission;
import com.tina.entity.Roleinfo;
import com.tina.entity.RoleinfoExample;

/**
 * @author 何悟隆
 *
 */
public interface RoleinfoService {
	
	int addRoleinfo(Roleinfo roleinfo);
	
	int distributePermission(Integer[] perids, Integer roleId);
	
	int removeSingleRoleinfoByRoleId(Integer roleId);
	
	int removeSingleRoleinfoByRoleName(String roleName);
	
	int removeBatchRoleinfo(Integer[] roleIds);
	
	int removeDistribute(Integer roleId);
	
	int modifyRoleinfoByRoleId(Roleinfo roleinfo);
	
	int queryCountsRoleinfoWithCondition(String key);
	
	Roleinfo querySingleRoleinfoByRoleId(Integer roleId);
	
	Roleinfo querySingleRoleinfoByRoleName(String roleName);
	
	List<Roleinfo> queryRoleinfoAll();
	
	List<Roleinfo> queryRoleinfoByPage(Map<String, Object> map);
	
	int modifyRoleinfoByExample(Roleinfo roleinfo, RoleinfoExample roleinfoExample);
	
	List<Permission> queryPermissionByRoleId(Integer roleId);
	
}
