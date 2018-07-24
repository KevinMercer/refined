package com.tina.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andProduct_nameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProduct_nameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_nameEqualTo(String value) {
            addCriterion("product_name =", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameGreaterThan(String value) {
            addCriterion("product_name >", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameLessThan(String value) {
            addCriterion("product_name <", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameLike(String value) {
            addCriterion("product_name like", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotLike(String value) {
            addCriterion("product_name not like", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameIn(List<String> values) {
            addCriterion("product_name in", values, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "product_name");
            return (Criteria) this;
        }

        public Criteria andRepositoryIsNull() {
            addCriterion("repository is null");
            return (Criteria) this;
        }

        public Criteria andRepositoryIsNotNull() {
            addCriterion("repository is not null");
            return (Criteria) this;
        }

        public Criteria andRepositoryEqualTo(Integer value) {
            addCriterion("repository =", value, "repository");
            return (Criteria) this;
        }

        public Criteria andRepositoryNotEqualTo(Integer value) {
            addCriterion("repository <>", value, "repository");
            return (Criteria) this;
        }

        public Criteria andRepositoryGreaterThan(Integer value) {
            addCriterion("repository >", value, "repository");
            return (Criteria) this;
        }

        public Criteria andRepositoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("repository >=", value, "repository");
            return (Criteria) this;
        }

        public Criteria andRepositoryLessThan(Integer value) {
            addCriterion("repository <", value, "repository");
            return (Criteria) this;
        }

        public Criteria andRepositoryLessThanOrEqualTo(Integer value) {
            addCriterion("repository <=", value, "repository");
            return (Criteria) this;
        }

        public Criteria andRepositoryIn(List<Integer> values) {
            addCriterion("repository in", values, "repository");
            return (Criteria) this;
        }

        public Criteria andRepositoryNotIn(List<Integer> values) {
            addCriterion("repository not in", values, "repository");
            return (Criteria) this;
        }

        public Criteria andRepositoryBetween(Integer value1, Integer value2) {
            addCriterion("repository between", value1, value2, "repository");
            return (Criteria) this;
        }

        public Criteria andRepositoryNotBetween(Integer value1, Integer value2) {
            addCriterion("repository not between", value1, value2, "repository");
            return (Criteria) this;
        }

        public Criteria andProduct_picIsNull() {
            addCriterion("product_pic is null");
            return (Criteria) this;
        }

        public Criteria andProduct_picIsNotNull() {
            addCriterion("product_pic is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_picEqualTo(String value) {
            addCriterion("product_pic =", value, "product_pic");
            return (Criteria) this;
        }

        public Criteria andProduct_picNotEqualTo(String value) {
            addCriterion("product_pic <>", value, "product_pic");
            return (Criteria) this;
        }

        public Criteria andProduct_picGreaterThan(String value) {
            addCriterion("product_pic >", value, "product_pic");
            return (Criteria) this;
        }

        public Criteria andProduct_picGreaterThanOrEqualTo(String value) {
            addCriterion("product_pic >=", value, "product_pic");
            return (Criteria) this;
        }

        public Criteria andProduct_picLessThan(String value) {
            addCriterion("product_pic <", value, "product_pic");
            return (Criteria) this;
        }

        public Criteria andProduct_picLessThanOrEqualTo(String value) {
            addCriterion("product_pic <=", value, "product_pic");
            return (Criteria) this;
        }

        public Criteria andProduct_picLike(String value) {
            addCriterion("product_pic like", value, "product_pic");
            return (Criteria) this;
        }

        public Criteria andProduct_picNotLike(String value) {
            addCriterion("product_pic not like", value, "product_pic");
            return (Criteria) this;
        }

        public Criteria andProduct_picIn(List<String> values) {
            addCriterion("product_pic in", values, "product_pic");
            return (Criteria) this;
        }

        public Criteria andProduct_picNotIn(List<String> values) {
            addCriterion("product_pic not in", values, "product_pic");
            return (Criteria) this;
        }

        public Criteria andProduct_picBetween(String value1, String value2) {
            addCriterion("product_pic between", value1, value2, "product_pic");
            return (Criteria) this;
        }

        public Criteria andProduct_picNotBetween(String value1, String value2) {
            addCriterion("product_pic not between", value1, value2, "product_pic");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andMarket_timeIsNull() {
            addCriterion("market_time is null");
            return (Criteria) this;
        }

        public Criteria andMarket_timeIsNotNull() {
            addCriterion("market_time is not null");
            return (Criteria) this;
        }

        public Criteria andMarket_timeEqualTo(Date value) {
            addCriterion("market_time =", value, "market_time");
            return (Criteria) this;
        }

        public Criteria andMarket_timeNotEqualTo(Date value) {
            addCriterion("market_time <>", value, "market_time");
            return (Criteria) this;
        }

        public Criteria andMarket_timeGreaterThan(Date value) {
            addCriterion("market_time >", value, "market_time");
            return (Criteria) this;
        }

        public Criteria andMarket_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("market_time >=", value, "market_time");
            return (Criteria) this;
        }

        public Criteria andMarket_timeLessThan(Date value) {
            addCriterion("market_time <", value, "market_time");
            return (Criteria) this;
        }

        public Criteria andMarket_timeLessThanOrEqualTo(Date value) {
            addCriterion("market_time <=", value, "market_time");
            return (Criteria) this;
        }

        public Criteria andMarket_timeIn(List<Date> values) {
            addCriterion("market_time in", values, "market_time");
            return (Criteria) this;
        }

        public Criteria andMarket_timeNotIn(List<Date> values) {
            addCriterion("market_time not in", values, "market_time");
            return (Criteria) this;
        }

        public Criteria andMarket_timeBetween(Date value1, Date value2) {
            addCriterion("market_time between", value1, value2, "market_time");
            return (Criteria) this;
        }

        public Criteria andMarket_timeNotBetween(Date value1, Date value2) {
            addCriterion("market_time not between", value1, value2, "market_time");
            return (Criteria) this;
        }

        public Criteria andEnableIsNull() {
            addCriterion("enable is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("enable is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Integer value) {
            addCriterion("enable =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Integer value) {
            addCriterion("enable <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Integer value) {
            addCriterion("enable >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("enable >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Integer value) {
            addCriterion("enable <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Integer value) {
            addCriterion("enable <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Integer> values) {
            addCriterion("enable in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Integer> values) {
            addCriterion("enable not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Integer value1, Integer value2) {
            addCriterion("enable between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("enable not between", value1, value2, "enable");
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