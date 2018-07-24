/**
 * 
 */
package com.tina.service;

import java.util.List;
import java.util.Map;


import com.tina.entity.Userinfo;
import com.tina.entity.UserinfoContainRoleinfo;
import com.tina.entity.UserinfoExample;

/**
 * @author 何悟隆
 *
 */
public interface UserinfoService {

	int addUserinfo(Userinfo userinfo);

	int modifyUserinfoByPrimaryKey(Userinfo userinfo);

	int modifyUserinfoByExample(Userinfo userinfo, UserinfoExample userinfoExample);

	int removeUserinfoByPrimaryKey(Integer userId);
	
	int removeUserinfoBatch(Integer[] userIds);

	List<Userinfo> queryUserinfoList();

	List<UserinfoContainRoleinfo> queryUserinfoContainRoleinfoByPage(Map<String, Object> map);
	
	int queryCountsUserinfoWithConditions(String key);

	Userinfo querySingleUserinfoByPrimaryKey(Integer userId);

	Userinfo querySingleUserinfoByUsername(String username);
	
	Userinfo querySingleUserinfoByDoubleKey(String username, String password);
	
}
