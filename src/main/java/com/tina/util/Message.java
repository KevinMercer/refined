/**
 * 
 */
package com.tina.util;

/**
 * @author 何悟隆
 *
 */
public class Message {

	private int effectRow;

	/**
	 * 
	 */
	public Message() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param effectRow
	 */
	public Message(int effectRow) {
		super();
		this.effectRow = effectRow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [effectRow=" + effectRow + "]";
	}

	/**
	 * @return the effectRow
	 */
	public int getEffectRow() {
		return effectRow;
	}

	/**
	 * @param effectRow
	 *            the effectRow to set
	 */
	public void setEffectRow(int effectRow) {
		this.effectRow = effectRow;
	}

}
