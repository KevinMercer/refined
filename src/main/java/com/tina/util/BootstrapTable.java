/**
 * 
 */
package com.tina.util;

import java.util.List;

/**
 * @author 何悟隆
 *
 */
public class BootstrapTable<Entity> {

	private List<Entity> rows;
	private int total;

	/**
	 * 
	 */
	public BootstrapTable() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the rows
	 */
	public List<Entity> getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            the rows to set
	 */
	public void setRows(List<Entity> rows) {
		this.rows = rows;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BootstrapTable [" + (rows != null ? "rows=" + rows + ", " : "") + "total=" + total + "]";
	}

}
