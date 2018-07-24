package com.tina.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author 何悟隆
 * @datetime 2018年5月1日 下午1:59:01
 *
 */
public class EmpinfoExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public EmpinfoExample() {
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

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andEmpnameIsNull() {
			addCriterion("empname is null");
			return (Criteria) this;
		}

		public Criteria andEmpnameIsNotNull() {
			addCriterion("empname is not null");
			return (Criteria) this;
		}

		public Criteria andEmpnameEqualTo(String value) {
			addCriterion("empname =", value, "empname");
			return (Criteria) this;
		}

		public Criteria andEmpnameNotEqualTo(String value) {
			addCriterion("empname <>", value, "empname");
			return (Criteria) this;
		}

		public Criteria andEmpnameGreaterThan(String value) {
			addCriterion("empname >", value, "empname");
			return (Criteria) this;
		}

		public Criteria andEmpnameGreaterThanOrEqualTo(String value) {
			addCriterion("empname >=", value, "empname");
			return (Criteria) this;
		}

		public Criteria andEmpnameLessThan(String value) {
			addCriterion("empname <", value, "empname");
			return (Criteria) this;
		}

		public Criteria andEmpnameLessThanOrEqualTo(String value) {
			addCriterion("empname <=", value, "empname");
			return (Criteria) this;
		}

		public Criteria andEmpnameLike(String value) {
			addCriterion("empname like", value, "empname");
			return (Criteria) this;
		}

		public Criteria andEmpnameNotLike(String value) {
			addCriterion("empname not like", value, "empname");
			return (Criteria) this;
		}

		public Criteria andEmpnameIn(List<String> values) {
			addCriterion("empname in", values, "empname");
			return (Criteria) this;
		}

		public Criteria andEmpnameNotIn(List<String> values) {
			addCriterion("empname not in", values, "empname");
			return (Criteria) this;
		}

		public Criteria andEmpnameBetween(String value1, String value2) {
			addCriterion("empname between", value1, value2, "empname");
			return (Criteria) this;
		}

		public Criteria andEmpnameNotBetween(String value1, String value2) {
			addCriterion("empname not between", value1, value2, "empname");
			return (Criteria) this;
		}

		public Criteria andDeptnoIsNull() {
			addCriterion("deptno is null");
			return (Criteria) this;
		}

		public Criteria andDeptnoIsNotNull() {
			addCriterion("deptno is not null");
			return (Criteria) this;
		}

		public Criteria andDeptnoEqualTo(Integer value) {
			addCriterion("deptno =", value, "deptno");
			return (Criteria) this;
		}

		public Criteria andDeptnoNotEqualTo(Integer value) {
			addCriterion("deptno <>", value, "deptno");
			return (Criteria) this;
		}

		public Criteria andDeptnoGreaterThan(Integer value) {
			addCriterion("deptno >", value, "deptno");
			return (Criteria) this;
		}

		public Criteria andDeptnoGreaterThanOrEqualTo(Integer value) {
			addCriterion("deptno >=", value, "deptno");
			return (Criteria) this;
		}

		public Criteria andDeptnoLessThan(Integer value) {
			addCriterion("deptno <", value, "deptno");
			return (Criteria) this;
		}

		public Criteria andDeptnoLessThanOrEqualTo(Integer value) {
			addCriterion("deptno <=", value, "deptno");
			return (Criteria) this;
		}

		public Criteria andDeptnoIn(List<Integer> values) {
			addCriterion("deptno in", values, "deptno");
			return (Criteria) this;
		}

		public Criteria andDeptnoNotIn(List<Integer> values) {
			addCriterion("deptno not in", values, "deptno");
			return (Criteria) this;
		}

		public Criteria andDeptnoBetween(Integer value1, Integer value2) {
			addCriterion("deptno between", value1, value2, "deptno");
			return (Criteria) this;
		}

		public Criteria andDeptnoNotBetween(Integer value1, Integer value2) {
			addCriterion("deptno not between", value1, value2, "deptno");
			return (Criteria) this;
		}

