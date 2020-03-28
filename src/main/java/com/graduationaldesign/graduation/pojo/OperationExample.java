package com.graduationaldesign.graduation.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationExample implements Example {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table log_operation
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table log_operation
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table log_operation
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * 构造查询条件,log_operation
     */
    public OperationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 设置排序字段,log_operation
     *
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 获取排序字段,log_operation
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 设置过滤重复数据,log_operation
     *
     * @param distinct 是否过滤重复数据
     */
    @Override
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 是否过滤重复数据,log_operation
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 获取当前的查询条件实例,log_operation
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * ,log_operation
     *
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * ,log_operation
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 创建一个查询条件,log_operation
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 内部构建查询条件对象,log_operation
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 清除查询条件,log_operation
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * InnoDB free: 11264 kB
     * GeneratedCriteria
     * 数据库表：log_operation
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

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
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

        public Criteria andOperaRoleIsNull() {
            addCriterion("opera_role is null");
            return (Criteria) this;
        }

        public Criteria andOperaRoleIsNotNull() {
            addCriterion("opera_role is not null");
            return (Criteria) this;
        }

        public Criteria andOperaRoleEqualTo(String value) {
            addCriterion("opera_role =", value, "operaRole");
            return (Criteria) this;
        }

        public Criteria andOperaRoleNotEqualTo(String value) {
            addCriterion("opera_role <>", value, "operaRole");
            return (Criteria) this;
        }

        public Criteria andOperaRoleGreaterThan(String value) {
            addCriterion("opera_role >", value, "operaRole");
            return (Criteria) this;
        }

        public Criteria andOperaRoleGreaterThanOrEqualTo(String value) {
            addCriterion("opera_role >=", value, "operaRole");
            return (Criteria) this;
        }

        public Criteria andOperaRoleLessThan(String value) {
            addCriterion("opera_role <", value, "operaRole");
            return (Criteria) this;
        }

        public Criteria andOperaRoleLessThanOrEqualTo(String value) {
            addCriterion("opera_role <=", value, "operaRole");
            return (Criteria) this;
        }

        public Criteria andOperaRoleLike(String value) {
            addCriterion("opera_role like", value, "operaRole");
            return (Criteria) this;
        }

        public Criteria andOperaRoleNotLike(String value) {
            addCriterion("opera_role not like", value, "operaRole");
            return (Criteria) this;
        }

        public Criteria andOperaRoleIn(List<String> values) {
            addCriterion("opera_role in", values, "operaRole");
            return (Criteria) this;
        }

        public Criteria andOperaRoleNotIn(List<String> values) {
            addCriterion("opera_role not in", values, "operaRole");
            return (Criteria) this;
        }

        public Criteria andOperaRoleBetween(String value1, String value2) {
            addCriterion("opera_role between", value1, value2, "operaRole");
            return (Criteria) this;
        }

        public Criteria andOperaRoleNotBetween(String value1, String value2) {
            addCriterion("opera_role not between", value1, value2, "operaRole");
            return (Criteria) this;
        }

        public Criteria andOperaTimeIsNull() {
            addCriterion("opera_time is null");
            return (Criteria) this;
        }

        public Criteria andOperaTimeIsNotNull() {
            addCriterion("opera_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperaTimeEqualTo(Date value) {
            addCriterion("opera_time =", value, "operaTime");
            return (Criteria) this;
        }

        public Criteria andOperaTimeNotEqualTo(Date value) {
            addCriterion("opera_time <>", value, "operaTime");
            return (Criteria) this;
        }

        public Criteria andOperaTimeGreaterThan(Date value) {
            addCriterion("opera_time >", value, "operaTime");
            return (Criteria) this;
        }

        public Criteria andOperaTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("opera_time >=", value, "operaTime");
            return (Criteria) this;
        }

        public Criteria andOperaTimeLessThan(Date value) {
            addCriterion("opera_time <", value, "operaTime");
            return (Criteria) this;
        }

        public Criteria andOperaTimeLessThanOrEqualTo(Date value) {
            addCriterion("opera_time <=", value, "operaTime");
            return (Criteria) this;
        }

        public Criteria andOperaTimeIn(List<Date> values) {
            addCriterion("opera_time in", values, "operaTime");
            return (Criteria) this;
        }

        public Criteria andOperaTimeNotIn(List<Date> values) {
            addCriterion("opera_time not in", values, "operaTime");
            return (Criteria) this;
        }

        public Criteria andOperaTimeBetween(Date value1, Date value2) {
            addCriterion("opera_time between", value1, value2, "operaTime");
            return (Criteria) this;
        }

        public Criteria andOperaTimeNotBetween(Date value1, Date value2) {
            addCriterion("opera_time not between", value1, value2, "operaTime");
            return (Criteria) this;
        }

        public Criteria andOperaContentIsNull() {
            addCriterion("opera_content is null");
            return (Criteria) this;
        }

        public Criteria andOperaContentIsNotNull() {
            addCriterion("opera_content is not null");
            return (Criteria) this;
        }

        public Criteria andOperaContentEqualTo(String value) {
            addCriterion("opera_content =", value, "operaContent");
            return (Criteria) this;
        }

        public Criteria andOperaContentNotEqualTo(String value) {
            addCriterion("opera_content <>", value, "operaContent");
            return (Criteria) this;
        }

        public Criteria andOperaContentGreaterThan(String value) {
            addCriterion("opera_content >", value, "operaContent");
            return (Criteria) this;
        }

        public Criteria andOperaContentGreaterThanOrEqualTo(String value) {
            addCriterion("opera_content >=", value, "operaContent");
            return (Criteria) this;
        }

        public Criteria andOperaContentLessThan(String value) {
            addCriterion("opera_content <", value, "operaContent");
            return (Criteria) this;
        }

        public Criteria andOperaContentLessThanOrEqualTo(String value) {
            addCriterion("opera_content <=", value, "operaContent");
            return (Criteria) this;
        }

        public Criteria andOperaContentLike(String value) {
            addCriterion("opera_content like", value, "operaContent");
            return (Criteria) this;
        }

        public Criteria andOperaContentNotLike(String value) {
            addCriterion("opera_content not like", value, "operaContent");
            return (Criteria) this;
        }

        public Criteria andOperaContentIn(List<String> values) {
            addCriterion("opera_content in", values, "operaContent");
            return (Criteria) this;
        }

        public Criteria andOperaContentNotIn(List<String> values) {
            addCriterion("opera_content not in", values, "operaContent");
            return (Criteria) this;
        }

        public Criteria andOperaContentBetween(String value1, String value2) {
            addCriterion("opera_content between", value1, value2, "operaContent");
            return (Criteria) this;
        }

        public Criteria andOperaContentNotBetween(String value1, String value2) {
            addCriterion("opera_content not between", value1, value2, "operaContent");
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
     * 数据库表：log_operation
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * InnoDB free: 11264 kB
     * Criterion
     * 数据库表：log_operation
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