/**
 * @File AdvancedDeptinfo.java
 * @Type AdvancedDeptinfo
 */
package com.tina.entity;

/**
 * @author 何悟隆
 * @datetime 2018年5月4日 下午10:12:36
 * 
 */
public class AdvancedDeptinfo extends Deptinfo {

	private Empinfo empinfo;
	
	private Integer member;

	/**
	 * @return the empinfo
	 */
	public Empinfo getEmpinfo() {
		return empinfo;
	}

	/**
	 * @param empinfo
	 *            the empinfo to set
	 */
	public void setEmpinfo(Empinfo empinfo) {
		this.empinfo = empinfo;
	}

	/**
	 * @return the member
	 */
	public Integer getMember() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(Integer member) {
		this.member = member;
	}
}
