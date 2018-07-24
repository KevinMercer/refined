/**
 * 
 */
package com.tina.entity;

import java.util.Date;


/**
 * 
 * @author 何悟隆
 * @datetime 2018年5月1日 下午1:59:39
 *
 */
public class UserinfoContainRoleinfo extends Userinfo {

	private Roleinfo roleinfo;

	/**
	 * 
	 */
	public UserinfoContainRoleinfo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userId
	 * @param username
	 * @param password
	 * @param roleId
	 * @param borndate
	 * @param realname
	 * @param email
	 */
	public UserinfoContainRoleinfo(Integer userId, String username, String password, Integer roleId, Date borndate, String realname, String email) {
		super(userId, username, password, roleId, borndate, realname, email);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param username
	 * @param password
	 * @param roleId
	 * @param borndate
	 * @param realname
	 * @param email
	 */
	public UserinfoContainRoleinfo(String username, String password, Integer roleId, Date borndate, String realname, String email) {
		super(username, password, roleId, borndate, realname, email);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param username
	 * @param password
	 */
	public UserinfoContainRoleinfo(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param username
	 * @param password
	 * @param roleId
	 */
	public UserinfoContainRoleinfo(String username, String password, Integer roleId) {
		super(username, password, roleId);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the roleinfo
	 */
	public Roleinfo getRoleinfo() {
		return roleinfo;
	}

	/**
	 * @param roleinfo
	 *            the roleinfo to set
	 */
	public void setRoleinfo(Roleinfo roleinfo) {
		this.roleinfo = roleinfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserinfoContainRoleinfo [" + (roleinfo != null ? "roleinfo=" + roleinfo + ", " : "") + (getRoleinfo() != null ? "getRoleinfo()=" + getRoleinfo() + ", " : "") + (getUserId() != null ? "getUserId()=" + getUserId() + ", " : "")
						+ (getUsername() != null ? "getUsername()=" + getUsername() + ", " : "") + (getPassword() != null ? "getPassword()=" + getPassword() + ", " : "") + (getRoleId() != null ? "getRoleId()=" + getRoleId() + ", " : "")
						+ (getBorndate() != null ? "getBorndate()=" + getBorndate() + ", " : "") + (getRealname() != null ? "getRealname()=" + getRealname() + ", " : "") + (getEmail() != null ? "getEmail()=" + getEmail() + ", " : "")
						+ (super.toString() != null ? "toString()=" + super.toString() + ", " : "") + (getClass() != null ? "getClass()=" + getClass() + ", " : "") + "hashCode()=" + hashCode() + "]";
	}

}
