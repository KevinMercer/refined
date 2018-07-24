package com.tina.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 何悟隆
 * @datetime 2018年5月1日 下午1:59:10
 *
 */
public class PermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PermissionExample() {
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

        public Criteria andPeridIsNull() {
            addCriterion("perid is null");
            return (Criteria) this;
        }

        public Criteria andPeridIsNotNull() {
            addCriterion("perid is not null");
            return (Criteria) this;
        }

        public Criteria andPeridEqualTo(Integer value) {
            addCriterion("perid =", value, "perid");
            return (Criteria) this;
        }

        public Criteria andPeridNotEqualTo(Integer value) {
            addCriterion("perid <>", value, "perid");
            return (Criteria) this;
        }

        public Criteria andPeridGreaterThan(Integer value) {
            addCriterion("perid >", value, "perid");
            return (Criteria) this;
        }

        public Criteria andPeridGreaterThanOrEqualTo(Integer value) {
            addCriterion("perid >=", value, "perid");
            return (Criteria) this;
        }

        public Criteria andPeridLessThan(Integer value) {
            addCriterion("perid <", value, "perid");
            return (Criteria) this;
        }

        public Criteria andPeridLessThanOrEqualTo(Integer value) {
            addCriterion("perid <=", value, "perid");
            return (Criteria) this;
        }

        public Criteria andPeridIn(List<Integer> values) {
            addCriterion("perid in", values, "perid");
            return (Criteria) this;
        }

        public Criteria andPeridNotIn(List<Integer> values) {
            addCriterion("perid not in", values, "perid");
            return (Criteria) this;
        }

        public Criteria andPeridBetween(Integer value1, Integer value2) {
            addCriterion("perid between", value1, value2, "perid");
            return (Criteria) this;
        }

        public Criteria andPeridNotBetween(Integer value1, Integer value2) {
            addCriterion("perid not between", value1, value2, "perid");
            return (Criteria) this;
        }

        public Criteria andPernameIsNull() {
            addCriterion("pername is null");
            return (Criteria) this;
        }

        public Criteria andPernameIsNotNull() {
            addCriterion("pername is not null");
            return (Criteria) this;
        }

        public Criteria andPernameEqualTo(String value) {
            addCriterion("pername =", value, "pername");
            return (Criteria) this;
        }

        public Criteria andPernameNotEqualTo(String value) {
            addCriterion("pername <>", value, "pername");
            return (Criteria) this;
        }

        public Criteria andPernameGreaterThan(String value) {
            addCriterion("pername >", value, "pername");
            return (Criteria) this;
        }

        public Criteria andPernameGreaterThanOrEqualTo(String value) {
            addCriterion("pername >=", value, "pername");
            return (Criteria) this;
        }

        public Criteria andPernameLessThan(String value) {
            addCriterion("pername <", value, "pername");
            return (Criteria) this;
        }

        public Criteria andPernameLessThanOrEqualTo(String value) {
            addCriterion("pername <=", value, "pername");
            return (Criteria) this;
        }

        public Criteria andPernameLike(String value) {
            addCriterion("pername like", value, "pername");
            return (Criteria) this;
        }

        public Criteria andPernameNotLike(String value) {
            addCriterion("pername not like", value, "pername");
            return (Criteria) this;
        }

        public Criteria andPernameIn(List<String> values) {
            addCriterion("pername in", values, "pername");
            return (Criteria) this;
        }

        public Criteria andPernameNotIn(List<String> values) {
            addCriterion("pername not in", values, "pername");
            return (Criteria) this;
        }

        public Criteria andPernameBetween(String value1, String value2) {
            addCriterion("pername between", value1, value2, "pername");
            return (Criteria) this;
        }

        public Criteria andPernameNotBetween(String value1, String value2) {
            addCriterion("pername not between", value1, value2, "pername");
            return (Criteria) this;
        }

        public Criteria andIsParentIsNull() {
            addCriterion("isParent is null");
            return (Criteria) this;
        }

        public Criteria andIsParentIsNotNull() {
            addCriterion("isParent is not null");
            return (Criteria) this;
        }

        public Criteria andIsParentEqualTo(int value) {
            addCriterion("isParent =", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotEqualTo(int value) {
            addCriterion("isParent <>", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentGreaterThan(int value) {
            addCriterion("isParent >", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentGreaterThanOrEqualTo(int value) {
            addCriterion("isParent >=", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentLessThan(int value) {
            addCriterion("isParent <", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentLessThanOrEqualTo(int value) {
            addCriterion("isParent <=", value, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentIn(List<Integer> values) {
            addCriterion("isParent in", values, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotIn(List<Integer> values) {
            addCriterion("isParent not in", values, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentBetween(int value1, int value2) {
            addCriterion("isParent between", value1, value2, "isParent");
            return (Criteria) this;
        }

        public Criteria andIsParentNotBetween(int value1, int value2) {
            addCriterion("isParent not between", value1, value2, "isParent");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("parentid is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentid is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(Integer value) {
            addCriterion("parentid =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Integer value) {
            addCriterion("parentid <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Integer value) {
            addCriterion("parentid >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentid >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Integer value) {
            addCriterion("parentid <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Integer value) {
            addCriterion("parentid <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Integer> values) {
            addCriterion("parentid in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Integer> values) {
            addCriterion("parentid not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Integer value1, Integer value2) {
            addCriterion("parentid between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("parentid not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
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