package com.tina.entity;

/**
 * 
 */
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class Userinfo {
	private Integer userId;

	private String username;

	private String password;

	private Integer roleId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JSONField(format="yyyy-MM-dd")
	private Date borndate;

	private String realname;

	private String email;

	/**
	 * 
	 */
	public Userinfo() {
		super();
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
	public Userinfo(Integer userId, String username, String password, Integer roleId, Date borndate, String realname, String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
		this.borndate = borndate;
		this.realname = realname;
		this.email = email;
	}

	/**
	 * @param username
	 * @param password
	 * @param roleId
	 * @param borndate
	 * @param realname
	 * @param email
	 */
	public Userinfo(String username, String password, Integer roleId, Date borndate, String realname, String email) {
		super();
		this.username = username;
		this.password = password;
		this.roleId = roleId;
		this.borndate = borndate;
		this.realname = realname;
		this.email = email;
	}

	/**
	 * @param username
	 * @param password
	 */
	public Userinfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * @param username
	 * @param password
	 * @param roleId
	 */
	public Userinfo(String username, String password, Integer roleId) {
		super();
		this.username = username;
		this.password = password;
		this.roleId = roleId;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the borndate
	 */
	public Date getBorndate() {
		return borndate;
	}

	/**
	 * @param borndate
	 *            the borndate to set
	 */
	public void setBorndate(Date borndate) {
		this.borndate = borndate;
	}

	/**
	 * @return the realname
	 */
	public String getRealname() {
		return realname;
	}

	/**
	 * @param realname
	 *            the realname to set
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Userinfo [" + (userId != null ? "userId=" + userId + ", " : "") + (username != null ? "username=" + username + ", " : "") + (password != null ? "password=" + password + ", " : "") + (roleId != null ? "roleId=" + roleId
						+ ", " : "") + (borndate != null ? "borndate=" + borndate + ", " : "") + (realname != null ? "realname=" + realname + ", " : "") + (email != null ? "email=" + email : "") + "]";
	}

}