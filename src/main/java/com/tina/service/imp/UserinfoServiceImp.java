/**
 * 
 */
package com.tina.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tina.dao.UserinfoMapper;
import com.tina.entity.Userinfo;
import com.tina.entity.UserinfoContainRoleinfo;
import com.tina.entity.UserinfoExample;
import com.tina.entity.UserinfoExample.Criteria;
import com.tina.service.UserinfoService;

/**
 * @author 何悟隆
 *
 */
@Service
public class UserinfoServiceImp implements UserinfoService {

	@Resource
	private UserinfoMapper userinfoMapper;
	private List<Userinfo> userinfos;
	private List<UserinfoContainRoleinfo> userinfosContainRoleinfo;
	private List<Integer> userIds;
	private UserinfoExample userinfoExample;
	private Criteria usernameCriteria, realnameCriteria;
	private Userinfo userinfo;
	private Map<String, String> map;
	private int effectRow, counts;

	/**
	 * 
	 */
	public UserinfoServiceImp() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.UserinfoService#addUserinfo(com.tina.entity.Userinfo)
	 */
	@Override
	public int addUserinfo(Userinfo userinfo) {
		// TODO Auto-generated method stub
		if(userinfo == null){
			return -1;
		}
		effectRow = userinfoMapper.insertSelective(userinfo);
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.UserinfoService#modifyUserinfoByPrimaryKey(com.tina.
	 * entity.Userinfo)
	 */
	@Override
	public int modifyUserinfoByPrimaryKey(Userinfo userinfo) {
		// TODO Auto-generated method stub
		if(userinfo == null){
			return -1;
		}
		effectRow = userinfoMapper.updateByPrimaryKeySelective(userinfo);
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.UserinfoService#modifyUserinfoByExample(com.tina.entity.
	 * Userinfo, com.tina.entity.UserinfoExample)
	 */
	@Override
	public int modifyUserinfoByExample(Userinfo userinfo, UserinfoExample userinfoExample) {
		// TODO Auto-generated method stub
		if(userinfo == null || userinfoExample == null){
			return -1;
		}
		effectRow = userinfoMapper.updateByExampleSelective(userinfo, userinfoExample);
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.UserinfoService#removeUserinfoByPrimaryKey(java.lang.
	 * Integer)
	 */
	@Override
	public int removeUserinfoByPrimaryKey(Integer userId) {
		// TODO Auto-generated method stub
		if(userId == null){
			return -1;
		}
		effectRow = userinfoMapper.deleteByPrimaryKey(userId);
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tina.service.UserinfoService#queryUserinfoList()
	 */
	@Override
	public List<Userinfo> queryUserinfoList() {
		// TODO Auto-generated method stub
		userinfoExample = new UserinfoExample();
		userinfos = userinfoMapper.selectByExample(userinfoExample);
		return userinfos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tina.service.UserinfoService#queryUserinfoPage(java.util.Map)
	 */
	@Override
	public List<UserinfoContainRoleinfo> queryUserinfoContainRoleinfoByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		if(map == null){
			return userinfosContainRoleinfo;
		}
		userinfosContainRoleinfo = userinfoMapper.selectUserinfoContainRoleinfo(map);
		return userinfosContainRoleinfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.UserinfoService#querySingleUserinfoByPrimaryKey(java.
	 * lang.Integer)
	 */
	@Override
	public Userinfo querySingleUserinfoByPrimaryKey(Integer userId) {
		// TODO Auto-generated method stub
		if(userId == null){
			return userinfo;
		}
		userinfo = userinfoMapper.selectByPrimaryKey(userId);
		return userinfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.UserinfoService#querySingleUserinfoByUsername(java.lang.
	 * String)
	 */
	@Override
	public Userinfo querySingleUserinfoByUsername(String username) {
		// TODO Auto-generated method stub
		if(username == null){
			return userinfo;
		}
		userinfo = userinfoMapper.selectByUsername(username);
		return userinfo;
	}

	@Override
	public Userinfo querySingleUserinfoByDoubleKey(String username, String password) {
		// TODO Auto-generated method stub
		if (username == null || password == null) {
			return userinfo;
		}
		map = new HashMap<String, String>();
		map.put("username", username);
		map.put("password", password);
		userinfo = userinfoMapper.selectUserinfoByDoubleKey(map);
		return userinfo;
	}

	@Override
	public int queryCountsUserinfoWithConditions(String key) {
		// TODO Auto-generated method stub
		userinfoExample = new UserinfoExample();
		if(key != null && key != "" && !"".equals(key)){
			usernameCriteria = userinfoExample.createCriteria();
			realnameCriteria = userinfoExample.createCriteria();
			userinfoExample.or(realnameCriteria);
			usernameCriteria.andUsernameLike("%" + key + "%");
			realnameCriteria.andRealnameLike("%" + key + "%");
		}
		counts = (int)userinfoMapper.countByExample(userinfoExample);
		return counts;
	}

	@Override
	public int removeUserinfoBatch(Integer[] userIds) {
		// TODO Auto-generated method stub
		this.userIds = new ArrayList<>();
		for (int i = 0; i < userIds.length; i++) {
			if(userIds[i] == null){
				return -1;
			}
			this.userIds.add(userIds[i]);
		}
		effectRow = userinfoMapper.deleteBatch(this.userIds);
		return effectRow;
	}

}
