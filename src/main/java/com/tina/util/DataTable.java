/**
 * 
 */
package com.tina.util;

import java.util.List;

/**
 * @author 何悟隆
 *
 */
public class DataTable<Entity> {

	private int recordsTotal, recordsFiltered;
	private List<Entity> data;

	/**
	 * 
	 */
	public DataTable() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DataTable [recordTotals=" + recordsTotal + ", recordFiltered=" + recordsFiltered + ", data=" + data + "]";
	}

	/**
	 * @return the recordTotals
	 */
	public int getRecordsTotal() {
		return recordsTotal;
	}

	/**
	 * @param recordTotals
	 *            the recordTotals to set
	 */
	public void setRecordsTotal(int recordTotals) {
		this.recordsTotal = recordTotals;
	}

	/**
	 * @return the recordFiltered
	 */
	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	/**
	 * @param recordFiltered
	 *            the recordFiltered to set
	 */
	public void setRecordsFiltered(int recordFiltered) {
		this.recordsFiltered = recordFiltered;
	}

	/**
	 * @return the data
	 */
	public List<Entity> getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(List<Entity> data) {
		this.data = data;
	}

}
