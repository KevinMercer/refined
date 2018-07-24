package com.tina.entity;

/**
 * 
 * @author 何悟隆
 * @datetime 2018年5月1日 下午1:59:25
 *
 */
public class RolePermissionKey {
	private Integer roleId;

	private Integer perid;

	/**
	 * @param roleId
	 * @param perid
	 */
	public RolePermissionKey(Integer roleId, Integer perid) {
		super();
		this.roleId = roleId;
		this.perid = perid;
	}

	/**
	 * 
	 */
	public RolePermissionKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param roleId
	 */
	public RolePermissionKey(Integer roleId) {
		super();
		this.roleId = roleId;
	}

	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the perid
	 */
	public Integer getPerid() {
		return perid;
	}

	/**
	 * @param perid
	 *            the perid to set
	 */
	public void setPerid(Integer perid) {
		this.perid = perid;
	}

}