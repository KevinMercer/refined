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
import com.tina.entity.Permission;
import com.tina.entity.PermissionExample;
import com.tina.service.PermissionService;

/**
 * @author 何悟隆
 *
 */
@Service
public class PermissionServiceImp implements PermissionService {

	@Resource
	private PermissionMapper permissionMapper;
	@Resource
	private RolePermissionMapper rolePermissionMapper;
	private int effectRow, counts;
	private List<Integer> perids;
	private List<Permission> permissions;
	private Permission permission;
	private String perURL;

	/**
	 * 
	 */
	public PermissionServiceImp() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tina.service.PermissionService#addPermission(com.tina.entity.
	 * Permission)
	 */
	@Override
	public int addPermission(Permission permission) {
		// TODO Auto-generated method stub
		if (permission == null) {
			return -1;
		}
		effectRow = permissionMapper.insertSelective(permission);
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.PermissionService#removePermissionByPerid(java.lang.
	 * Integer)
	 */
	@Override
	public int removePermissionByPerid(Integer perid, Integer oldParent) {
		// TODO Auto-generated method stub
		if (perid == null) {
			return -1;
		}
		counts = permissionMapper.selectChildrenByParentid(perid);
		if (counts >= 1) {
			return -2;
		}
		effectRow = permissionMapper.deleteByPrimaryKey(perid);
		counts = permissionMapper.selectChildrenByParentid(oldParent);
		if (counts <= 0) {
			this.permission = new Permission(oldParent, 0);
			permissionMapper.updateByPrimaryKeySelective(permission);
		}
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.PermissionService#removePermissionByPername(java.lang.
	 * String)
	 */
	@Override
	public int removePermissionByPername(String pername) {
		// TODO Auto-generated method stub
		if (pername == null) {
			return -1;
		}
		effectRow = permissionMapper.deleteByUniqueKey(pername);
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.PermissionService#removeBatchPermission(java.util.List)
	 */
	@Override
	public int removeBatchPermission(Integer[] perids) {
		// TODO Auto-generated method stub
		if (perids == null || perids.length <= 0) {
			return -1;
		}
		this.perids = new ArrayList<Integer>();
		for (int i = 0; i < perids.length; i++) {
			if (perids[i] == null) {
				// 若有一项perid为空，则属于业务层有异常，业务层应该过滤数据，保证数据不能为空
				return -1;
			}
			counts = permissionMapper.selectChildrenByParentid(perids[i]);
			if (counts >= 1) {
				return -2;
			}
			this.perids.add(perids[i]);
		}
		effectRow = permissionMapper.deleteBatch(this.perids);
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.PermissionService#modifyPermissionByPrimaryKey(com.tina.
	 * entity.Permission)
	 */
	@Override
	public int modifyPermissionByPrimaryKey(Permission permission, Integer oldParent) {
		// TODO Auto-generated method stub
		if (permission == null || oldParent == null) {
			return -1;
		}
		effectRow = permissionMapper.updateByPrimaryKeySelective(permission);
		this.permission = new Permission(permission.getParentid(), 1);
		permissionMapper.updateByPrimaryKeySelective(this.permission);
		counts = permissionMapper.selectChildrenByParentid(oldParent);
		if (counts <= 0) {
			this.permission = new Permission(oldParent, 0);
			permissionMapper.updateByPrimaryKeySelective(this.permission);
		}
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.PermissionService#modifyPermissionByExample(com.tina.
	 * entity.Permission, com.tina.entity.PermissionExample)
	 */
	@Override
	public int modifyPermissionByExample(Permission permission, PermissionExample permissionExample) {
		// TODO Auto-generated method stub
		if (permission == null || permissionExample == null) {
			return -1;
		}
		effectRow = permissionMapper.updateByExampleSelective(permission, permissionExample);
		return effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tina.service.PermissionService#queryPermissionsAll()
	 */
	@Override
	public List<Permission> queryPermissionsAll() {
		// TODO Auto-generated method stub
		permissions = permissionMapper.selectAll();
		return permissions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.PermissionService#queryPermissionByPage(java.util.Map)
	 */
	@Override
	public List<Permission> queryPermissionByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		if (map == null) {
			return queryPermissionsAll();
		}
		permissions = permissionMapper.selectByPage(map);
		return permissions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.PermissionService#querySinglePermissionByPerid(java.lang
	 * .Integer)
	 */
	@Override
	public Permission querySinglePermissionByPerid(Integer perid) {
		// TODO Auto-generated method stub
		if (perid == null) {
			return permission;
		}
		permission = permissionMapper.selectByPrimaryKey(perid);
		System.out.println("permission service permission = " + permission);
		return permission;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tina.service.PermissionService#querySinglePermissionBypername(java.
	 * lang.String)
	 */
	@Override
	public Permission querySinglePermissionBypername(String pername) {
		// TODO Auto-generated method stub
		if (pername == null) {
			return permission;
		}
		permission = permissionMapper.selectByUniqueKey(pername);
		return permission;
	}

	@Override
	public List<Integer> queryPeridByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		if (roleId == null) {
			return perids;
		}
		perids = rolePermissionMapper.selectPeridByRoleId(roleId);
		return perids;
	}

	@Override
	public String queryPerURLByPerid(Integer perid) {
		// TODO Auto-generated method stub
		if (perid == null) {
			return perURL;
		}
		perURL = permissionMapper.selectPerURLByPerid(perid);
		return perURL;
	}

}
