/**
 * 
 */
package com.tina.entity;

import java.util.Date;

/**
 * 
 * @author 何悟隆
 * @datetime 2018年5月1日 下午1:58:32
 *
 */
public class AdvancedEmpinfo extends Empinfo {

	private Deptinfo deptinfo;
	private Roleinfo roleinfo;
	private Empinfo manager;

	/**
	 * 
	 */
	public AdvancedEmpinfo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param deptinfo
	 */
	public AdvancedEmpinfo(Deptinfo deptinfo) {
		this.deptinfo = deptinfo;
	}

	/**
	 * @param empno
	 * @param password
	 * @param empname
	 * @param deptno
	 * @param roleid
	 * @param salary
	 * @param hiredate
	 * @param superior
	 * @param telphone
	 * @param email
	 * @param deptinfo
	 */
	public AdvancedEmpinfo(Integer empno, String password, String empname, Integer deptno, Integer roleid, double salary, Date hiredate, Integer superior, String telphone, String email, Deptinfo deptinfo) {
		super(empno, password, empname, deptno, roleid, salary, hiredate, superior, telphone, email);
		this.deptinfo = deptinfo;
	}

	/**
	 * @param roleinfo
	 */
	public AdvancedEmpinfo(Roleinfo roleinfo) {
		super();
		this.roleinfo = roleinfo;
	}

	/**
	 * @param empno
	 * @param password
	 * @param empname
	 * @param deptno
	 * @param roleid
	 * @param salary
	 * @param hiredate
	 * @param superior
	 * @param telphone
	 * @param email
	 * @param roleinfo
	 */
	public AdvancedEmpinfo(Integer empno, String password, String empname, Integer deptno, Integer roleid, double salary, Date hiredate, Integer superior, String telphone, String email, Roleinfo roleinfo) {
		super(empno, password, empname, deptno, roleid, salary, hiredate, superior, telphone, email);
		this.roleinfo = roleinfo;
	}

	/**
	 * @param empno
	 * @param password
	 * @param empname
	 * @param deptno
	 * @param roleid
	 * @param salary
	 * @param hiredate
	 * @param superior
	 * @param telphone
	 * @param email
	 * @param deptinfo
	 * @param roleinfo
	 */
	public AdvancedEmpinfo(Integer empno, String password, String empname, Integer deptno, Integer roleid, double salary, Date hiredate, Integer superior, String telphone, String email, Deptinfo deptinfo, Roleinfo roleinfo) {
		super(empno, password, empname, deptno, roleid, salary, hiredate, superior, telphone, email);
		this.deptinfo = deptinfo;
		this.roleinfo = roleinfo;
	}

	/**
	 * @param deptinfo
	 * @param roleinfo
	 */
	public AdvancedEmpinfo(Deptinfo deptinfo, Roleinfo roleinfo) {
		super();
		this.deptinfo = deptinfo;
		this.roleinfo = roleinfo;
	}

	/**
	 * @param empno
	 * @param password
	 * @param empname
	 * @param deptno
	 * @param roleid
	 * @param salary
	 * @param hiredate
	 * @param superior
	 * @param telphone
	 * @param email
	 */
	public AdvancedEmpinfo(Integer empno, String password, String empname, Integer deptno, Integer roleid, double salary, Date hiredate, Integer superior, String telphone, String email) {
		super(empno, password, empname, deptno, roleid, salary, hiredate, superior, telphone, email);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param empno
	 * @param password
	 */
	public AdvancedEmpinfo(Integer empno, String password) {
		super(empno, password);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param empno
	 * @param password
	 * @param empname
	 */
	public AdvancedEmpinfo(Integer empno, String password, String empname) {
		super(empno, password, empname);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param superior
	 */
	public AdvancedEmpinfo(Integer superior) {
		super(superior);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the deptinfo
	 */
	public Deptinfo getDeptinfo() {
		return deptinfo;
	}

	/**
	 * @param deptinfo
	 *            the deptinfo to set
	 */
	public void setDeptinfo(Deptinfo deptinfo) {
		this.deptinfo = deptinfo;
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

	/**
	 * @return the manager
	 */
	public Empinfo getManager() {
		return manager;
	}

	/**
	 * @param manager
	 *            the manager to set
	 */
	public void setManager(Empinfo manager) {
		this.manager = manager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AdvancedEmpinfo [" + (deptinfo != null ? "deptinfo=" + deptinfo + ", " : "") + (roleinfo != null ? "roleinfo=" + roleinfo + ", " : "") + (manager != null ? "manager=" + manager + ", " : "") + (getDeptinfo() != null
						? "getDeptinfo()=" + getDeptinfo() + ", " : "") + (getRoleinfo() != null ? "getRoleinfo()=" + getRoleinfo() + ", " : "") + (getManager() != null ? "getManager()=" + getManager() + ", " : "") + (getEmpno() != null
										? "getEmpno()=" + getEmpno() + ", " : "") + (getPassword() != null ? "getPassword()=" + getPassword() + ", " : "") + (getEmpname() != null ? "getEmpname()=" + getEmpname() + ", " : "")
						+ (getDeptno() != null ? "getDeptno()=" + getDeptno() + ", " : "") + (getRoleid() != null ? "getRoleid()=" + getRoleid() + ", " : "") + "getSalary()=" + getSalary() + ", " + (getHiredate() != null ? "getHiredate()="
										+ getHiredate() + ", " : "") + (getSuperior() != null ? "getSuperior()=" + getSuperior() + ", " : "") + (getTelephone() != null ? "getTelphone()=" + getTelephone() + ", " : "") + (getEmail() != null
														? "getEmail()=" + getEmail() + ", " : "") + (super.toString() != null ? "toString()=" + super.toString() + ", " : "") + (getClass() != null ? "getClass()=" + getClass() + ", " : "")
						+ "hashCode()=" + hashCode() + "]";
	}

}
