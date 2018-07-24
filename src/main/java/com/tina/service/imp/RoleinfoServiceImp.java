/**
 * 
 */
package com.tina.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tina.dao.PermissionMapper;
import com.tina.dao.RolePermissionMapper;
import com.tina.dao.RoleinfoMapper;
import com.tina.dao.UserinfoMapper;
import com.tina.entity.Permission;
import com.tina.entity.RolePermissionKey;
import com.tina.entity.Roleinfo;
import com.tina.entity.RoleinfoExample;
import com.tina.entity.RoleinfoExample.Criteria;
import com.tina.service.RoleinfoService;

/**
 * @author 何悟隆
 *
 */
@Service
public class RoleinfoServiceImp implements RoleinfoService {

	@Resource
	private RoleinfoMapper roleinfoMapper;
	@Resource
	private RolePermissionMapper rolePermissionMapper;
	@Resource
	private PermissionMapper permissionMapper;
	@Resource
	private UserinfoMapper userinfoMapper;
	private RolePermissionKey rolePermissionKey;
	private RoleinfoExample roleinfoExample;
	private List<Roleinfo> roleinfos;
	private List<Integer> roleIds;
	private List<Permission> permissions;
	private Roleinfo roleinfo;
	private int effectRow;
	private Criteria nameCriteria, descCriteria;
	private long counts;

	/**
	 * 
	 */
	public RoleinfoServiceImp() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.RoleinfoService#addRoleinfo(com.tina.entity.Roleinfo)
	 */
	@Override
	public int addRoleinfo(Roleinfo roleinfo) {
		// TODO Auto-generated method stub
		if (roleinfo == null) {
			return -1;
		}
		try {
			effectRow = roleinfoMapper.insertSelective(roleinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.RoleinfoService#removeSingleRoleinfoByRoleId(java.lang.
	 * Integer)
	 */
	@Override
	public int removeSingleRoleinfoByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		if (roleId == null) {
			return -1;
		}
		counts = userinfoMapper.selectUsersByRoleId(roleId);
		if (counts >= 1) {
			return -1;
		}
		rolePermissionMapper.deleteByRoleId(roleId);
		effectRow = roleinfoMapper.deleteByPrimaryKey(roleId);
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.RoleinfoService#removeSingleRoleinfoByRoleName(java.lang
	 * .String)
	 */
	@Override
	public int removeSingleRoleinfoByRoleName(String roleName) {
		// TODO Auto-generated method stub
		if (roleName == null) {
			return -1;
		}
		effectRow = roleinfoMapper.deleteByUniqueKey(roleName);
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tina.service.RoleinfoService#removeBatchRoleinfo(java.util.List)
	 */
	@Override
	public int removeBatchRoleinfo(Integer[] roleIds) {
		// TODO Auto-generated method stub
		if (roleIds == null || roleIds.length <= 0) {
			return -1;
		}
		this.roleIds = new ArrayList<Integer>();
		for (int i = 0; i < roleIds.length; i++) {
			if (roleIds[i] == null) {
				return -1;
			}
			counts = userinfoMapper.selectUsersByRoleId(roleIds[i]);
			if (counts >= 1) {
				return -1;
			}
			this.roleIds.add(roleIds[i]);
		}
		for (Integer roleId : this.roleIds) {
			rolePermissionMapper.deleteByRoleId(roleId);
		}
		effectRow = roleinfoMapper.deleteBatch(this.roleIds);
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.RoleinfoService#modifyRoleinfoByRoleId(com.tina.entity.
	 * Roleinfo)
	 */
	@Override
	public int modifyRoleinfoByRoleId(Roleinfo roleinfo) {
		// TODO Auto-generated method stub
		if (roleinfo == null) {
			return -1;
		}
		try {
			effectRow = roleinfoMapper.updateByPrimaryKeySelective(roleinfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.RoleinfoService#modifyRoleinfoByExample(com.tina.entity.
	 * Roleinfo, com.tina.entity.RoleinfoExample)
	 */
	@Override
	public int modifyRoleinfoByExample(Roleinfo roleinfo, RoleinfoExample roleinfoExample) {
		// TODO Auto-generated method stub
		if (roleinfo == null || roleinfoExample == null) {
			return -1;
		}
		try {
			effectRow = roleinfoMapper.updateByExampleSelective(roleinfo, roleinfoExample);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.RoleinfoService#querySingleRoleinfoByRoleId(java.lang.
	 * Integer)
	 */
	@Override
	public Roleinfo querySingleRoleinfoByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		if (roleId == null) {
			return roleinfo;
		}
		roleinfo = roleinfoMapper.selectByPrimaryKey(roleId);
		return roleinfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.RoleinfoService#querySingleRoleinfoByRoleName(java.lang.
	 * String)
	 */
	@Override
	public Roleinfo querySingleRoleinfoByRoleName(String roleName) {
		// TODO Auto-generated method stub
		if (roleName == null) {
			return roleinfo;
		}
		roleinfo = roleinfoMapper.selectByUniqueKey(roleName);
		return roleinfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tina.service.RoleinfoService#queryRoleinfoAll()
	 */
	@Override
	public List<Roleinfo> queryRoleinfoAll() {
		// TODO Auto-generated method stub
		roleinfos = roleinfoMapper.selectRoleinfoAll();
		return roleinfos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tina.service.RoleinfoService#queryRoleinfoByPage(java.util.Map)
	 */
	@Override
	public List<Roleinfo> queryRoleinfoByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return roleinfoMapper.selectByPage(map);
	}

	@Override
	public int queryCountsRoleinfoWithCondition(String key) {
		// TODO Auto-generated method stub
		roleinfoExample = new RoleinfoExample();
		if (key != null && key != "" && !"".equals(key)) {
			nameCriteria = roleinfoExample.createCriteria();
			descCriteria = roleinfoExample.createCriteria();
			roleinfoExample.or(descCriteria);
			nameCriteria.andRoleNameLike("%" + key + "%");
			descCriteria.andRoleDescLike("%" + key + "%");
		}
		counts = roleinfoMapper.countByExample(roleinfoExample);
		return (int) counts;
	}

	@Override
	public int distributePermission(Integer[] perids, Integer roleId) {
		// TODO Auto-generated method stub
		if (roleId == null || perids == null || perids.length <= 0) {
			return -1;
		}
		rolePermissionMapper.deleteByRoleId(roleId);
		rolePermissionKey = new RolePermissionKey(roleId);
		for (int i = 0; i < perids.length; i++) {
			if (perids[i] == null) {
				return -1;
			}
			rolePermissionKey.setPerid(perids[i]);
			effectRow += rolePermissionMapper.insert(rolePermissionKey);
		}
		return effectRow;
	}

	@Override
	public int removeDistribute(Integer roleId) {
		if (roleId == null) {
			return -1;
		}
		effectRow = rolePermissionMapper.deleteByRoleId(roleId);
		return effectRow;
	}

	@Override
	public List<Permission> queryPermissionByRoleId(Integer roleId) {
		if (roleId == null) {
			return permissions;
		}
		permissions = permissionMapper.selectPermissionByRoleId(roleId);
		return permissions;
	}

}
