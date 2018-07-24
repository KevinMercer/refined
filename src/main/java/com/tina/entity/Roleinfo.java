package com.tina.entity;

/**
 * 
 * @author 何悟隆
 * @datetime 2018年5月1日 下午1:59:13
 *
 */
public class Roleinfo {
	private Integer roleId;

	private String roleName;

	private String roleDesc;

	/**
	 * 
	 */
	public Roleinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param roleId
	 * @param roleName
	 * @param roleDesc
	 */
	public Roleinfo(Integer roleId, String roleName, String roleDesc) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}

	/**
	 * @param roleName
	 * @param roleDesc
	 */
	public Roleinfo(String roleName, String roleDesc) {
		super();
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}

	/**
	 * @param roleName
	 */
	public Roleinfo(String roleName) {
		super();
		this.roleName = roleName;
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
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleDesc
	 */
	public String getRoleDesc() {
		return roleDesc;
	}

	/**
	 * @param roleDesc
	 *            the roleDesc to set
	 */
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Roleinfo [" + (roleId != null ? "roleId=" + roleId + ", " : "") + (roleName != null ? "roleName=" + roleName + ", " : "") + (roleDesc != null ? "roleDesc=" + roleDesc : "") + "]";
	}

}