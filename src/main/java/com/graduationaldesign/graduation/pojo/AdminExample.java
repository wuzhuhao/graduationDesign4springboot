package com.graduationaldesign.graduation.pojo;

import java.util.ArrayList;
import java.util.List;

public class AdminExample implements Example {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_admin
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_admin
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_admin
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * 构造查询条件,t_admin
     */
    public AdminExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 设置排序字段,t_admin
     *
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * 获取排序字段,t_admin
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * 设置过滤重复数据,t_admin
     *
     * @param distinct 是否过滤重复数据
     */
    @Override
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * 是否过滤重复数据,t_admin
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * 获取当前的查询条件实例,t_admin
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * ,t_admin
     *
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * ,t_admin
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 创建一个查询条件,t_admin
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
     * 内部构建查询条件对象,t_admin
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 清除查询条件,t_admin
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * InnoDB free: 11264 kB
     * GeneratedCriteria
     * 数据库表：t_admin
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

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(String value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(String value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(String value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(String value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(String value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(String value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLike(String value) {
            addCriterion("admin_id like", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotLike(String value) {
            addCriterion("admin_id not like", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<String> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<String> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(String value1, String value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(String value1, String value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordIsNull() {
            addCriterion("admin_password is null");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordIsNotNull() {
            addCriterion("admin_password is not null");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordEqualTo(String value) {
            addCriterion("admin_password =", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordNotEqualTo(String value) {
            addCriterion("admin_password <>", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordGreaterThan(String value) {
            addCriterion("admin_password >", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("admin_password >=", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordLessThan(String value) {
            addCriterion("admin_password <", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordLessThanOrEqualTo(String value) {
            addCriterion("admin_password <=", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordLike(String value) {
            addCriterion("admin_password like", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordNotLike(String value) {
            addCriterion("admin_password not like", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordIn(List<String> values) {
            addCriterion("admin_password in", values, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordNotIn(List<String> values) {
            addCriterion("admin_password not in", values, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordBetween(String value1, String value2) {
            addCriterion("admin_password between", value1, value2, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordNotBetween(String value1, String value2) {
            addCriterion("admin_password not between", value1, value2, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminNameIsNull() {
            addCriterion("admin_name is null");
            return (Criteria) this;
        }

        public Criteria andAdminNameIsNotNull() {
            addCriterion("admin_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdminNameEqualTo(String value) {
            addCriterion("admin_name =", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotEqualTo(String value) {
            addCriterion("admin_name <>", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameGreaterThan(String value) {
            addCriterion("admin_name >", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameGreaterThanOrEqualTo(String value) {
            addCriterion("admin_name >=", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLessThan(String value) {
            addCriterion("admin_name <", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLessThanOrEqualTo(String value) {
            addCriterion("admin_name <=", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLike(String value) {
            addCriterion("admin_name like", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotLike(String value) {
            addCriterion("admin_name not like", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameIn(List<String> values) {
            addCriterion("admin_name in", values, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotIn(List<String> values) {
            addCriterion("admin_name not in", values, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameBetween(String value1, String value2) {
            addCriterion("admin_name between", value1, value2, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotBetween(String value1, String value2) {
            addCriterion("admin_name not between", value1, value2, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminSexIsNull() {
            addCriterion("admin_sex is null");
            return (Criteria) this;
        }

        public Criteria andAdminSexIsNotNull() {
            addCriterion("admin_sex is not null");
            return (Criteria) this;
        }

        public Criteria andAdminSexEqualTo(String value) {
            addCriterion("admin_sex =", value, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexNotEqualTo(String value) {
            addCriterion("admin_sex <>", value, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexGreaterThan(String value) {
            addCriterion("admin_sex >", value, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexGreaterThanOrEqualTo(String value) {
            addCriterion("admin_sex >=", value, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexLessThan(String value) {
            addCriterion("admin_sex <", value, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexLessThanOrEqualTo(String value) {
            addCriterion("admin_sex <=", value, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexLike(String value) {
            addCriterion("admin_sex like", value, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexNotLike(String value) {
            addCriterion("admin_sex not like", value, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexIn(List<String> values) {
            addCriterion("admin_sex in", values, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexNotIn(List<String> values) {
            addCriterion("admin_sex not in", values, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexBetween(String value1, String value2) {
            addCriterion("admin_sex between", value1, value2, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminSexNotBetween(String value1, String value2) {
            addCriterion("admin_sex not between", value1, value2, "adminSex");
            return (Criteria) this;
        }

        public Criteria andAdminAgeIsNull() {
            addCriterion("admin_age is null");
            return (Criteria) this;
        }

        public Criteria andAdminAgeIsNotNull() {
            addCriterion("admin_age is not null");
            return (Criteria) this;
        }

        public Criteria andAdminAgeEqualTo(Integer value) {
            addCriterion("admin_age =", value, "adminAge");
            return (Criteria) this;
        }

        public Criteria andAdminAgeNotEqualTo(Integer value) {
            addCriterion("admin_age <>", value, "adminAge");
            return (Criteria) this;
        }

        public Criteria andAdminAgeGreaterThan(Integer value) {
            addCriterion("admin_age >", value, "adminAge");
            return (Criteria) this;
        }

        public Criteria andAdminAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_age >=", value, "adminAge");
            return (Criteria) this;
        }

        public Criteria andAdminAgeLessThan(Integer value) {
            addCriterion("admin_age <", value, "adminAge");
            return (Criteria) this;
        }

        public Criteria andAdminAgeLessThanOrEqualTo(Integer value) {
            addCriterion("admin_age <=", value, "adminAge");
            return (Criteria) this;
        }

        public Criteria andAdminAgeIn(List<Integer> values) {
            addCriterion("admin_age in", values, "adminAge");
            return (Criteria) this;
        }

        public Criteria andAdminAgeNotIn(List<Integer> values) {
            addCriterion("admin_age not in", values, "adminAge");
            return (Criteria) this;
        }

        public Criteria andAdminAgeBetween(Integer value1, Integer value2) {
            addCriterion("admin_age between", value1, value2, "adminAge");
            return (Criteria) this;
        }

        public Criteria andAdminAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_age not between", value1, value2, "adminAge");
            return (Criteria) this;
        }

        public Criteria andAdminBirthdayIsNull() {
            addCriterion("admin_birthday is null");
            return (Criteria) this;
        }

        public Criteria andAdminBirthdayIsNotNull() {
            addCriterion("admin_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andAdminBirthdayEqualTo(String value) {
            addCriterion("admin_birthday =", value, "adminBirthday");
            return (Criteria) this;
        }

        public Criteria andAdminBirthdayNotEqualTo(String value) {
            addCriterion("admin_birthday <>", value, "adminBirthday");
            return (Criteria) this;
        }

        public Criteria andAdminBirthdayGreaterThan(String value) {
            addCriterion("admin_birthday >", value, "adminBirthday");
            return (Criteria) this;
        }

        public Criteria andAdminBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("admin_birthday >=", value, "adminBirthday");
            return (Criteria) this;
        }

        public Criteria andAdminBirthdayLessThan(String value) {
            addCriterion("admin_birthday <", value, "adminBirthday");
            return (Criteria) this;
        }

        public Criteria andAdminBirthdayLessThanOrEqualTo(String value) {
            addCriterion("admin_birthday <=", value, "adminBirthday");
            return (Criteria) this;
        }

        public Criteria andAdminBirthdayLike(String value) {
            addCriterion("admin_birthday like", value, "adminBirthday");
            return (Criteria) this;
        }

        public Criteria andAdminBirthdayNotLike(String value) {
            addCriterion("admin_birthday not like", value, "adminBirthday");
            return (Criteria) this;
        }

        public Criteria andAdminBirthdayIn(List<String> values) {
            addCriterion("admin_birthday in", values, "adminBirthday");
            return (Criteria) this;
        }

        public Criteria andAdminBirthdayNotIn(List<String> values) {
            addCriterion("admin_birthday not in", values, "adminBirthday");
            return (Criteria) this;
        }

        public Criteria andAdminBirthdayBetween(String value1, String value2) {
            addCriterion("admin_birthday between", value1, value2, "adminBirthday");
            return (Criteria) this;
        }

        public Criteria andAdminBirthdayNotBetween(String value1, String value2) {
            addCriterion("admin_birthday not between", value1, value2, "adminBirthday");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneIsNull() {
            addCriterion("admin_phone is null");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneIsNotNull() {
            addCriterion("admin_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneEqualTo(String value) {
            addCriterion("admin_phone =", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneNotEqualTo(String value) {
            addCriterion("admin_phone <>", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneGreaterThan(String value) {
            addCriterion("admin_phone >", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("admin_phone >=", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneLessThan(String value) {
            addCriterion("admin_phone <", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneLessThanOrEqualTo(String value) {
            addCriterion("admin_phone <=", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneLike(String value) {
            addCriterion("admin_phone like", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneNotLike(String value) {
            addCriterion("admin_phone not like", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneIn(List<String> values) {
            addCriterion("admin_phone in", values, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneNotIn(List<String> values) {
            addCriterion("admin_phone not in", values, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneBetween(String value1, String value2) {
            addCriterion("admin_phone between", value1, value2, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneNotBetween(String value1, String value2) {
            addCriterion("admin_phone not between", value1, value2, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminMailIsNull() {
            addCriterion("admin_mail is null");
            return (Criteria) this;
        }

        public Criteria andAdminMailIsNotNull() {
            addCriterion("admin_mail is not null");
            return (Criteria) this;
        }

        public Criteria andAdminMailEqualTo(String value) {
            addCriterion("admin_mail =", value, "adminMail");
            return (Criteria) this;
        }

        public Criteria andAdminMailNotEqualTo(String value) {
            addCriterion("admin_mail <>", value, "adminMail");
            return (Criteria) this;
        }

        public Criteria andAdminMailGreaterThan(String value) {
            addCriterion("admin_mail >", value, "adminMail");
            return (Criteria) this;
        }

        public Criteria andAdminMailGreaterThanOrEqualTo(String value) {
            addCriterion("admin_mail >=", value, "adminMail");
            return (Criteria) this;
        }

        public Criteria andAdminMailLessThan(String value) {
            addCriterion("admin_mail <", value, "adminMail");
            return (Criteria) this;
        }

        public Criteria andAdminMailLessThanOrEqualTo(String value) {
            addCriterion("admin_mail <=", value, "adminMail");
            return (Criteria) this;
        }

        public Criteria andAdminMailLike(String value) {
            addCriterion("admin_mail like", value, "adminMail");
            return (Criteria) this;
        }

        public Criteria andAdminMailNotLike(String value) {
            addCriterion("admin_mail not like", value, "adminMail");
            return (Criteria) this;
        }

        public Criteria andAdminMailIn(List<String> values) {
            addCriterion("admin_mail in", values, "adminMail");
            return (Criteria) this;
        }

        public Criteria andAdminMailNotIn(List<String> values) {
            addCriterion("admin_mail not in", values, "adminMail");
            return (Criteria) this;
        }

        public Criteria andAdminMailBetween(String value1, String value2) {
            addCriterion("admin_mail between", value1, value2, "adminMail");
            return (Criteria) this;
        }

        public Criteria andAdminMailNotBetween(String value1, String value2) {
            addCriterion("admin_mail not between", value1, value2, "adminMail");
            return (Criteria) this;
        }

        public Criteria andAdminAddressIsNull() {
            addCriterion("admin_address is null");
            return (Criteria) this;
        }

        public Criteria andAdminAddressIsNotNull() {
            addCriterion("admin_address is not null");
            return (Criteria) this;
        }

        public Criteria andAdminAddressEqualTo(String value) {
            addCriterion("admin_address =", value, "adminAddress");
            return (Criteria) this;
        }

        public Criteria andAdminAddressNotEqualTo(String value) {
            addCriterion("admin_address <>", value, "adminAddress");
            return (Criteria) this;
        }

        public Criteria andAdminAddressGreaterThan(String value) {
            addCriterion("admin_address >", value, "adminAddress");
            return (Criteria) this;
        }

        public Criteria andAdminAddressGreaterThanOrEqualTo(String value) {
            addCriterion("admin_address >=", value, "adminAddress");
            return (Criteria) this;
        }

        public Criteria andAdminAddressLessThan(String value) {
            addCriterion("admin_address <", value, "adminAddress");
            return (Criteria) this;
        }

        public Criteria andAdminAddressLessThanOrEqualTo(String value) {
            addCriterion("admin_address <=", value, "adminAddress");
            return (Criteria) this;
        }

        public Criteria andAdminAddressLike(String value) {
            addCriterion("admin_address like", value, "adminAddress");
            return (Criteria) this;
        }

        public Criteria andAdminAddressNotLike(String value) {
            addCriterion("admin_address not like", value, "adminAddress");
            return (Criteria) this;
        }

        public Criteria andAdminAddressIn(List<String> values) {
            addCriterion("admin_address in", values, "adminAddress");
            return (Criteria) this;
        }

        public Criteria andAdminAddressNotIn(List<String> values) {
            addCriterion("admin_address not in", values, "adminAddress");
            return (Criteria) this;
        }

        public Criteria andAdminAddressBetween(String value1, String value2) {
            addCriterion("admin_address between", value1, value2, "adminAddress");
            return (Criteria) this;
        }

        public Criteria andAdminAddressNotBetween(String value1, String value2) {
            addCriterion("admin_address not between", value1, value2, "adminAddress");
            return (Criteria) this;
        }

        public Criteria andAdminRemarksIsNull() {
            addCriterion("admin_remarks is null");
            return (Criteria) this;
        }

        public Criteria andAdminRemarksIsNotNull() {
            addCriterion("admin_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andAdminRemarksEqualTo(String value) {
            addCriterion("admin_remarks =", value, "adminRemarks");
            return (Criteria) this;
        }

        public Criteria andAdminRemarksNotEqualTo(String value) {
            addCriterion("admin_remarks <>", value, "adminRemarks");
            return (Criteria) this;
        }

        public Criteria andAdminRemarksGreaterThan(String value) {
            addCriterion("admin_remarks >", value, "adminRemarks");
            return (Criteria) this;
        }

        public Criteria andAdminRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("admin_remarks >=", value, "adminRemarks");
            return (Criteria) this;
        }

        public Criteria andAdminRemarksLessThan(String value) {
            addCriterion("admin_remarks <", value, "adminRemarks");
            return (Criteria) this;
        }

        public Criteria andAdminRemarksLessThanOrEqualTo(String value) {
            addCriterion("admin_remarks <=", value, "adminRemarks");
            return (Criteria) this;
        }

        public Criteria andAdminRemarksLike(String value) {
            addCriterion("admin_remarks like", value, "adminRemarks");
            return (Criteria) this;
        }

        public Criteria andAdminRemarksNotLike(String value) {
            addCriterion("admin_remarks not like", value, "adminRemarks");
            return (Criteria) this;
        }

        public Criteria andAdminRemarksIn(List<String> values) {
            addCriterion("admin_remarks in", values, "adminRemarks");
            return (Criteria) this;
        }

        public Criteria andAdminRemarksNotIn(List<String> values) {
            addCriterion("admin_remarks not in", values, "adminRemarks");
            return (Criteria) this;
        }

        public Criteria andAdminRemarksBetween(String value1, String value2) {
            addCriterion("admin_remarks between", value1, value2, "adminRemarks");
            return (Criteria) this;
        }

        public Criteria andAdminRemarksNotBetween(String value1, String value2) {
            addCriterion("admin_remarks not between", value1, value2, "adminRemarks");
            return (Criteria) this;
        }

        public Criteria andAdminTypeIsNull() {
            addCriterion("admin_type is null");
            return (Criteria) this;
        }

        public Criteria andAdminTypeIsNotNull() {
            addCriterion("admin_type is not null");
            return (Criteria) this;
        }

        public Criteria andAdminTypeEqualTo(Integer value) {
            addCriterion("admin_type =", value, "adminType");
            return (Criteria) this;
        }

        public Criteria andAdminTypeNotEqualTo(Integer value) {
            addCriterion("admin_type <>", value, "adminType");
            return (Criteria) this;
        }

        public Criteria andAdminTypeGreaterThan(Integer value) {
            addCriterion("admin_type >", value, "adminType");
            return (Criteria) this;
        }

        public Criteria andAdminTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_type >=", value, "adminType");
            return (Criteria) this;
        }

        public Criteria andAdminTypeLessThan(Integer value) {
            addCriterion("admin_type <", value, "adminType");
            return (Criteria) this;
        }

        public Criteria andAdminTypeLessThanOrEqualTo(Integer value) {
            addCriterion("admin_type <=", value, "adminType");
            return (Criteria) this;
        }

        public Criteria andAdminTypeIn(List<Integer> values) {
            addCriterion("admin_type in", values, "adminType");
            return (Criteria) this;
        }

        public Criteria andAdminTypeNotIn(List<Integer> values) {
            addCriterion("admin_type not in", values, "adminType");
            return (Criteria) this;
        }

        public Criteria andAdminTypeBetween(Integer value1, Integer value2) {
            addCriterion("admin_type between", value1, value2, "adminType");
            return (Criteria) this;
        }

        public Criteria andAdminTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_type not between", value1, value2, "adminType");
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
     * 数据库表：t_admin
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * InnoDB free: 11264 kB
     * Criterion
     * 数据库表：t_admin
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