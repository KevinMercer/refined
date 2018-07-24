package com.tina.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Product {
	private Integer product_id;

	private String product_name;

	private Integer repository;

	private String product_pic;

	private String product_desc;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date create_time;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date market_time;

	private Integer enable;

	private String enables;

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name == null ? null : product_name.trim();
	}

	public Integer getRepository() {
		return repository;
	}

	public void setRepository(Integer repository) {
		this.repository = repository;
	}

	public String getProduct_pic() {
		return product_pic;
	}

	public void setProduct_pic(String product_pic) {
		this.product_pic = product_pic == null ? null : product_pic.trim();
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getMarket_time() {
		return market_time;
	}

	public void setMarket_time(Date market_time) {
		this.market_time = market_time;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	/**
	 * @return the product_desc
	 */
	public String getProduct_desc() {
		return product_desc;
	}

	/**
	 * @param product_desc
	 *            the product_desc to set
	 */
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	/**
	 * @return the enables
	 */
	public String getEnables() {
		enables = "-";
		if(enable == 0){
			enables = "停用";
		}
		if(enable == 1){
			enables = "启用";
		}
		return enables;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [" + (product_id != null ? "product_id=" + product_id + ", " : "") + (product_name != null ? "product_name=" + product_name + ", " : "") + (repository != null ? "repository=" + repository + ", " : "")
						+ (product_pic != null ? "product_pic=" + product_pic + ", " : "") + (product_desc != null ? "product_desc=" + product_desc + ", " : "") + (create_time != null ? "create_time=" + create_time + ", " : "")
						+ (market_time != null ? "market_time=" + market_time + ", " : "") + (enable != null ? "enable=" + enable + ", " : "") + (getProduct_id() != null ? "getProduct_id()=" + getProduct_id() + ", " : "")
						+ (getProduct_name() != null ? "getProduct_name()=" + getProduct_name() + ", " : "") + (getRepository() != null ? "getRepository()=" + getRepository() + ", " : "") + (getProduct_pic() != null ? "getProduct_pic()="
										+ getProduct_pic() + ", " : "") + (getCreate_time() != null ? "getCreate_time()=" + getCreate_time() + ", " : "") + (getMarket_time() != null ? "getMarket_time()=" + getMarket_time() + ", " : "")
						+ (getEnable() != null ? "getEnable()=" + getEnable() + ", " : "") + (getProduct_desc() != null ? "getProduct_desc()=" + getProduct_desc() + ", " : "") + (getClass() != null ? "getClass()=" + getClass() + ", " : "")
						+ "hashCode()=" + hashCode() + ", " + (super.toString() != null ? "toString()=" + super.toString() : "") + "]";
	}

}