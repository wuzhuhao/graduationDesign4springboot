package com.graduationaldesign.graduation.pojo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScoreRecordExample implements Example {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_scorerecord
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_scorerecord
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_scorerecord
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;
    protected String join;

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }

    /**
     * 构造查询条件,t_scorerecord
     */
    public ScoreRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 设置排序字段,t_scorerecord
     *
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 获取排序字段,t_scorerecord
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 设置过滤重复数据,t_scorerecord
     *
     * @param distinct 是否过滤重复数据
     */
    @Override
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 是否过滤重复数据,t_scorerecord
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 获取当前的查询条件实例,t_scorerecord
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * ,t_scorerecord
     *
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * ,t_scorerecord
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 创建一个查询条件,t_scorerecord
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
     * 内部构建查询条件对象,t_scorerecord
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 清除查询条件,t_scorerecord
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * GeneratedCriteria
     * 数据库表：t_scorerecord
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

        public Criteria andScoreSubIdIsNull() {
            addCriterion("score_sub_id is null");
            return (Criteria) this;
        }

        public Criteria andScoreSubIdIsNotNull() {
            addCriterion("score_sub_id is not null");
            return (Criteria) this;
        }

        public Criteria andScoreSubIdEqualTo(String value) {
            addCriterion("score_sub_id =", value, "scoreSubId");
            return (Criteria) this;
        }

        public Criteria andScoreSubIdNotEqualTo(String value) {
            addCriterion("score_sub_id <>", value, "scoreSubId");
            return (Criteria) this;
        }

        public Criteria andScoreSubIdGreaterThan(String value) {
            addCriterion("score_sub_id >", value, "scoreSubId");
            return (Criteria) this;
        }

        public Criteria andScoreSubIdGreaterThanOrEqualTo(String value) {
            addCriterion("score_sub_id >=", value, "scoreSubId");
            return (Criteria) this;
        }

        public Criteria andScoreSubIdLessThan(String value) {
            addCriterion("score_sub_id <", value, "scoreSubId");
            return (Criteria) this;
        }

        public Criteria andScoreSubIdLessThanOrEqualTo(String value) {
            addCriterion("score_sub_id <=", value, "scoreSubId");
            return (Criteria) this;
        }

        public Criteria andScoreSubIdLike(String value) {
            addCriterion("score_sub_id like", value, "scoreSubId");
            return (Criteria) this;
        }

        public Criteria andScoreSubIdNotLike(String value) {
            addCriterion("score_sub_id not like", value, "scoreSubId");
            return (Criteria) this;
        }

        public Criteria andScoreSubIdIn(List<String> values) {
            addCriterion("score_sub_id in", values, "scoreSubId");
            return (Criteria) this;
        }

        public Criteria andScoreSubIdNotIn(List<String> values) {
            addCriterion("score_sub_id not in", values, "scoreSubId");
            return (Criteria) this;
        }

        public Criteria andScoreSubIdBetween(String value1, String value2) {
            addCriterion("score_sub_id between", value1, value2, "scoreSubId");
            return (Criteria) this;
        }

        public Criteria andScoreSubIdNotBetween(String value1, String value2) {
            addCriterion("score_sub_id not between", value1, value2, "scoreSubId");
            return (Criteria) this;
        }

        public Criteria andFirstReportScoreIsNull() {
            addCriterion("first_report_score is null");
            return (Criteria) this;
        }

        public Criteria andFirstReportScoreIsNotNull() {
            addCriterion("first_report_score is not null");
            return (Criteria) this;
        }

        public Criteria andFirstReportScoreEqualTo(Long value) {
            addCriterion("first_report_score =", value, "firstReportScore");
            return (Criteria) this;
        }

        public Criteria andFirstReportScoreNotEqualTo(Long value) {
            addCriterion("first_report_score <>", value, "firstReportScore");
            return (Criteria) this;
        }

        public Criteria andFirstReportScoreGreaterThan(Long value) {
            addCriterion("first_report_score >", value, "firstReportScore");
            return (Criteria) this;
        }

        public Criteria andFirstReportScoreGreaterThanOrEqualTo(Long value) {
            addCriterion("first_report_score >=", value, "firstReportScore");
            return (Criteria) this;
        }

        public Criteria andFirstReportScoreLessThan(Long value) {
            addCriterion("first_report_score <", value, "firstReportScore");
            return (Criteria) this;
        }

        public Criteria andFirstReportScoreLessThanOrEqualTo(Long value) {
            addCriterion("first_report_score <=", value, "firstReportScore");
            return (Criteria) this;
        }

        public Criteria andFirstReportScoreIn(List<Long> values) {
            addCriterion("first_report_score in", values, "firstReportScore");
            return (Criteria) this;
        }

        public Criteria andFirstReportScoreNotIn(List<Long> values) {
            addCriterion("first_report_score not in", values, "firstReportScore");
            return (Criteria) this;
        }

        public Criteria andFirstReportScoreBetween(Long value1, Long value2) {
            addCriterion("first_report_score between", value1, value2, "firstReportScore");
            return (Criteria) this;
        }

        public Criteria andFirstReportScoreNotBetween(Long value1, Long value2) {
            addCriterion("first_report_score not between", value1, value2, "firstReportScore");
            return (Criteria) this;
        }

        public Criteria andFinalReportScoreIsNull() {
            addCriterion("final_report_score is null");
            return (Criteria) this;
        }

        public Criteria andFinalReportScoreIsNotNull() {
            addCriterion("final_report_score is not null");
            return (Criteria) this;
        }

        public Criteria andFinalReportScoreEqualTo(Long value) {
            addCriterion("final_report_score =", value, "finalReportScore");
            return (Criteria) this;
        }

        public Criteria andJoinStuIdNotEqualTo(String value) {
            addCriterion("t_subject.stu_id != ", value, "t_subject.stu_id");
            return (Criteria) this;
        }

        public Criteria andFinalReportScoreNotEqualTo(Long value) {
            addCriterion("final_report_score <>", value, "finalReportScore");
            return (Criteria) this;
        }

        public Criteria andFinalReportScoreGreaterThan(Long value) {
            addCriterion("final_report_score >", value, "finalReportScore");
            return (Criteria) this;
        }

        public Criteria andFinalReportScoreGreaterThanOrEqualTo(Long value) {
            addCriterion("final_report_score >=", value, "finalReportScore");
            return (Criteria) this;
        }

        public Criteria andFinalReportScoreLessThan(Long value) {
            addCriterion("final_report_score <", value, "finalReportScore");
            return (Criteria) this;
        }

        public Criteria andFinalReportScoreLessThanOrEqualTo(Long value) {
            addCriterion("final_report_score <=", value, "finalReportScore");
            return (Criteria) this;
        }

        public Criteria andFinalReportScoreIn(List<Long> values) {
            addCriterion("final_report_score in", values, "finalReportScore");
            return (Criteria) this;
        }

        public Criteria andFinalReportScoreNotIn(List<Long> values) {
            addCriterion("final_report_score not in", values, "finalReportScore");
            return (Criteria) this;
        }

        public Criteria andFinalReportScoreBetween(Long value1, Long value2) {
            addCriterion("final_report_score between", value1, value2, "finalReportScore");
            return (Criteria) this;
        }

        public Criteria andFinalReportScoreNotBetween(Long value1, Long value2) {
            addCriterion("final_report_score not between", value1, value2, "finalReportScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreIsNull() {
            addCriterion("reply_score_ is null");
            return (Criteria) this;
        }

        public Criteria andReplyScoreIsNotNull() {
            addCriterion("reply_score_ is not null");
            return (Criteria) this;
        }

        public Criteria andReplyScoreEqualTo(Long value) {
            addCriterion("reply_score_ =", value, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreNotEqualTo(Long value) {
            addCriterion("reply_score_ <>", value, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreGreaterThan(Long value) {
            addCriterion("reply_score_ >", value, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreGreaterThanOrEqualTo(Long value) {
            addCriterion("reply_score_ >=", value, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreLessThan(Long value) {
            addCriterion("reply_score_ <", value, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreLessThanOrEqualTo(Long value) {
            addCriterion("reply_score_ <=", value, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreIn(List<Long> values) {
            addCriterion("reply_score_ in", values, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreNotIn(List<Long> values) {
            addCriterion("reply_score_ not in", values, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreBetween(Long value1, Long value2) {
            addCriterion("reply_score_ between", value1, value2, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreNotBetween(Long value1, Long value2) {
            addCriterion("reply_score_ not between", value1, value2, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyTeamIdIsNull() {
            addCriterion("reply_team_id is null");
            return (Criteria) this;
        }

        public Criteria andReplyTeamIdIsNotNull() {
            addCriterion("reply_team_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplyTeamIdEqualTo(Integer value) {
            addCriterion("reply_team_id =", value, "replyTeamId");
            return (Criteria) this;
        }

        public Criteria andReplyTeamIdNotEqualTo(Integer value) {
            addCriterion("reply_team_id <>", value, "replyTeamId");
            return (Criteria) this;
        }

        public Criteria andReplyTeamIdGreaterThan(Integer value) {
            addCriterion("reply_team_id >", value, "replyTeamId");
            return (Criteria) this;
        }

        public Criteria andReplyTeamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_team_id >=", value, "replyTeamId");
            return (Criteria) this;
        }

        public Criteria andReplyTeamIdLessThan(Integer value) {
            addCriterion("reply_team_id <", value, "replyTeamId");
            return (Criteria) this;
        }

        public Criteria andReplyTeamIdLessThanOrEqualTo(Integer value) {
            addCriterion("reply_team_id <=", value, "replyTeamId");
            return (Criteria) this;
        }

        public Criteria andReplyTeamIdIn(List<Integer> values) {
            addCriterion("reply_team_id in", values, "replyTeamId");
            return (Criteria) this;
        }

        public Criteria andReplyTeamIdNotIn(List<Integer> values) {
            addCriterion("reply_team_id not in", values, "replyTeamId");
            return (Criteria) this;
        }

        public Criteria andReplyTeamIdBetween(Integer value1, Integer value2) {
            addCriterion("reply_team_id between", value1, value2, "replyTeamId");
            return (Criteria) this;
        }

        public Criteria andReplyTeamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_team_id not between", value1, value2, "replyTeamId");
            return (Criteria) this;
        }

        public Criteria andExt1IsNull() {
            addCriterion("ext1 is null");
            return (Criteria) this;
        }

        public Criteria andExt1IsNotNull() {
            addCriterion("ext1 is not null");
            return (Criteria) this;
        }

        public Criteria andExt1EqualTo(String value) {
            addCriterion("ext1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(String value) {
            addCriterion("ext1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(String value) {
            addCriterion("ext1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(String value) {
            addCriterion("ext1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(String value) {
            addCriterion("ext1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(String value) {
            addCriterion("ext1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Like(String value) {
            addCriterion("ext1 like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotLike(String value) {
            addCriterion("ext1 not like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<String> values) {
            addCriterion("ext1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<String> values) {
            addCriterion("ext1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(String value1, String value2) {
            addCriterion("ext1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(String value1, String value2) {
            addCriterion("ext1 not between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt2IsNull() {
            addCriterion("ext2 is null");
            return (Criteria) this;
        }

        public Criteria andExt2IsNotNull() {
            addCriterion("ext2 is not null");
            return (Criteria) this;
        }

        public Criteria andExt2EqualTo(String value) {
            addCriterion("ext2 =", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotEqualTo(String value) {
            addCriterion("ext2 <>", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThan(String value) {
            addCriterion("ext2 >", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThanOrEqualTo(String value) {
            addCriterion("ext2 >=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThan(String value) {
            addCriterion("ext2 <", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThanOrEqualTo(String value) {
            addCriterion("ext2 <=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Like(String value) {
            addCriterion("ext2 like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotLike(String value) {
            addCriterion("ext2 not like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2In(List<String> values) {
            addCriterion("ext2 in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotIn(List<String> values) {
            addCriterion("ext2 not in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Between(String value1, String value2) {
            addCriterion("ext2 between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotBetween(String value1, String value2) {
            addCriterion("ext2 not between", value1, value2, "ext2");
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
     * 数据库表：t_scorerecord
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * Criterion
     * 数据库表：t_scorerecord
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