		public Criteria andRoleidIsNull() {
			addCriterion("roleid is null");
			return (Criteria) this;
		}

		public Criteria andRoleidIsNotNull() {
			addCriterion("roleid is not null");
			return (Criteria) this;
		}

		public Criteria andRoleidEqualTo(Integer value) {
			addCriterion("roleid =", value, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidNotEqualTo(Integer value) {
			addCriterion("roleid <>", value, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidGreaterThan(Integer value) {
			addCriterion("roleid >", value, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidGreaterThanOrEqualTo(Integer value) {
			addCriterion("roleid >=", value, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidLessThan(Integer value) {
			addCriterion("roleid <", value, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidLessThanOrEqualTo(Integer value) {
			addCriterion("roleid <=", value, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidIn(List<Integer> values) {
			addCriterion("roleid in", values, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidNotIn(List<Integer> values) {
			addCriterion("roleid not in", values, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidBetween(Integer value1, Integer value2) {
			addCriterion("roleid between", value1, value2, "roleid");
			return (Criteria) this;
		}

		public Criteria andRoleidNotBetween(Integer value1, Integer value2) {
			addCriterion("roleid not between", value1, value2, "roleid");
			return (Criteria) this;
		}

		public Criteria andSalaryIsNull() {
			addCriterion("salary is null");
			return (Criteria) this;
		}

		public Criteria andSalaryIsNotNull() {
			addCriterion("salary is not null");
			return (Criteria) this;
		}

		public Criteria andSalaryEqualTo(double value) {
			addCriterion("salary =", value, "salary");
			return (Criteria) this;
		}

		public Criteria andSalaryNotEqualTo(double value) {
			addCriterion("salary <>", value, "salary");
			return (Criteria) this;
		}

		public Criteria andSalaryGreaterThan(double value) {
			addCriterion("salary >", value, "salary");
			return (Criteria) this;
		}

		public Criteria andSalaryGreaterThanOrEqualTo(double value) {
			addCriterion("salary >=", value, "salary");
			return (Criteria) this;
		}

		public Criteria andSalaryLessThan(double value) {
			addCriterion("salary <", value, "salary");
			return (Criteria) this;
		}

		public Criteria andSalaryLessThanOrEqualTo(double value) {
			addCriterion("salary <=", value, "salary");
			return (Criteria) this;
		}

		public Criteria andSalaryIn(List<Double> values) {
			addCriterion("salary in", values, "salary");
			return (Criteria) this;
		}

		public Criteria andSalaryNotIn(List<Double> values) {
			addCriterion("salary not in", values, "salary");
			return (Criteria) this;
		}

		public Criteria andSalaryBetween(double value1, double value2) {
			addCriterion("salary between", value1, value2, "salary");
			return (Criteria) this;
		}

		public Criteria andSalaryNotBetween(double value1, double value2) {
			addCriterion("salary not between", value1, value2, "salary");
			return (Criteria) this;
		}

		public Criteria andHiredateIsNull() {
			addCriterion("hiredate is null");
			return (Criteria) this;
		}

		public Criteria andHiredateIsNotNull() {
			addCriterion("hiredate is not null");
			return (Criteria) this;
		}

		public Criteria andHiredateEqualTo(Date value) {
			addCriterion("hiredate =", value, "hiredate");
			return (Criteria) this;
		}

		public Criteria andHiredateNotEqualTo(Date value) {
			addCriterion("hiredate <>", value, "hiredate");
			return (Criteria) this;
		}

		public Criteria andHiredateGreaterThan(Date value) {
			addCriterion("hiredate >", value, "hiredate");
			return (Criteria) this;
		}

		public Criteria andHiredateGreaterThanOrEqualTo(Date value) {
			addCriterion("hiredate >=", value, "hiredate");
			return (Criteria) this;
		}

		public Criteria andHiredateLessThan(Date value) {
			addCriterion("hiredate <", value, "hiredate");
			return (Criteria) this;
		}

		public Criteria andHiredateLessThanOrEqualTo(Date value) {
			addCriterion("hiredate <=", value, "hiredate");
			return (Criteria) this;
		}

		public Criteria andHiredateIn(List<Date> values) {
			addCriterion("hiredate in", values, "hiredate");
			return (Criteria) this;
		}

		public Criteria andHiredateNotIn(List<Date> values) {
			addCriterion("hiredate not in", values, "hiredate");
			return (Criteria) this;
		}

		public Criteria andHiredateBetween(Date value1, Date value2) {
			addCriterion("hiredate between", value1, value2, "hiredate");
			return (Criteria) this;
		}

		public Criteria andHiredateNotBetween(Date value1, Date value2) {
			addCriterion("hiredate not between", value1, value2, "hiredate");
			return (Criteria) this;
		}

		public Criteria andSuperiorIsNull() {
			addCriterion("superior is null");
			return (Criteria) this;
		}

		public Criteria andSuperiorIsNotNull() {
			addCriterion("superior is not null");
			return (Criteria) this;
		}

		public Criteria andSuperiorEqualTo(Integer value) {
			addCriterion("superior =", value, "superior");
			return (Criteria) this;
		}

		public Criteria andSuperiorNotEqualTo(Integer value) {
			addCriterion("superior <>", value, "superior");
			return (Criteria) this;
		}

		public Criteria andSuperiorGreaterThan(Integer value) {
			addCriterion("superior >", value, "superior");
			return (Criteria) this;
		}

		public Criteria andSuperiorGreaterThanOrEqualTo(Integer value) {
			addCriterion("superior >=", value, "superior");
			return (Criteria) this;
		}

		public Criteria andSuperiorLessThan(Integer value) {
			addCriterion("superior <", value, "superior");
			return (Criteria) this;
		}

		public Criteria andSuperiorLessThanOrEqualTo(Integer value) {
			addCriterion("superior <=", value, "superior");
			return (Criteria) this;
		}

		public Criteria andSuperiorIn(List<Integer> values) {
			addCriterion("superior in", values, "superior");
			return (Criteria) this;
		}

		public Criteria andSuperiorNotIn(List<Integer> values) {
			addCriterion("superior not in", values, "superior");
			return (Criteria) this;
		}

		public Criteria andSuperiorBetween(Integer value1, Integer value2) {
			addCriterion("superior between", value1, value2, "superior");
			return (Criteria) this;
		}

		public Criteria andSuperiorNotBetween(Integer value1, Integer value2) {
			addCriterion("superior not between", value1, value2, "superior");
			return (Criteria) this;
		}

		public Criteria andTelephoneIsNull() {
			addCriterion("telephone is null");
			return (Criteria) this;
		}

		public Criteria andTelephoneIsNotNull() {
			addCriterion("telephone is not null");
			return (Criteria) this;
		}

		public Criteria andTelephoneEqualTo(String value) {
			addCriterion("telephone =", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneNotEqualTo(String value) {
			addCriterion("telephone <>", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneGreaterThan(String value) {
			addCriterion("telephone >", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
			addCriterion("telephone >=", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneLessThan(String value) {
			addCriterion("telephone <", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneLessThanOrEqualTo(String value) {
			addCriterion("telephone <=", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneLike(String value) {
			addCriterion("telephone like", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneNotLike(String value) {
			addCriterion("telephone not like", value, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneIn(List<String> values) {
			addCriterion("telephone in", values, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneNotIn(List<String> values) {
			addCriterion("telephone not in", values, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneBetween(String value1, String value2) {
			addCriterion("telephone between", value1, value2, "telephone");
			return (Criteria) this;
		}

		public Criteria andTelephoneNotBetween(String value1, String value2) {
			addCriterion("telephone not between", value1, value2, "telephone");
			return (Criteria) this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("email is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("email in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("email not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
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