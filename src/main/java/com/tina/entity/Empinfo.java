package com.tina.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author 何悟隆
 * @datetime 2018年5月1日 下午1:58:51
 *
 */
public class Empinfo {
	private Integer empno;

	private String password;

	private String empname;

	private Integer deptno;

	private Integer roleid;

	private double salary;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JSONField(format="yyyy-MM-dd")
	private Date hiredate;

	private Integer superior;

	private String telephone;

	private String email;

	/**
	 * 
	 */
	public Empinfo() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @param telephone
	 * @param email
	 */
	public Empinfo(Integer empno, String password, String empname, Integer deptno, Integer roleid, double salary, Date hiredate, Integer superior, String telphone, String email) {
		super();
		this.empno = empno;
		this.password = password;
		this.empname = empname;
		this.deptno = deptno;
		this.roleid = roleid;
		this.salary = salary;
		this.hiredate = hiredate;
		this.superior = superior;
		this.telephone = telphone;
		this.email = email;
	}

	/**
	 * @param empno
	 * @param password
	 */
	public Empinfo(Integer empno, String password) {
		super();
		this.empno = empno;
		this.password = password;
	}

	/**
	 * @param empno
	 * @param password
	 * @param empname
	 */
	public Empinfo(Integer empno, String password, String empname) {
		super();
		this.empno = empno;
		this.password = password;
		this.empname = empname;
	}

	/**
	 * @param superior
	 */
	public Empinfo(Integer superior) {
		super();
		this.superior = superior;
	}

	/**
	 * @return the empno
	 */
	public Integer getEmpno() {
		return empno;
	}

	/**
	 * @param empno
	 *            the empno to set
	 */
	public void setEmpno(Integer empno) {
		this.empno = empno;
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
	 * @return the empname
	 */
	public String getEmpname() {
		return empname;
	}

	/**
	 * @param empname
	 *            the empname to set
	 */
	public void setEmpname(String empname) {
		this.empname = empname;
	}

	/**
	 * @return the deptno
	 */
	public Integer getDeptno() {
		return deptno;
	}

	/**
	 * @param deptno
	 *            the deptno to set
	 */
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	/**
	 * @return the roleid
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * @param roleid
	 *            the roleid to set
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the hiredate
	 */
	public Date getHiredate() {
		return hiredate;
	}

	/**
	 * @param hiredate
	 *            the hiredate to set
	 */
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	/**
	 * @return the superior
	 */
	public Integer getSuperior() {
		return superior;
	}

	/**
	 * @param superior
	 *            the superior to set
	 */
	public void setSuperior(Integer superior) {
		this.superior = superior;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
		return "Empinfo [" + (empno != null ? "empno=" + empno + ", " : "") + (password != null ? "password=" + password + ", " : "") + (empname != null ? "empname=" + empname + ", " : "") + (deptno != null ? "deptno=" + deptno + ", " : "")
						+ (roleid != null ? "roleid=" + roleid + ", " : "") + "salary=" + salary + ", " + (hiredate != null ? "hiredate=" + hiredate + ", " : "") + (superior != null ? "superior=" + superior + ", " : "") + (telephone != null
										? "telephone=" + telephone + ", " : "") + (email != null ? "email=" + email : "") + "]";
	}

}