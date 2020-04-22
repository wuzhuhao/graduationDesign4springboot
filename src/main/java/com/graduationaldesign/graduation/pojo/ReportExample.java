package com.graduationaldesign.graduation.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportExample implements Example {

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_report
     *
     * @mbg.generated
     */
    protected String orderByClause;

    protected String join;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_report
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_report
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * 构造查询条件,t_report
     */
    public ReportExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }

    /**
     * 设置排序字段,t_report
     *
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 获取排序字段,t_report
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 设置过滤重复数据,t_report
     *
     * @param distinct 是否过滤重复数据
     */
    @Override
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 是否过滤重复数据,t_report
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 获取当前的查询条件实例,t_report
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * ,t_report
     *
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * ,t_report
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 创建一个查询条件,t_report
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
     * 内部构建查询条件对象,t_report
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 清除查询条件,t_report
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * GeneratedCriteria
     * 数据库表：t_report
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

        public Criteria andReportSubIdIsNull() {
            addCriterion("report_sub_id is null");
            return (Criteria) this;
        }

        public Criteria andReportSubIdIsNotNull() {
            addCriterion("report_sub_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportSubIdEqualTo(String value) {
            addCriterion("report_sub_id =", value, "reportSubId");
            return (Criteria) this;
        }

        public Criteria andReportSubIdNotEqualTo(String value) {
            addCriterion("report_sub_id <>", value, "reportSubId");
            return (Criteria) this;
        }

        public Criteria andReportSubIdGreaterThan(String value) {
            addCriterion("report_sub_id >", value, "reportSubId");
            return (Criteria) this;
        }

        public Criteria andReportSubIdGreaterThanOrEqualTo(String value) {
            addCriterion("report_sub_id >=", value, "reportSubId");
            return (Criteria) this;
        }

        public Criteria andReportSubIdLessThan(String value) {
            addCriterion("report_sub_id <", value, "reportSubId");
            return (Criteria) this;
        }

        public Criteria andReportSubIdLessThanOrEqualTo(String value) {
            addCriterion("report_sub_id <=", value, "reportSubId");
            return (Criteria) this;
        }

        public Criteria andReportSubIdLike(String value) {
            addCriterion("report_sub_id like", value, "reportSubId");
            return (Criteria) this;
        }

        public Criteria andReportSubIdNotLike(String value) {
            addCriterion("report_sub_id not like", value, "reportSubId");
            return (Criteria) this;
        }

        public Criteria andReportSubIdIn(List<String> values) {
            addCriterion("report_sub_id in", values, "reportSubId");
            return (Criteria) this;
        }

        public Criteria andReportSubIdNotIn(List<String> values) {
            addCriterion("report_sub_id not in", values, "reportSubId");
            return (Criteria) this;
        }

        public Criteria andReportSubIdBetween(String value1, String value2) {
            addCriterion("report_sub_id between", value1, value2, "reportSubId");
            return (Criteria) this;
        }

        public Criteria andReportSubIdNotBetween(String value1, String value2) {
            addCriterion("report_sub_id not between", value1, value2, "reportSubId");
            return (Criteria) this;
        }

        public Criteria andReportTypeIsNull() {
            addCriterion("report_type is null");
            return (Criteria) this;
        }

        public Criteria andReportTypeIsNotNull() {
            addCriterion("report_type is not null");
            return (Criteria) this;
        }

        public Criteria andReportTypeEqualTo(Integer value) {
            addCriterion("report_type =", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeNotEqualTo(Integer value) {
            addCriterion("report_type <>", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeGreaterThan(Integer value) {
            addCriterion("report_type >", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_type >=", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeLessThan(Integer value) {
            addCriterion("report_type <", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeLessThanOrEqualTo(Integer value) {
            addCriterion("report_type <=", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeIn(List<Integer> values) {
            addCriterion("report_type in", values, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeNotIn(List<Integer> values) {
            addCriterion("report_type not in", values, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeBetween(Integer value1, Integer value2) {
            addCriterion("report_type between", value1, value2, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("report_type not between", value1, value2, "reportType");
            return (Criteria) this;
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

        public Criteria andReportStateIsNull() {
            addCriterion("report_state is null");
            return (Criteria) this;
        }

        public Criteria andReportStateIsNotNull() {
            addCriterion("report_state is not null");
            return (Criteria) this;
        }

        public Criteria andReportStateEqualTo(Integer value) {
            addCriterion("report_state =", value, "reportState");
            return (Criteria) this;
        }

        public Criteria andReportStateNotEqualTo(Integer value) {
            addCriterion("report_state <>", value, "reportState");
            return (Criteria) this;
        }

        public Criteria andReportStateGreaterThan(Integer value) {
            addCriterion("report_state >", value, "reportState");
            return (Criteria) this;
        }

        public Criteria andReportStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_state >=", value, "reportState");
            return (Criteria) this;
        }

        public Criteria andReportStateLessThan(Integer value) {
            addCriterion("report_state <", value, "reportState");
            return (Criteria) this;
        }

        public Criteria andReportStateLessThanOrEqualTo(Integer value) {
            addCriterion("report_state <=", value, "reportState");
            return (Criteria) this;
        }

        public Criteria andReportStateIn(List<Integer> values) {
            addCriterion("report_state in", values, "reportState");
            return (Criteria) this;
        }

        public Criteria andReportStateNotIn(List<Integer> values) {
            addCriterion("report_state not in", values, "reportState");
            return (Criteria) this;
        }

        public Criteria andReportStateBetween(Integer value1, Integer value2) {
            addCriterion("report_state between", value1, value2, "reportState");
            return (Criteria) this;
        }

        public Criteria andReportStateNotBetween(Integer value1, Integer value2) {
            addCriterion("report_state not between", value1, value2, "reportState");
            return (Criteria) this;
        }

        public Criteria andReportSubtimeIsNull() {
            addCriterion("report_subtime is null");
            return (Criteria) this;
        }

        public Criteria andReportSubtimeIsNotNull() {
            addCriterion("report_subtime is not null");
            return (Criteria) this;
        }

        public Criteria andReportSubtimeEqualTo(Date value) {
            addCriterion("report_subtime =", value, "reportSubtime");
            return (Criteria) this;
        }

        public Criteria andReportSubtimeNotEqualTo(Date value) {
            addCriterion("report_subtime <>", value, "reportSubtime");
            return (Criteria) this;
        }

        public Criteria andReportSubtimeGreaterThan(Date value) {
            addCriterion("report_subtime >", value, "reportSubtime");
            return (Criteria) this;
        }

        public Criteria andReportSubtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("report_subtime >=", value, "reportSubtime");
            return (Criteria) this;
        }

        public Criteria andReportSubtimeLessThan(Date value) {
            addCriterion("report_subtime <", value, "reportSubtime");
            return (Criteria) this;
        }

        public Criteria andReportSubtimeLessThanOrEqualTo(Date value) {
            addCriterion("report_subtime <=", value, "reportSubtime");
            return (Criteria) this;
        }

        public Criteria andReportSubtimeIn(List<Date> values) {
            addCriterion("report_subtime in", values, "reportSubtime");
            return (Criteria) this;
        }

        public Criteria andReportSubtimeNotIn(List<Date> values) {
            addCriterion("report_subtime not in", values, "reportSubtime");
            return (Criteria) this;
        }

        public Criteria andReportSubtimeBetween(Date value1, Date value2) {
            addCriterion("report_subtime between", value1, value2, "reportSubtime");
            return (Criteria) this;
        }

        public Criteria andReportSubtimeNotBetween(Date value1, Date value2) {
            addCriterion("report_subtime not between", value1, value2, "reportSubtime");
            return (Criteria) this;
        }

        public Criteria andReportVersionIsNull() {
            addCriterion("report_version is null");
            return (Criteria) this;
        }

        public Criteria andReportVersionIsNotNull() {
            addCriterion("report_version is not null");
            return (Criteria) this;
        }

        public Criteria andReportVersionEqualTo(Float value) {
            addCriterion("report_version =", value, "reportVersion");
            return (Criteria) this;
        }

        public Criteria andReportVersionNotEqualTo(Float value) {
            addCriterion("report_version <>", value, "reportVersion");
            return (Criteria) this;
        }

        public Criteria andReportVersionGreaterThan(Float value) {
            addCriterion("report_version >", value, "reportVersion");
            return (Criteria) this;
        }

        public Criteria andReportVersionGreaterThanOrEqualTo(Float value) {
            addCriterion("report_version >=", value, "reportVersion");
            return (Criteria) this;
        }

        public Criteria andReportVersionLessThan(Float value) {
            addCriterion("report_version <", value, "reportVersion");
            return (Criteria) this;
        }

        public Criteria andReportVersionLessThanOrEqualTo(Float value) {
            addCriterion("report_version <=", value, "reportVersion");
            return (Criteria) this;
        }

        public Criteria andReportVersionIn(List<Float> values) {
            addCriterion("report_version in", values, "reportVersion");
            return (Criteria) this;
        }

        public Criteria andReportVersionNotIn(List<Float> values) {
            addCriterion("report_version not in", values, "reportVersion");
            return (Criteria) this;
        }

        public Criteria andReportVersionBetween(Float value1, Float value2) {
            addCriterion("report_version between", value1, value2, "reportVersion");
            return (Criteria) this;
        }

        public Criteria andReportVersionNotBetween(Float value1, Float value2) {
            addCriterion("report_version not between", value1, value2, "reportVersion");
            return (Criteria) this;
        }

        public Criteria andReportFileIsNull() {
            addCriterion("report_file is null");
            return (Criteria) this;
        }

        public Criteria andReportFileIsNotNull() {
            addCriterion("report_file is not null");
            return (Criteria) this;
        }

        public Criteria andReportFileEqualTo(String value) {
            addCriterion("report_file =", value, "reportFile");
            return (Criteria) this;
        }

        public Criteria andReportFileNotEqualTo(String value) {
            addCriterion("report_file <>", value, "reportFile");
            return (Criteria) this;
        }

        public Criteria andReportFileGreaterThan(String value) {
            addCriterion("report_file >", value, "reportFile");
            return (Criteria) this;
        }

        public Criteria andReportFileGreaterThanOrEqualTo(String value) {
            addCriterion("report_file >=", value, "reportFile");
            return (Criteria) this;
        }

        public Criteria andReportFileLessThan(String value) {
            addCriterion("report_file <", value, "reportFile");
            return (Criteria) this;
        }

        public Criteria andReportFileLessThanOrEqualTo(String value) {
            addCriterion("report_file <=", value, "reportFile");
            return (Criteria) this;
        }

        public Criteria andReportFileLike(String value) {
            addCriterion("report_file like", value, "reportFile");
            return (Criteria) this;
        }

        public Criteria andReportFileNotLike(String value) {
            addCriterion("report_file not like", value, "reportFile");
            return (Criteria) this;
        }

        public Criteria andReportFileIn(List<String> values) {
            addCriterion("report_file in", values, "reportFile");
            return (Criteria) this;
        }

        public Criteria andReportFileNotIn(List<String> values) {
            addCriterion("report_file not in", values, "reportFile");
            return (Criteria) this;
        }

        public Criteria andReportFileBetween(String value1, String value2) {
            addCriterion("report_file between", value1, value2, "reportFile");
            return (Criteria) this;
        }

        public Criteria andReportFileNotBetween(String value1, String value2) {
            addCriterion("report_file not between", value1, value2, "reportFile");
            return (Criteria) this;
        }

        public Criteria andReportTempIsNull() {
            addCriterion("report_temp is null");
            return (Criteria) this;
        }

        public Criteria andReportTempIsNotNull() {
            addCriterion("report_temp is not null");
            return (Criteria) this;
        }

        public Criteria andReportTempEqualTo(String value) {
            addCriterion("report_temp =", value, "reportTemp");
            return (Criteria) this;
        }

        public Criteria andReportTempNotEqualTo(String value) {
            addCriterion("report_temp <>", value, "reportTemp");
            return (Criteria) this;
        }

        public Criteria andReportTempGreaterThan(String value) {
            addCriterion("report_temp >", value, "reportTemp");
            return (Criteria) this;
        }

        public Criteria andReportTempGreaterThanOrEqualTo(String value) {
            addCriterion("report_temp >=", value, "reportTemp");
            return (Criteria) this;
        }

        public Criteria andReportTempLessThan(String value) {
            addCriterion("report_temp <", value, "reportTemp");
            return (Criteria) this;
        }

        public Criteria andReportTempLessThanOrEqualTo(String value) {
            addCriterion("report_temp <=", value, "reportTemp");
            return (Criteria) this;
        }

        public Criteria andReportTempLike(String value) {
            addCriterion("report_temp like", value, "reportTemp");
            return (Criteria) this;
        }

        public Criteria andReportTempNotLike(String value) {
            addCriterion("report_temp not like", value, "reportTemp");
            return (Criteria) this;
        }

        public Criteria andReportTempIn(List<String> values) {
            addCriterion("report_temp in", values, "reportTemp");
            return (Criteria) this;
        }

        public Criteria andReportTempNotIn(List<String> values) {
            addCriterion("report_temp not in", values, "reportTemp");
            return (Criteria) this;
        }

        public Criteria andReportTempBetween(String value1, String value2) {
            addCriterion("report_temp between", value1, value2, "reportTemp");
            return (Criteria) this;
        }

        public Criteria andReportTempNotBetween(String value1, String value2) {
            addCriterion("report_temp not between", value1, value2, "reportTemp");
            return (Criteria) this;
        }

        public Criteria andReportContentIsNull() {
            addCriterion("report_content is null");
            return (Criteria) this;
        }

        public Criteria andReportContentIsNotNull() {
            addCriterion("report_content is not null");
            return (Criteria) this;
        }

        public Criteria andReportContentEqualTo(String value) {
            addCriterion("report_content =", value, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentNotEqualTo(String value) {
            addCriterion("report_content <>", value, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentGreaterThan(String value) {
            addCriterion("report_content >", value, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentGreaterThanOrEqualTo(String value) {
            addCriterion("report_content >=", value, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentLessThan(String value) {
            addCriterion("report_content <", value, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentLessThanOrEqualTo(String value) {
            addCriterion("report_content <=", value, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentLike(String value) {
            addCriterion("report_content like", value, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentNotLike(String value) {
            addCriterion("report_content not like", value, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentIn(List<String> values) {
            addCriterion("report_content in", values, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentNotIn(List<String> values) {
            addCriterion("report_content not in", values, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentBetween(String value1, String value2) {
            addCriterion("report_content between", value1, value2, "reportContent");
            return (Criteria) this;
        }

        public Criteria andReportContentNotBetween(String value1, String value2) {
            addCriterion("report_content not between", value1, value2, "reportContent");
            return (Criteria) this;
        }


        public Criteria andTeaSuggestionIsNull() {
            addCriterion("tea_suggestion is null");
            return (Criteria) this;
        }

        public Criteria andTeaSuggestionIsNotNull() {
            addCriterion("tea_suggestion is not null");
            return (Criteria) this;
        }

        public Criteria andTeaSuggestionEqualTo(String value) {
            addCriterion("tea_suggestion =", value, "teaSuggestion");
            return (Criteria) this;
        }

        public Criteria andTeaSuggestionNotEqualTo(String value) {
            addCriterion("tea_suggestion <>", value, "teaSuggestion");
            return (Criteria) this;
        }

        public Criteria andTeaSuggestionGreaterThan(String value) {
            addCriterion("tea_suggestion >", value, "teaSuggestion");
            return (Criteria) this;
        }

        public Criteria andTeaSuggestionGreaterThanOrEqualTo(String value) {
            addCriterion("tea_suggestion >=", value, "teaSuggestion");
            return (Criteria) this;
        }

        public Criteria andTeaSuggestionLessThan(String value) {
            addCriterion("tea_suggestion <", value, "teaSuggestion");
            return (Criteria) this;
        }

        public Criteria andTeaSuggestionLessThanOrEqualTo(String value) {
            addCriterion("tea_suggestion <=", value, "teaSuggestion");
            return (Criteria) this;
        }

        public Criteria andTeaSuggestionLike(String value) {
            addCriterion("tea_suggestion like", value, "teaSuggestion");
            return (Criteria) this;
        }

        public Criteria andTeaSuggestionNotLike(String value) {
            addCriterion("tea_suggestion not like", value, "teaSuggestion");
            return (Criteria) this;
        }

        public Criteria andTeaSuggestionIn(List<String> values) {
            addCriterion("tea_suggestion in", values, "teaSuggestion");
            return (Criteria) this;
        }

        public Criteria andTeaSuggestionNotIn(List<String> values) {
            addCriterion("tea_suggestion not in", values, "teaSuggestion");
            return (Criteria) this;
        }

        public Criteria andTeaSuggestionBetween(String value1, String value2) {
            addCriterion("tea_suggestion between", value1, value2, "teaSuggestion");
            return (Criteria) this;
        }

        public Criteria andTeaSuggestionNotBetween(String value1, String value2) {
            addCriterion("tea_suggestion not between", value1, value2, "teaSuggestion");
            return (Criteria) this;
        }

        public Criteria andStuMessageIsNull() {
            addCriterion("stu_message is null");
            return (Criteria) this;
        }

        public Criteria andStuMessageIsNotNull() {
            addCriterion("stu_message is not null");
            return (Criteria) this;
        }

        public Criteria andStuMessageEqualTo(String value) {
            addCriterion("stu_message =", value, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageNotEqualTo(String value) {
            addCriterion("stu_message <>", value, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageGreaterThan(String value) {
            addCriterion("stu_message >", value, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageGreaterThanOrEqualTo(String value) {
            addCriterion("stu_message >=", value, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageLessThan(String value) {
            addCriterion("stu_message <", value, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageLessThanOrEqualTo(String value) {
            addCriterion("stu_message <=", value, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageLike(String value) {
            addCriterion("stu_message like", value, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageNotLike(String value) {
            addCriterion("stu_message not like", value, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageIn(List<String> values) {
            addCriterion("stu_message in", values, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageNotIn(List<String> values) {
            addCriterion("stu_message not in", values, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageBetween(String value1, String value2) {
            addCriterion("stu_message between", value1, value2, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andStuMessageNotBetween(String value1, String value2) {
            addCriterion("stu_message not between", value1, value2, "stuMessage");
            return (Criteria) this;
        }

        public Criteria andJoinStuIdEqualTo(String value) {
            addCriterion("t_subject.stu_id = ", value, "t_subject.stu_id");
            return (Criteria) this;
        }

        public Criteria andJoinTeaIdEqualTo(String value) {
            addCriterion("t_subject.sub_tea_id = ", value, "t_subject.sub_tea_id");
            return (Criteria) this;
        }

        public Criteria andJoinStuIdNotEqualTo(String value) {
            addCriterion("t_subject.stu_id != ", value, "t_subject.stu_id");
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
     * 数据库表：t_report
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * Criterion
     * 数据库表：t_report
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