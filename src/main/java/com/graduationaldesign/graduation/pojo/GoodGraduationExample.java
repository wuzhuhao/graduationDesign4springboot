package com.graduationaldesign.graduation.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodGraduationExample implements Example {

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_goodgraduation
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_goodgraduation
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_goodgraduation
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * 构造查询条件,t_goodgraduation
     */
    public GoodGraduationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 设置排序字段,t_goodgraduation
     *
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 获取排序字段,t_goodgraduation
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 设置过滤重复数据,t_goodgraduation
     *
     * @param distinct 是否过滤重复数据
     */
    @Override
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 是否过滤重复数据,t_goodgraduation
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 获取当前的查询条件实例,t_goodgraduation
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * ,t_goodgraduation
     *
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * ,t_goodgraduation
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 创建一个查询条件,t_goodgraduation
     */
    @Override
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 内部构建查询条件对象,t_goodgraduation
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 清除查询条件,t_goodgraduation
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * GeneratedCriteria
     * 数据库表：t_goodgraduation
     */
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

        protected void addCriterion(String condition, Object value1, Object value2,
                                    String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGoodSubIdIsNull() {
            addCriterion("good_sub_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodSubIdIsNotNull() {
            addCriterion("good_sub_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodSubIdEqualTo(String value) {
            addCriterion("good_sub_id =", value, "goodSubId");
            return (Criteria) this;
        }

        public Criteria andGoodSubIdNotEqualTo(String value) {
            addCriterion("good_sub_id <>", value, "goodSubId");
            return (Criteria) this;
        }

        public Criteria andGoodSubIdGreaterThan(String value) {
            addCriterion("good_sub_id >", value, "goodSubId");
            return (Criteria) this;
        }

        public Criteria andGoodSubIdGreaterThanOrEqualTo(String value) {
            addCriterion("good_sub_id >=", value, "goodSubId");
            return (Criteria) this;
        }

        public Criteria andGoodSubIdLessThan(String value) {
            addCriterion("good_sub_id <", value, "goodSubId");
            return (Criteria) this;
        }

        public Criteria andGoodSubIdLessThanOrEqualTo(String value) {
            addCriterion("good_sub_id <=", value, "goodSubId");
            return (Criteria) this;
        }

        public Criteria andGoodSubIdLike(String value) {
            addCriterion("good_sub_id like", value, "goodSubId");
            return (Criteria) this;
        }

        public Criteria andGoodSubIdNotLike(String value) {
            addCriterion("good_sub_id not like", value, "goodSubId");
            return (Criteria) this;
        }

        public Criteria andGoodSubIdIn(List<String> values) {
            addCriterion("good_sub_id in", values, "goodSubId");
            return (Criteria) this;
        }

        public Criteria andGoodSubIdNotIn(List<String> values) {
            addCriterion("good_sub_id not in", values, "goodSubId");
            return (Criteria) this;
        }

        public Criteria andGoodSubIdBetween(String value1, String value2) {
            addCriterion("good_sub_id between", value1, value2, "goodSubId");
            return (Criteria) this;
        }

        public Criteria andGoodSubIdNotBetween(String value1, String value2) {
            addCriterion("good_sub_id not between", value1, value2, "goodSubId");
            return (Criteria) this;
        }

        public Criteria andGoodTimeIsNull() {
            addCriterion("good_time is null");
            return (Criteria) this;
        }

        public Criteria andGoodTimeIsNotNull() {
            addCriterion("good_time is not null");
            return (Criteria) this;
        }

        public Criteria andGoodTimeEqualTo(Date value) {
            addCriterion("good_time =", value, "goodTime");
            return (Criteria) this;
        }

        public Criteria andGoodTimeNotEqualTo(Date value) {
            addCriterion("good_time <>", value, "goodTime");
            return (Criteria) this;
        }

        public Criteria andGoodTimeGreaterThan(Date value) {
            addCriterion("good_time >", value, "goodTime");
            return (Criteria) this;
        }

        public Criteria andGoodTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("good_time >=", value, "goodTime");
            return (Criteria) this;
        }

        public Criteria andGoodTimeLessThan(Date value) {
            addCriterion("good_time <", value, "goodTime");
            return (Criteria) this;
        }

        public Criteria andGoodTimeLessThanOrEqualTo(Date value) {
            addCriterion("good_time <=", value, "goodTime");
            return (Criteria) this;
        }

        public Criteria andGoodTimeIn(List<Date> values) {
            addCriterion("good_time in", values, "goodTime");
            return (Criteria) this;
        }

        public Criteria andGoodTimeNotIn(List<Date> values) {
            addCriterion("good_time not in", values, "goodTime");
            return (Criteria) this;
        }

        public Criteria andGoodTimeBetween(Date value1, Date value2) {
            addCriterion("good_time between", value1, value2, "goodTime");
            return (Criteria) this;
        }

        public Criteria andGoodTimeNotBetween(Date value1, Date value2) {
            addCriterion("good_time not between", value1, value2, "goodTime");
            return (Criteria) this;
        }

        public Criteria andGoodReasonIsNull() {
            addCriterion("good_reason is null");
            return (Criteria) this;
        }

        public Criteria andGoodReasonIsNotNull() {
            addCriterion("good_reason is not null");
            return (Criteria) this;
        }

        public Criteria andGoodReasonEqualTo(String value) {
            addCriterion("good_reason =", value, "goodReason");
            return (Criteria) this;
        }

        public Criteria andGoodReasonNotEqualTo(String value) {
            addCriterion("good_reason <>", value, "goodReason");
            return (Criteria) this;
        }

        public Criteria andGoodReasonGreaterThan(String value) {
            addCriterion("good_reason >", value, "goodReason");
            return (Criteria) this;
        }

        public Criteria andGoodReasonGreaterThanOrEqualTo(String value) {
            addCriterion("good_reason >=", value, "goodReason");
            return (Criteria) this;
        }

        public Criteria andGoodReasonLessThan(String value) {
            addCriterion("good_reason <", value, "goodReason");
            return (Criteria) this;
        }

        public Criteria andGoodReasonLessThanOrEqualTo(String value) {
            addCriterion("good_reason <=", value, "goodReason");
            return (Criteria) this;
        }

        public Criteria andGoodReasonLike(String value) {
            addCriterion("good_reason like", value, "goodReason");
            return (Criteria) this;
        }

        public Criteria andGoodReasonNotLike(String value) {
            addCriterion("good_reason not like", value, "goodReason");
            return (Criteria) this;
        }

        public Criteria andGoodReasonIn(List<String> values) {
            addCriterion("good_reason in", values, "goodReason");
            return (Criteria) this;
        }

        public Criteria andGoodReasonNotIn(List<String> values) {
            addCriterion("good_reason not in", values, "goodReason");
            return (Criteria) this;
        }

        public Criteria andGoodReasonBetween(String value1, String value2) {
            addCriterion("good_reason between", value1, value2, "goodReason");
            return (Criteria) this;
        }

        public Criteria andGoodReasonNotBetween(String value1, String value2) {
            addCriterion("good_reason not between", value1, value2, "goodReason");
            return (Criteria) this;
        }

        public Criteria andJoinEqualLike(String value, String tableName) {
            addCriterion(tableName + " like ", value, tableName);
            return (Criteria) this;
        }

        public Criteria andJoinEqualTo(Object value, String tableName) {
            addCriterion(tableName + " = ", value, tableName);
            return (Criteria) this;
        }
    }

    /**
     * 类注释
     * Criteria
     * 数据库表：t_goodgraduation
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * Criterion
     * 数据库表：t_goodgraduation
     */
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

        protected Criterion(String condition, Object value, Object secondValue,
                            String typeHandler) {
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