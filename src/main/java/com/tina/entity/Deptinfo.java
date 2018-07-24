package com.tina.entity;

public class Deptinfo {
	private Integer deptno;

	private String deptname;

	private String deptdesc;

	private Integer manager;

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname == null ? null : deptname.trim();
	}

	public String getDeptdesc() {
		return deptdesc;
	}

	public void setDeptdesc(String deptdesc) {
		this.deptdesc = deptdesc == null ? null : deptdesc.trim();
	}

	public Integer getManager() {
		return manager;
	}

	public void setManager(Integer manager) {
		this.manager = manager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Deptinfo [" + (deptno != null ? "deptno=" + deptno + ", " : "") + (deptname != null ? "deptname=" + deptname + ", " : "") + (deptdesc != null ? "deptdesc=" + deptdesc + ", " : "") + (manager != null ? "manager=" + manager
						+ ", " : "") + (getDeptno() != null ? "getDeptno()=" + getDeptno() + ", " : "") + (getDeptname() != null ? "getDeptname()=" + getDeptname() + ", " : "") + (getDeptdesc() != null ? "getDeptdesc()=" + getDeptdesc()
										+ ", " : "") + (getManager() != null ? "getManager()=" + getManager() + ", " : "") + (getClass() != null ? "getClass()=" + getClass() + ", " : "") + "hashCode()=" + hashCode() + ", "
						+ (super.toString() != null ? "toString()=" + super.toString() : "") + "]";
	}

}