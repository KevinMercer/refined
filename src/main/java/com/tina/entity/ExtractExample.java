package com.tina.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExtractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExtractExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andExtract_noIsNull() {
            addCriterion("extract_no is null");
            return (Criteria) this;
        }

        public Criteria andExtract_noIsNotNull() {
            addCriterion("extract_no is not null");
            return (Criteria) this;
        }

        public Criteria andExtract_noEqualTo(Integer value) {
            addCriterion("extract_no =", value, "extract_no");
            return (Criteria) this;
        }

        public Criteria andExtract_noNotEqualTo(Integer value) {
            addCriterion("extract_no <>", value, "extract_no");
            return (Criteria) this;
        }

        public Criteria andExtract_noGreaterThan(Integer value) {
            addCriterion("extract_no >", value, "extract_no");
            return (Criteria) this;
        }

        public Criteria andExtract_noGreaterThanOrEqualTo(Integer value) {
            addCriterion("extract_no >=", value, "extract_no");
            return (Criteria) this;
        }

        public Criteria andExtract_noLessThan(Integer value) {
            addCriterion("extract_no <", value, "extract_no");
            return (Criteria) this;
        }

        public Criteria andExtract_noLessThanOrEqualTo(Integer value) {
            addCriterion("extract_no <=", value, "extract_no");
            return (Criteria) this;
        }

        public Criteria andExtract_noIn(List<Integer> values) {
            addCriterion("extract_no in", values, "extract_no");
            return (Criteria) this;
        }

        public Criteria andExtract_noNotIn(List<Integer> values) {
            addCriterion("extract_no not in", values, "extract_no");
            return (Criteria) this;
        }

        public Criteria andExtract_noBetween(Integer value1, Integer value2) {
            addCriterion("extract_no between", value1, value2, "extract_no");
            return (Criteria) this;
        }

        public Criteria andExtract_noNotBetween(Integer value1, Integer value2) {
            addCriterion("extract_no not between", value1, value2, "extract_no");
            return (Criteria) this;
        }

        public Criteria andEmpnoIsNull() {
            addCriterion("empno is null");
            return (Criteria) this;
        }

        public Criteria andEmpnoIsNotNull() {
            addCriterion("empno is not null");
            return (Criteria) this;
        }

        public Criteria andEmpnoEqualTo(Integer value) {
            addCriterion("empno =", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoNotEqualTo(Integer value) {
            addCriterion("empno <>", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoGreaterThan(Integer value) {
            addCriterion("empno >", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("empno >=", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoLessThan(Integer value) {
            addCriterion("empno <", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoLessThanOrEqualTo(Integer value) {
            addCriterion("empno <=", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoIn(List<Integer> values) {
            addCriterion("empno in", values, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoNotIn(List<Integer> values) {
            addCriterion("empno not in", values, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoBetween(Integer value1, Integer value2) {
            addCriterion("empno between", value1, value2, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoNotBetween(Integer value1, Integer value2) {
            addCriterion("empno not between", value1, value2, "empno");
            return (Criteria) this;
        }

        public Criteria andProduct_idIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProduct_idIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_idEqualTo(Integer value) {
            addCriterion("product_id =", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idGreaterThan(Integer value) {
            addCriterion("product_id >", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idLessThan(Integer value) {
            addCriterion("product_id <", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idIn(List<Integer> values) {
            addCriterion("product_id in", values, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "product_id");
            return (Criteria) this;
        }

        public Criteria andProduct_idNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "product_id");
            return (Criteria) this;
        }

        public Criteria andApproveIsNull() {
            addCriterion("approve is null");
            return (Criteria) this;
        }

        public Criteria andApproveIsNotNull() {
            addCriterion("approve is not null");
            return (Criteria) this;
        }

        public Criteria andApproveEqualTo(Integer value) {
            addCriterion("approve =", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveNotEqualTo(Integer value) {
            addCriterion("approve <>", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveGreaterThan(Integer value) {
            addCriterion("approve >", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveGreaterThanOrEqualTo(Integer value) {
            addCriterion("approve >=", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveLessThan(Integer value) {
            addCriterion("approve <", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveLessThanOrEqualTo(Integer value) {
            addCriterion("approve <=", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveIn(List<Integer> values) {
            addCriterion("approve in", values, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveNotIn(List<Integer> values) {
            addCriterion("approve not in", values, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveBetween(Integer value1, Integer value2) {
            addCriterion("approve between", value1, value2, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveNotBetween(Integer value1, Integer value2) {
            addCriterion("approve not between", value1, value2, "approve");
            return (Criteria) this;
        }

        public Criteria andCopyIsNull() {
            addCriterion("copy is null");
            return (Criteria) this;
        }

        public Criteria andCopyIsNotNull() {
            addCriterion("copy is not null");
            return (Criteria) this;
        }

        public Criteria andCopyEqualTo(Integer value) {
            addCriterion("copy =", value, "copy");
            return (Criteria) this;
        }

        public Criteria andCopyNotEqualTo(Integer value) {
            addCriterion("copy <>", value, "copy");
            return (Criteria) this;
        }

        public Criteria andCopyGreaterThan(Integer value) {
            addCriterion("copy >", value, "copy");
            return (Criteria) this;
        }

        public Criteria andCopyGreaterThanOrEqualTo(Integer value) {
            addCriterion("copy >=", value, "copy");
            return (Criteria) this;
        }

        public Criteria andCopyLessThan(Integer value) {
            addCriterion("copy <", value, "copy");
            return (Criteria) this;
        }

        public Criteria andCopyLessThanOrEqualTo(Integer value) {
            addCriterion("copy <=", value, "copy");
            return (Criteria) this;
        }

        public Criteria andCopyIn(List<Integer> values) {
            addCriterion("copy in", values, "copy");
            return (Criteria) this;
        }

        public Criteria andCopyNotIn(List<Integer> values) {
            addCriterion("copy not in", values, "copy");
            return (Criteria) this;
        }

        public Criteria andCopyBetween(Integer value1, Integer value2) {
            addCriterion("copy between", value1, value2, "copy");
            return (Criteria) this;
        }

        public Criteria andCopyNotBetween(Integer value1, Integer value2) {
            addCriterion("copy not between", value1, value2, "copy");
            return (Criteria) this;
        }

        public Criteria andApprove_statusIsNull() {
            addCriterion("approve_status is null");
            return (Criteria) this;
        }

        public Criteria andApprove_statusIsNotNull() {
            addCriterion("approve_status is not null");
            return (Criteria) this;
        }

        public Criteria andApprove_statusEqualTo(Integer value) {
            addCriterion("approve_status =", value, "approve_status");
            return (Criteria) this;
        }

        public Criteria andApprove_statusNotEqualTo(Integer value) {
            addCriterion("approve_status <>", value, "approve_status");
            return (Criteria) this;
        }

        public Criteria andApprove_statusGreaterThan(Integer value) {
            addCriterion("approve_status >", value, "approve_status");
            return (Criteria) this;
        }

        public Criteria andApprove_statusGreaterThanOrEqualTo(Integer value) {
            addCriterion("approve_status >=", value, "approve_status");
            return (Criteria) this;
        }

        public Criteria andApprove_statusLessThan(Integer value) {
            addCriterion("approve_status <", value, "approve_status");
            return (Criteria) this;
        }

        public Criteria andApprove_statusLessThanOrEqualTo(Integer value) {
            addCriterion("approve_status <=", value, "approve_status");
            return (Criteria) this;
        }

        public Criteria andApprove_statusIn(List<Integer> values) {
            addCriterion("approve_status in", values, "approve_status");
            return (Criteria) this;
        }

        public Criteria andApprove_statusNotIn(List<Integer> values) {
            addCriterion("approve_status not in", values, "approve_status");
            return (Criteria) this;
        }

        public Criteria andApprove_statusBetween(Integer value1, Integer value2) {
            addCriterion("approve_status between", value1, value2, "approve_status");
            return (Criteria) this;
        }

        public Criteria andApprove_statusNotBetween(Integer value1, Integer value2) {
            addCriterion("approve_status not between", value1, value2, "approve_status");
            return (Criteria) this;
        }

        public Criteria andApprove_describeIsNull() {
            addCriterion("approve_describe is null");
            return (Criteria) this;
        }

        public Criteria andApprove_describeIsNotNull() {
            addCriterion("approve_describe is not null");
            return (Criteria) this;
        }

        public Criteria andApprove_describeEqualTo(String value) {
            addCriterion("approve_describe =", value, "approve_describe");
            return (Criteria) this;
        }

        public Criteria andApprove_describeNotEqualTo(String value) {
            addCriterion("approve_describe <>", value, "approve_describe");
            return (Criteria) this;
        }

        public Criteria andApprove_describeGreaterThan(String value) {
            addCriterion("approve_describe >", value, "approve_describe");
            return (Criteria) this;
        }

        public Criteria andApprove_describeGreaterThanOrEqualTo(String value) {
            addCriterion("approve_describe >=", value, "approve_describe");
            return (Criteria) this;
        }

        public Criteria andApprove_describeLessThan(String value) {
            addCriterion("approve_describe <", value, "approve_describe");
            return (Criteria) this;
        }

        public Criteria andApprove_describeLessThanOrEqualTo(String value) {
            addCriterion("approve_describe <=", value, "approve_describe");
            return (Criteria) this;
        }

        public Criteria andApprove_describeLike(String value) {
            addCriterion("approve_describe like", value, "approve_describe");
            return (Criteria) this;
        }

        public Criteria andApprove_describeNotLike(String value) {
            addCriterion("approve_describe not like", value, "approve_describe");
            return (Criteria) this;
        }

        public Criteria andApprove_describeIn(List<String> values) {
            addCriterion("approve_describe in", values, "approve_describe");
            return (Criteria) this;
        }

        public Criteria andApprove_describeNotIn(List<String> values) {
            addCriterion("approve_describe not in", values, "approve_describe");
            return (Criteria) this;
        }

        public Criteria andApprove_describeBetween(String value1, String value2) {
            addCriterion("approve_describe between", value1, value2, "approve_describe");
            return (Criteria) this;
        }

        public Criteria andApprove_describeNotBetween(String value1, String value2) {
            addCriterion("approve_describe not between", value1, value2, "approve_describe");
            return (Criteria) this;
        }

        public Criteria andExtractIsNull() {
            addCriterion("extract is null");
            return (Criteria) this;
        }

        public Criteria andExtractIsNotNull() {
            addCriterion("extract is not null");
            return (Criteria) this;
        }

        public Criteria andExtractEqualTo(Integer value) {
            addCriterion("extract =", value, "extract");
            return (Criteria) this;
        }

        public Criteria andExtractNotEqualTo(Integer value) {
            addCriterion("extract <>", value, "extract");
            return (Criteria) this;
        }

        public Criteria andExtractGreaterThan(Integer value) {
            addCriterion("extract >", value, "extract");
            return (Criteria) this;
        }

        public Criteria andExtractGreaterThanOrEqualTo(Integer value) {
            addCriterion("extract >=", value, "extract");
            return (Criteria) this;
        }

        public Criteria andExtractLessThan(Integer value) {
            addCriterion("extract <", value, "extract");
            return (Criteria) this;
        }

        public Criteria andExtractLessThanOrEqualTo(Integer value) {
            addCriterion("extract <=", value, "extract");
            return (Criteria) this;
        }

        public Criteria andExtractIn(List<Integer> values) {
            addCriterion("extract in", values, "extract");
            return (Criteria) this;
        }

        public Criteria andExtractNotIn(List<Integer> values) {
            addCriterion("extract not in", values, "extract");
            return (Criteria) this;
        }

        public Criteria andExtractBetween(Integer value1, Integer value2) {
            addCriterion("extract between", value1, value2, "extract");
            return (Criteria) this;
        }

        public Criteria andExtractNotBetween(Integer value1, Integer value2) {
            addCriterion("extract not between", value1, value2, "extract");
            return (Criteria) this;
        }

        public Criteria andExtract_dateIsNull() {
            addCriterion("extract_date is null");
            return (Criteria) this;
        }

        public Criteria andExtract_dateIsNotNull() {
            addCriterion("extract_date is not null");
            return (Criteria) this;
        }

        public Criteria andExtract_dateEqualTo(Date value) {
            addCriterionForJDBCDate("extract_date =", value, "extract_date");
            return (Criteria) this;
        }

        public Criteria andExtract_dateNotEqualTo(Date value) {
            addCriterionForJDBCDate("extract_date <>", value, "extract_date");
            return (Criteria) this;
        }

        public Criteria andExtract_dateGreaterThan(Date value) {
            addCriterionForJDBCDate("extract_date >", value, "extract_date");
            return (Criteria) this;
        }

        public Criteria andExtract_dateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("extract_date >=", value, "extract_date");
            return (Criteria) this;
        }

        public Criteria andExtract_dateLessThan(Date value) {
            addCriterionForJDBCDate("extract_date <", value, "extract_date");
            return (Criteria) this;
        }

        public Criteria andExtract_dateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("extract_date <=", value, "extract_date");
            return (Criteria) this;
        }

        public Criteria andExtract_dateIn(List<Date> values) {
            addCriterionForJDBCDate("extract_date in", values, "extract_date");
            return (Criteria) this;
        }

        public Criteria andExtract_dateNotIn(List<Date> values) {
            addCriterionForJDBCDate("extract_date not in", values, "extract_date");
            return (Criteria) this;
        }

        public Criteria andExtract_dateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("extract_date between", value1, value2, "extract_date");
            return (Criteria) this;
        }

        public Criteria andExtract_dateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("extract_date not between", value1, value2, "extract_date");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}