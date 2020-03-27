package com.graduationaldesign.graduation.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReplyTeamExample implements Example {

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table reply_team
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table reply_team
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table reply_team
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    private String join;

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }

    /**
     * 构造查询条件,reply_team
     */
    public ReplyTeamExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 设置排序字段,reply_team
     *
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 获取排序字段,reply_team
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 设置过滤重复数据,reply_team
     *
     * @param distinct 是否过滤重复数据
     */
    @Override
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 是否过滤重复数据,reply_team
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 获取当前的查询条件实例,reply_team
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * ,reply_team
     *
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * ,reply_team
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 创建一个查询条件,reply_team
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 内部构建查询条件对象,reply_team
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 清除查询条件,reply_team
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * InnoDB free: 11264 kB; (`team_leader_id`) REFER `graduationmanagement/t_teacher`
     * GeneratedCriteria
     * 数据库表：reply_team
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

        public Criteria andTeamNameIsNull() {
            addCriterion("team_name is null");
            return (Criteria) this;
        }

        public Criteria andTeamNameIsNotNull() {
            addCriterion("team_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeamNameEqualTo(String value) {
            addCriterion("team_name =", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotEqualTo(String value) {
            addCriterion("team_name <>", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThan(String value) {
            addCriterion("team_name >", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThanOrEqualTo(String value) {
            addCriterion("team_name >=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThan(String value) {
            addCriterion("team_name <", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThanOrEqualTo(String value) {
            addCriterion("team_name <=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLike(String value) {
            addCriterion("team_name like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotLike(String value) {
            addCriterion("team_name not like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameIn(List<String> values) {
            addCriterion("team_name in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotIn(List<String> values) {
            addCriterion("team_name not in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameBetween(String value1, String value2) {
            addCriterion("team_name between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotBetween(String value1, String value2) {
            addCriterion("team_name not between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamAddressIsNull() {
            addCriterion("team_address is null");
            return (Criteria) this;
        }

        public Criteria andTeamAddressIsNotNull() {
            addCriterion("team_address is not null");
            return (Criteria) this;
        }

        public Criteria andTeamAddressEqualTo(String value) {
            addCriterion("team_address =", value, "teamAddress");
            return (Criteria) this;
        }

        public Criteria andTeamAddressNotEqualTo(String value) {
            addCriterion("team_address <>", value, "teamAddress");
            return (Criteria) this;
        }

        public Criteria andTeamAddressGreaterThan(String value) {
            addCriterion("team_address >", value, "teamAddress");
            return (Criteria) this;
        }

        public Criteria andTeamAddressGreaterThanOrEqualTo(String value) {
            addCriterion("team_address >=", value, "teamAddress");
            return (Criteria) this;
        }

        public Criteria andTeamAddressLessThan(String value) {
            addCriterion("team_address <", value, "teamAddress");
            return (Criteria) this;
        }

        public Criteria andTeamAddressLessThanOrEqualTo(String value) {
            addCriterion("team_address <=", value, "teamAddress");
            return (Criteria) this;
        }

        public Criteria andTeamAddressLike(String value) {
            addCriterion("team_address like", value, "teamAddress");
            return (Criteria) this;
        }

        public Criteria andTeamAddressNotLike(String value) {
            addCriterion("team_address not like", value, "teamAddress");
            return (Criteria) this;
        }

        public Criteria andTeamAddressIn(List<String> values) {
            addCriterion("team_address in", values, "teamAddress");
            return (Criteria) this;
        }

        public Criteria andTeamAddressNotIn(List<String> values) {
            addCriterion("team_address not in", values, "teamAddress");
            return (Criteria) this;
        }

        public Criteria andTeamAddressBetween(String value1, String value2) {
            addCriterion("team_address between", value1, value2, "teamAddress");
            return (Criteria) this;
        }

        public Criteria andTeamAddressNotBetween(String value1, String value2) {
            addCriterion("team_address not between", value1, value2, "teamAddress");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIsNull() {
            addCriterion("reply_time is null");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIsNotNull() {
            addCriterion("reply_time is not null");
            return (Criteria) this;
        }

        public Criteria andReplyTimeEqualTo(Date value) {
            addCriterion("reply_time =", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotEqualTo(Date value) {
            addCriterion("reply_time <>", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeGreaterThan(Date value) {
            addCriterion("reply_time >", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reply_time >=", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeLessThan(Date value) {
            addCriterion("reply_time <", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("reply_time <=", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIn(List<Date> values) {
            addCriterion("reply_time in", values, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotIn(List<Date> values) {
            addCriterion("reply_time not in", values, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeBetween(Date value1, Date value2) {
            addCriterion("reply_time between", value1, value2, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("reply_time not between", value1, value2, "replyTime");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderIdIsNull() {
            addCriterion("team_leader_id is null");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderIdIsNotNull() {
            addCriterion("team_leader_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderIdEqualTo(String value) {
            addCriterion("team_leader_id =", value, "teamLeaderId");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderIdNotEqualTo(String value) {
            addCriterion("team_leader_id <>", value, "teamLeaderId");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderIdGreaterThan(String value) {
            addCriterion("team_leader_id >", value, "teamLeaderId");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderIdGreaterThanOrEqualTo(String value) {
            addCriterion("team_leader_id >=", value, "teamLeaderId");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderIdLessThan(String value) {
            addCriterion("team_leader_id <", value, "teamLeaderId");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderIdLessThanOrEqualTo(String value) {
            addCriterion("team_leader_id <=", value, "teamLeaderId");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderIdLike(String value) {
            addCriterion("team_leader_id like", value, "teamLeaderId");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderIdNotLike(String value) {
            addCriterion("team_leader_id not like", value, "teamLeaderId");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderIdIn(List<String> values) {
            addCriterion("team_leader_id in", values, "teamLeaderId");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderIdNotIn(List<String> values) {
            addCriterion("team_leader_id not in", values, "teamLeaderId");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderIdBetween(String value1, String value2) {
            addCriterion("team_leader_id between", value1, value2, "teamLeaderId");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderIdNotBetween(String value1, String value2) {
            addCriterion("team_leader_id not between", value1, value2, "teamLeaderId");
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
     * 数据库表：reply_team
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * InnoDB free: 11264 kB; (`team_leader_id`) REFER `graduationmanagement/t_teacher`
     * Criterion
     * 数据库表：reply_team
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