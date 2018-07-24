package com.tina.entity;

import java.util.Date;

public class Extract {
    private Integer extract_no;

    private Integer empno;

    private Integer product_id;

    private Integer approve;

    private Integer copy;

    private Integer approve_status;

    private String approve_describe;

    private Integer extract;

    private Date extract_date;

    public Integer getExtract_no() {
        return extract_no;
    }

    public void setExtract_no(Integer extract_no) {
        this.extract_no = extract_no;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getApprove() {
        return approve;
    }

    public void setApprove(Integer approve) {
        this.approve = approve;
    }

    public Integer getCopy() {
        return copy;
    }

    public void setCopy(Integer copy) {
        this.copy = copy;
    }

    public Integer getApprove_status() {
        return approve_status;
    }

    public void setApprove_status(Integer approve_status) {
        this.approve_status = approve_status;
    }

    public String getApprove_describe() {
        return approve_describe;
    }

    public void setApprove_describe(String approve_describe) {
        this.approve_describe = approve_describe == null ? null : approve_describe.trim();
    }

    public Integer getExtract() {
        return extract;
    }

    public void setExtract(Integer extract) {
        this.extract = extract;
    }

    public Date getExtract_date() {
        return extract_date;
    }

    public void setExtract_date(Date extract_date) {
        this.extract_date = extract_date;
    }
}