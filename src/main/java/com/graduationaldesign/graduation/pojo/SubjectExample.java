package com.graduationaldesign.graduation.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubjectExample implements Example {

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_subject
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_subject
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_subject
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    private String join;

    private String resultString;

    public String getResultString() {
        return resultString;
    }

    public void setResultString(String resultString) {
        this.resultString = resultString;
    }

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }

    /**
     * 构造查询条件,t_subject
     */
    public SubjectExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 设置排序字段,t_subject
     *
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 获取排序字段,t_subject
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 设置过滤重复数据,t_subject
     *
     * @param distinct 是否过滤重复数据
     */
    @Override
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 是否过滤重复数据,t_subject
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 获取当前的查询条件实例,t_subject
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * ,t_subject
     *
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * ,t_subject
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 创建一个查询条件,t_subject
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
     * 内部构建查询条件对象,t_subject
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 清除查询条件,t_subject
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * InnoDB free: 11264 kB; (`stu_id`) REFER `graduationmanagement/t_student`(`stu_id
     * GeneratedCriteria
     * 数据库表：t_subject
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

        public Criteria andSubIdIsNull() {
            addCriterion("sub_id is null");
            return (Criteria) this;
        }

        public Criteria andSubIdIsNotNull() {
            addCriterion("sub_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubIdEqualTo(String value) {
            addCriterion("sub_id =", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotEqualTo(String value) {
            addCriterion("sub_id <>", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdGreaterThan(String value) {
            addCriterion("sub_id >", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_id >=", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLessThan(String value) {
            addCriterion("sub_id <", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLessThanOrEqualTo(String value) {
            addCriterion("sub_id <=", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLike(String value) {
            addCriterion("sub_id like", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotLike(String value) {
            addCriterion("sub_id not like", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdIn(List<String> values) {
            addCriterion("sub_id in", values, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotIn(List<String> values) {
            addCriterion("sub_id not in", values, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdBetween(String value1, String value2) {
            addCriterion("sub_id between", value1, value2, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotBetween(String value1, String value2) {
            addCriterion("sub_id not between", value1, value2, "subId");
            return (Criteria) this;
        }

        public Criteria andSubNameIsNull() {
            addCriterion("sub_name is null");
            return (Criteria) this;
        }

        public Criteria andSubNameIsNotNull() {
            addCriterion("sub_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubNameEqualTo(String value) {
            addCriterion("sub_name =", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotEqualTo(String value) {
            addCriterion("sub_name <>", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameGreaterThan(String value) {
            addCriterion("sub_name >", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameGreaterThanOrEqualTo(String value) {
            addCriterion("sub_name >=", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameLessThan(String value) {
            addCriterion("sub_name <", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameLessThanOrEqualTo(String value) {
            addCriterion("sub_name <=", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameLike(String value) {
            addCriterion("sub_name like", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotLike(String value) {
            addCriterion("sub_name not like", value, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameIn(List<String> values) {
            addCriterion("sub_name in", values, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotIn(List<String> values) {
            addCriterion("sub_name not in", values, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameBetween(String value1, String value2) {
            addCriterion("sub_name between", value1, value2, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNameNotBetween(String value1, String value2) {
            addCriterion("sub_name not between", value1, value2, "subName");
            return (Criteria) this;
        }

        public Criteria andSubNatureIsNull() {
            addCriterion("sub_nature is null");
            return (Criteria) this;
        }

        public Criteria andSubNatureIsNotNull() {
            addCriterion("sub_nature is not null");
            return (Criteria) this;
        }

        public Criteria andSubNatureEqualTo(Integer value) {
            addCriterion("sub_nature =", value, "subNature");
            return (Criteria) this;
        }

        public Criteria andSubNatureNotEqualTo(Integer value) {
            addCriterion("sub_nature <>", value, "subNature");
            return (Criteria) this;
        }

        public Criteria andSubNatureGreaterThan(Integer value) {
            addCriterion("sub_nature >", value, "subNature");
            return (Criteria) this;
        }

        public Criteria andSubNatureGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_nature >=", value, "subNature");
            return (Criteria) this;
        }

        public Criteria andSubNatureLessThan(Integer value) {
            addCriterion("sub_nature <", value, "subNature");
            return (Criteria) this;
        }

        public Criteria andSubNatureLessThanOrEqualTo(Integer value) {
            addCriterion("sub_nature <=", value, "subNature");
            return (Criteria) this;
        }

        public Criteria andSubNatureIn(List<Integer> values) {
            addCriterion("sub_nature in", values, "subNature");
            return (Criteria) this;
        }

        public Criteria andSubNatureNotIn(List<Integer> values) {
            addCriterion("sub_nature not in", values, "subNature");
            return (Criteria) this;
        }

        public Criteria andSubNatureBetween(Integer value1, Integer value2) {
            addCriterion("sub_nature between", value1, value2, "subNature");
            return (Criteria) this;
        }

        public Criteria andSubNatureNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_nature not between", value1, value2, "subNature");
            return (Criteria) this;
        }

        public Criteria andSubSourceIsNull() {
            addCriterion("sub_source is null");
            return (Criteria) this;
        }

        public Criteria andSubSourceIsNotNull() {
            addCriterion("sub_source is not null");
            return (Criteria) this;
        }

        public Criteria andSubSourceEqualTo(Integer value) {
            addCriterion("sub_source =", value, "subSource");
            return (Criteria) this;
        }

        public Criteria andSubSourceNotEqualTo(Integer value) {
            addCriterion("sub_source <>", value, "subSource");
            return (Criteria) this;
        }

        public Criteria andSubSourceGreaterThan(Integer value) {
            addCriterion("sub_source >", value, "subSource");
            return (Criteria) this;
        }

        public Criteria andSubSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_source >=", value, "subSource");
            return (Criteria) this;
        }

        public Criteria andSubSourceLessThan(Integer value) {
            addCriterion("sub_source <", value, "subSource");
            return (Criteria) this;
        }

        public Criteria andSubSourceLessThanOrEqualTo(Integer value) {
            addCriterion("sub_source <=", value, "subSource");
            return (Criteria) this;
        }

        public Criteria andSubSourceIn(List<Integer> values) {
            addCriterion("sub_source in", values, "subSource");
            return (Criteria) this;
        }

        public Criteria andSubSourceNotIn(List<Integer> values) {
            addCriterion("sub_source not in", values, "subSource");
            return (Criteria) this;
        }

        public Criteria andSubSourceBetween(Integer value1, Integer value2) {
            addCriterion("sub_source between", value1, value2, "subSource");
            return (Criteria) this;
        }

        public Criteria andSubSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_source not between", value1, value2, "subSource");
            return (Criteria) this;
        }

        public Criteria andSubTeaIdIsNull() {
            addCriterion("sub_tea_id is null");
            return (Criteria) this;
        }

        public Criteria andSubTeaIdIsNotNull() {
            addCriterion("sub_tea_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubTeaIdEqualTo(String value) {
            addCriterion("sub_tea_id =", value, "subTeaId");
            return (Criteria) this;
        }

        public Criteria andSubTeaIdNotEqualTo(String value) {
            addCriterion("sub_tea_id <>", value, "subTeaId");
            return (Criteria) this;
        }

        public Criteria andSubTeaIdGreaterThan(String value) {
            addCriterion("sub_tea_id >", value, "subTeaId");
            return (Criteria) this;
        }

        public Criteria andSubTeaIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_tea_id >=", value, "subTeaId");
            return (Criteria) this;
        }

        public Criteria andSubTeaIdLessThan(String value) {
            addCriterion("sub_tea_id <", value, "subTeaId");
            return (Criteria) this;
        }

        public Criteria andSubTeaIdLessThanOrEqualTo(String value) {
            addCriterion("sub_tea_id <=", value, "subTeaId");
            return (Criteria) this;
        }

        public Criteria andSubTeaIdLike(String value) {
            addCriterion("sub_tea_id like", value, "subTeaId");
            return (Criteria) this;
        }

        public Criteria andSubTeaIdNotLike(String value) {
            addCriterion("sub_tea_id not like", value, "subTeaId");
            return (Criteria) this;
        }

        public Criteria andSubTeaIdIn(List<String> values) {
            addCriterion("sub_tea_id in", values, "subTeaId");
            return (Criteria) this;
        }

        public Criteria andSubTeaIdNotIn(List<String> values) {
            addCriterion("sub_tea_id not in", values, "subTeaId");
            return (Criteria) this;
        }

        public Criteria andSubTeaIdBetween(String value1, String value2) {
            addCriterion("sub_tea_id between", value1, value2, "subTeaId");
            return (Criteria) this;
        }

        public Criteria andSubTeaIdNotBetween(String value1, String value2) {
            addCriterion("sub_tea_id not between", value1, value2, "subTeaId");
            return (Criteria) this;
        }

        public Criteria andSubFileIsNull() {
            addCriterion("sub_file is null");
            return (Criteria) this;
        }

        public Criteria andSubFileIsNotNull() {
            addCriterion("sub_file is not null");
            return (Criteria) this;
        }

        public Criteria andSubFileEqualTo(String value) {
            addCriterion("sub_file =", value, "subFile");
            return (Criteria) this;
        }

        public Criteria andSubFileNotEqualTo(String value) {
            addCriterion("sub_file <>", value, "subFile");
            return (Criteria) this;
        }

        public Criteria andSubFileGreaterThan(String value) {
            addCriterion("sub_file >", value, "subFile");
            return (Criteria) this;
        }

        public Criteria andSubFileGreaterThanOrEqualTo(String value) {
            addCriterion("sub_file >=", value, "subFile");
            return (Criteria) this;
        }

        public Criteria andSubFileLessThan(String value) {
            addCriterion("sub_file <", value, "subFile");
            return (Criteria) this;
        }

        public Criteria andSubFileLessThanOrEqualTo(String value) {
            addCriterion("sub_file <=", value, "subFile");
            return (Criteria) this;
        }

        public Criteria andSubFileLike(String value) {
            addCriterion("sub_file like", value, "subFile");
            return (Criteria) this;
        }

        public Criteria andSubFileNotLike(String value) {
            addCriterion("sub_file not like", value, "subFile");
            return (Criteria) this;
        }

        public Criteria andSubFileIn(List<String> values) {
            addCriterion("sub_file in", values, "subFile");
            return (Criteria) this;
        }

        public Criteria andSubFileNotIn(List<String> values) {
            addCriterion("sub_file not in", values, "subFile");
            return (Criteria) this;
        }

        public Criteria andSubFileBetween(String value1, String value2) {
            addCriterion("sub_file between", value1, value2, "subFile");
            return (Criteria) this;
        }

        public Criteria andSubFileNotBetween(String value1, String value2) {
            addCriterion("sub_file not between", value1, value2, "subFile");
            return (Criteria) this;
        }

        public Criteria andFirstReportDeadlineIsNull() {
            addCriterion("first_report_deadline is null");
            return (Criteria) this;
        }

        public Criteria andFirstReportDeadlineIsNotNull() {
            addCriterion("first_report_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andFirstReportDeadlineEqualTo(Date value) {
            addCriterion("first_report_deadline =", value, "firstReportDeadline");
            return (Criteria) this;
        }

        public Criteria andFirstReportDeadlineNotEqualTo(Date value) {
            addCriterion("first_report_deadline <>", value, "firstReportDeadline");
            return (Criteria) this;
        }

        public Criteria andFirstReportDeadlineGreaterThan(Date value) {
            addCriterion("first_report_deadline >", value, "firstReportDeadline");
            return (Criteria) this;
        }

        public Criteria andFirstReportDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("first_report_deadline >=", value, "firstReportDeadline");
            return (Criteria) this;
        }

        public Criteria andFirstReportDeadlineLessThan(Date value) {
            addCriterion("first_report_deadline <", value, "firstReportDeadline");
            return (Criteria) this;
        }

        public Criteria andFirstReportDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("first_report_deadline <=", value, "firstReportDeadline");
            return (Criteria) this;
        }

        public Criteria andFirstReportDeadlineIn(List<Date> values) {
            addCriterion("first_report_deadline in", values, "firstReportDeadline");
            return (Criteria) this;
        }

        public Criteria andFirstReportDeadlineNotIn(List<Date> values) {
            addCriterion("first_report_deadline not in", values, "firstReportDeadline");
            return (Criteria) this;
        }

        public Criteria andFirstReportDeadlineBetween(Date value1, Date value2) {
            addCriterion("first_report_deadline between", value1, value2, "firstReportDeadline");
            return (Criteria) this;
        }

        public Criteria andFirstReportDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("first_report_deadline not between", value1, value2,
                    "firstReportDeadline");
            return (Criteria) this;
        }

        public Criteria andLastReportDeadlineIsNull() {
            addCriterion("last_report_deadline is null");
            return (Criteria) this;
        }

        public Criteria andLastReportDeadlineIsNotNull() {
            addCriterion("last_report_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andLastReportDeadlineEqualTo(Date value) {
            addCriterion("last_report_deadline =", value, "lastReportDeadline");
            return (Criteria) this;
        }

        public Criteria andLastReportDeadlineNotEqualTo(Date value) {
            addCriterion("last_report_deadline <>", value, "lastReportDeadline");
            return (Criteria) this;
        }

        public Criteria andLastReportDeadlineGreaterThan(Date value) {
            addCriterion("last_report_deadline >", value, "lastReportDeadline");
            return (Criteria) this;
        }

        public Criteria andLastReportDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterion("last_report_deadline >=", value, "lastReportDeadline");
            return (Criteria) this;
        }

        public Criteria andLastReportDeadlineLessThan(Date value) {
            addCriterion("last_report_deadline <", value, "lastReportDeadline");
            return (Criteria) this;
        }

        public Criteria andLastReportDeadlineLessThanOrEqualTo(Date value) {
            addCriterion("last_report_deadline <=", value, "lastReportDeadline");
            return (Criteria) this;
        }

        public Criteria andLastReportDeadlineIn(List<Date> values) {
            addCriterion("last_report_deadline in", values, "lastReportDeadline");
            return (Criteria) this;
        }

        public Criteria andLastReportDeadlineNotIn(List<Date> values) {
            addCriterion("last_report_deadline not in", values, "lastReportDeadline");
            return (Criteria) this;
        }

        public Criteria andLastReportDeadlineBetween(Date value1, Date value2) {
            addCriterion("last_report_deadline between", value1, value2, "lastReportDeadline");
            return (Criteria) this;
        }

        public Criteria andLastReportDeadlineNotBetween(Date value1, Date value2) {
            addCriterion("last_report_deadline not between", value1, value2, "lastReportDeadline");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNull() {
            addCriterion("stu_id is null");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNotNull() {
            addCriterion("stu_id is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdEqualTo(String value) {
            addCriterion("stu_id =", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotEqualTo(String value) {
            addCriterion("stu_id <>", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThan(String value) {
            addCriterion("stu_id >", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThanOrEqualTo(String value) {
            addCriterion("stu_id >=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThan(String value) {
            addCriterion("stu_id <", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThanOrEqualTo(String value) {
            addCriterion("stu_id <=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLike(String value) {
            addCriterion("stu_id like", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotLike(String value) {
            addCriterion("stu_id not like", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdIn(List<String> values) {
            addCriterion("stu_id in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotIn(List<String> values) {
            addCriterion("stu_id not in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdBetween(String value1, String value2) {
            addCriterion("stu_id between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotBetween(String value1, String value2) {
            addCriterion("stu_id not between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andSubStuStateIsNull() {
            addCriterion("sub_stu_state is null");
            return (Criteria) this;
        }

        public Criteria andSubStuStateIsNotNull() {
            addCriterion("sub_stu_state is not null");
            return (Criteria) this;
        }

        public Criteria andSubStuStateEqualTo(Integer value) {
            addCriterion("sub_stu_state =", value, "subStuState");
            return (Criteria) this;
        }

        public Criteria andSubStuStateNotEqualTo(Integer value) {
            addCriterion("sub_stu_state <>", value, "subStuState");
            return (Criteria) this;
        }

        public Criteria andSubStuStateGreaterThan(Integer value) {
            addCriterion("sub_stu_state >", value, "subStuState");
            return (Criteria) this;
        }

        public Criteria andSubStuStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_stu_state >=", value, "subStuState");
            return (Criteria) this;
        }

        public Criteria andSubStuStateLessThan(Integer value) {
            addCriterion("sub_stu_state <", value, "subStuState");
            return (Criteria) this;
        }

        public Criteria andSubStuStateLessThanOrEqualTo(Integer value) {
            addCriterion("sub_stu_state <=", value, "subStuState");
            return (Criteria) this;
        }

        public Criteria andSubStuStateIn(List<Integer> values) {
            addCriterion("sub_stu_state in", values, "subStuState");
            return (Criteria) this;
        }

        public Criteria andSubStuStateNotIn(List<Integer> values) {
            addCriterion("sub_stu_state not in", values, "subStuState");
            return (Criteria) this;
        }

        public Criteria andSubStuStateBetween(Integer value1, Integer value2) {
            addCriterion("sub_stu_state between", value1, value2, "subStuState");
            return (Criteria) this;
        }

        public Criteria andSubStuStateNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_stu_state not between", value1, value2, "subStuState");
            return (Criteria) this;
        }

        public Criteria andSubLastScoreIsNull() {
            addCriterion("sub_last_score is null");
            return (Criteria) this;
        }

        public Criteria andSubLastScoreIsNotNull() {
            addCriterion("sub_last_score is not null");
            return (Criteria) this;
        }

        public Criteria andSubLastScoreEqualTo(Long value) {
            addCriterion("sub_last_score =", value, "subLastScore");
            return (Criteria) this;
        }

        public Criteria andSubLastScoreNotEqualTo(Long value) {
            addCriterion("sub_last_score <>", value, "subLastScore");
            return (Criteria) this;
        }

        public Criteria andSubLastScoreGreaterThan(Long value) {
            addCriterion("sub_last_score >", value, "subLastScore");
            return (Criteria) this;
        }

        public Criteria andSubLastScoreGreaterThanOrEqualTo(Long value) {
            addCriterion("sub_last_score >=", value, "subLastScore");
            return (Criteria) this;
        }

        public Criteria andSubLastScoreLessThan(Long value) {
            addCriterion("sub_last_score <", value, "subLastScore");
            return (Criteria) this;
        }

        public Criteria andSubLastScoreLessThanOrEqualTo(Long value) {
            addCriterion("sub_last_score <=", value, "subLastScore");
            return (Criteria) this;
        }

        public Criteria andSubLastScoreIn(List<Long> values) {
            addCriterion("sub_last_score in", values, "subLastScore");
            return (Criteria) this;
        }

        public Criteria andSubLastScoreNotIn(List<Long> values) {
            addCriterion("sub_last_score not in", values, "subLastScore");
            return (Criteria) this;
        }

        public Criteria andSubLastScoreBetween(Long value1, Long value2) {
            addCriterion("sub_last_score between", value1, value2, "subLastScore");
            return (Criteria) this;
        }

        public Criteria andSubLastScoreNotBetween(Long value1, Long value2) {
            addCriterion("sub_last_score not between", value1, value2, "subLastScore");
            return (Criteria) this;
        }

        public Criteria andShowIdIsNull() {
            addCriterion("show_id is null");
            return (Criteria) this;
        }

        public Criteria andShowIdIsNotNull() {
            addCriterion("show_id is not null");
            return (Criteria) this;
        }

        public Criteria andShowIdEqualTo(Integer value) {
            addCriterion("show_id =", value, "showId");
            return (Criteria) this;
        }

        public Criteria andShowIdNotEqualTo(Integer value) {
            addCriterion("show_id <>", value, "showId");
            return (Criteria) this;
        }

        public Criteria andShowIdGreaterThan(Integer value) {
            addCriterion("show_id >", value, "showId");
            return (Criteria) this;
        }

        public Criteria andShowIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_id >=", value, "showId");
            return (Criteria) this;
        }

        public Criteria andShowIdLessThan(Integer value) {
            addCriterion("show_id <", value, "showId");
            return (Criteria) this;
        }

        public Criteria andShowIdLessThanOrEqualTo(Integer value) {
            addCriterion("show_id <=", value, "showId");
            return (Criteria) this;
        }

        public Criteria andShowIdIn(List<Integer> values) {
            addCriterion("show_id in", values, "showId");
            return (Criteria) this;
        }

        public Criteria andShowIdNotIn(List<Integer> values) {
            addCriterion("show_id not in", values, "showId");
            return (Criteria) this;
        }

        public Criteria andShowIdBetween(Integer value1, Integer value2) {
            addCriterion("show_id between", value1, value2, "showId");
            return (Criteria) this;
        }

        public Criteria andShowIdNotBetween(Integer value1, Integer value2) {
            addCriterion("show_id not between", value1, value2, "showId");
            return (Criteria) this;
        }

        public Criteria andSubIntroduceIsNull() {
            addCriterion("sub_introduce is null");
            return (Criteria) this;
        }

        public Criteria andSubIntroduceIsNotNull() {
            addCriterion("sub_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andSubIntroduceEqualTo(String value) {
            addCriterion("sub_introduce =", value, "subIntroduce");
            return (Criteria) this;
        }

        public Criteria andSubIntroduceNotEqualTo(String value) {
            addCriterion("sub_introduce <>", value, "subIntroduce");
            return (Criteria) this;
        }

        public Criteria andSubIntroduceGreaterThan(String value) {
            addCriterion("sub_introduce >", value, "subIntroduce");
            return (Criteria) this;
        }

        public Criteria andSubIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("sub_introduce >=", value, "subIntroduce");
            return (Criteria) this;
        }

        public Criteria andSubIntroduceLessThan(String value) {
            addCriterion("sub_introduce <", value, "subIntroduce");
            return (Criteria) this;
        }

        public Criteria andSubIntroduceLessThanOrEqualTo(String value) {
            addCriterion("sub_introduce <=", value, "subIntroduce");
            return (Criteria) this;
        }

        public Criteria andSubIntroduceLike(String value) {
            addCriterion("sub_introduce like", value, "subIntroduce");
            return (Criteria) this;
        }

        public Criteria andSubIntroduceNotLike(String value) {
            addCriterion("sub_introduce not like", value, "subIntroduce");
            return (Criteria) this;
        }

        public Criteria andSubIntroduceIn(List<String> values) {
            addCriterion("sub_introduce in", values, "subIntroduce");
            return (Criteria) this;
        }

        public Criteria andSubIntroduceNotIn(List<String> values) {
            addCriterion("sub_introduce not in", values, "subIntroduce");
            return (Criteria) this;
        }

        public Criteria andSubIntroduceBetween(String value1, String value2) {
            addCriterion("sub_introduce between", value1, value2, "subIntroduce");
            return (Criteria) this;
        }

        public Criteria andSubIntroduceNotBetween(String value1, String value2) {
            addCriterion("sub_introduce not between", value1, value2, "subIntroduce");
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
     * 数据库表：t_subject
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * InnoDB free: 11264 kB; (`stu_id`) REFER `graduationmanagement/t_student`(`stu_id
     * Criterion
     * 数据库表：t_subject
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