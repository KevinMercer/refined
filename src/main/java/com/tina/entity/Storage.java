package com.tina.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;

public class Storage {
    private Integer storage_no;

    private Integer product_id;

    @DateTimeFormat(pattern="yyyy-MM-dd")
	@JSONField(format="yyyy-MM-dd")
    private Date storage_date;

    private Integer operator;

    private Integer number;

    public Integer getStorage_no() {
        return storage_no;
    }

    public void setStorage_no(Integer storage_no) {
        this.storage_no = storage_no;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Date getStorage_date() {
        return storage_date;
    }

    public void setStorage_date(Date storage_date) {
        this.storage_date = storage_date;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Storage [" + (storage_no != null ? "storage_no=" + storage_no + ", " : "") + (product_id != null ? "product_id=" + product_id + ", " : "") + (storage_date != null ? "storage_date=" + storage_date + ", " : "")
						+ (operator != null ? "operator=" + operator + ", " : "") + (number != null ? "number=" + number + ", " : "") + (getStorage_no() != null ? "getStorage_no()=" + getStorage_no() + ", " : "") + (getProduct_id() != null
										? "getProduct_id()=" + getProduct_id() + ", " : "") + (getStorage_date() != null ? "getStorage_date()=" + getStorage_date() + ", " : "") + (getOperator() != null ? "getOperator()=" + getOperator()
														+ ", " : "") + (getNumber() != null ? "getNumber()=" + getNumber() + ", " : "") + (getClass() != null ? "getClass()=" + getClass() + ", " : "") + "hashCode()=" + hashCode() + ", "
						+ (super.toString() != null ? "toString()=" + super.toString() : "") + "]";
	}
    
}