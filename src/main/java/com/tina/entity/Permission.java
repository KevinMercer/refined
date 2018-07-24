package com.tina.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author 何悟隆
 * @datetime 2018年5月1日 下午1:57:41
 *
 */
public class Permission {
	private Integer perid;
	private String pername;
	private String url, picname, ajaxPath;
	private boolean open, checked;
	private Integer parentid;
	@JSONField(serialize = false)
	private int isParent;
	@JSONField(name = "isParent")
	private boolean mark;

	/**
	 * 
	 */
	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param perid
	 * @param isParent
	 * @param parentid
	 */
	public Permission(Integer perid, int isParent, Integer parentid) {
		super();
		this.perid = perid;
		this.isParent = isParent;
		this.parentid = parentid;
	}

	/**
	 * @param perid
	 * @param isParent
	 */
	public Permission(Integer perid, int isParent) {
		super();
		this.perid = perid;
		this.isParent = isParent;
	}

	/**
	 * @param pername
	 * @param isParent
	 * @param parentid
	 * @param url
	 * @param mark
	 */
	public Permission(String pername, int isParent, Integer parentid, String url, boolean mark) {
		super();
		this.pername = pername;
		this.isParent = isParent;
		this.parentid = parentid;
		this.url = url;
		this.mark = mark;
	}

	/**
	 * @param perid
	 * @param pername
	 * @param isParent
	 * @param parentid
	 * @param url
	 * @param mark
	 */
	public Permission(Integer perid, String pername, int isParent, Integer parentid, String url, boolean mark) {
		super();
		this.perid = perid;
		this.pername = pername;
		this.isParent = isParent;
		this.parentid = parentid;
		this.url = url;
		this.mark = mark;
	}

	/**
	 * @param perid
	 * @param pername
	 * @param isParent
	 * @param parentid
	 * @param url
	 * @param mark
	 * @param open
	 * @param checked
	 * @param picname
	 * @param ajaxPath
	 */
	public Permission(Integer perid, String pername, int isParent, Integer parentid, String url, boolean mark, boolean open, boolean checked, String picname, String ajaxPath) {
		super();
		this.perid = perid;
		this.pername = pername;
		this.isParent = isParent;
		this.parentid = parentid;
		this.url = url;
		this.mark = mark;
		this.open = open;
		this.checked = checked;
		this.picname = picname;
		this.ajaxPath = ajaxPath;
	}

	/**
	 * @return the perid
	 */
	public Integer getPerid() {
		return perid;
	}

	/**
	 * @param perid
	 *            the perid to set
	 */
	public void setPerid(Integer perid) {
		this.perid = perid;
	}

	/**
	 * @return the pername
	 */
	public String getPername() {
		return pername;
	}

	/**
	 * @param pername
	 *            the pername to set
	 */
	public void setPername(String pername) {
		this.pername = pername;
	}

	/**
	 * @return the isParent
	 */
	public int getIsParent() {
		return isParent;
	}

	/**
	 * @param isParent
	 *            the isParent to set
	 */
	public void setIsParent(int isParent) {
		this.isParent = isParent;
	}

	/**
	 * @return the parentid
	 */
	public Integer getParentid() {
		return parentid;
	}

	/**
	 * @param parentid
	 *            the parentid to set
	 */
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the mark
	 */
	public boolean isMark() {
		return isParent > 0 ? true : false;
	}

	/**
	 * @param mark
	 *            the mark to set
	 */
	public void setMark(boolean mark) {
		this.mark = mark;
	}

	/**
	 * @return the open
	 */
	public boolean isOpen() {
		open = true;
		return open;
	}

	/**
	 * @return the checked
	 */
	public boolean isChecked() {
		return checked;
	}

	/**
	 * @param checked
	 *            the checked to set
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	/**
	 * @param open
	 *            the open to set
	 */
	public void setOpen(boolean open) {
		this.open = open;
	}

	/**
	 * @return the picname
	 */
	public String getPicname() {
		return picname;
	}

	/**
	 * @param picname
	 *            the picname to set
	 */
	public void setPicname(String picname) {
		this.picname = picname;
	}

	/**
	 * @return the ajaxPath
	 */
	public String getAjaxPath() {
		return ajaxPath;
	}

	/**
	 * @param ajaxPath
	 *            the ajaxPath to set
	 */
	public void setAjaxPath(String ajaxPath) {
		this.ajaxPath = ajaxPath;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Permission [" + (perid != null ? "perid=" + perid + ", " : "") + (pername != null ? "pername=" + pername + ", " : "") + "isParent=" + isParent + ", " + (parentid != null ? "parentid=" + parentid + ", " : "") + (url != null
						? "url=" + url + ", " : "") + "mark=" + mark + ", open=" + open + ", checked=" + checked + ", " + (picname != null ? "picname=" + picname + ", " : "") + (ajaxPath != null ? "ajaxPath=" + ajaxPath : "") + "]";
	}

}