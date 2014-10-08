package com.glacier.frame.entity.member;

import java.util.ArrayList;
import java.util.List;

public class ShipperMemberTokenExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public ShipperMemberTokenExample() {
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

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    public int getLimitEnd() {
        return limitEnd;
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

        public Criteria andMemberIdIsNull() {
            addCriterion("temp_shipper_member_token.member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("temp_shipper_member_token.member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(String value) {
            addCriterion("temp_shipper_member_token.member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(String value) {
            addCriterion("temp_shipper_member_token.member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(String value) {
            addCriterion("temp_shipper_member_token.member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(String value) {
            addCriterion("temp_shipper_member_token.member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(String value) {
            addCriterion("temp_shipper_member_token.member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(String value) {
            addCriterion("temp_shipper_member_token.member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLike(String value) {
            addCriterion("temp_shipper_member_token.member_id like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotLike(String value) {
            addCriterion("temp_shipper_member_token.member_id not like", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<String> values) {
            addCriterion("temp_shipper_member_token.member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<String> values) {
            addCriterion("temp_shipper_member_token.member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(String value1, String value2) {
            addCriterion("temp_shipper_member_token.member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(String value1, String value2) {
            addCriterion("temp_shipper_member_token.member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNull() {
            addCriterion("temp_shipper_member_token.member_name is null");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNotNull() {
            addCriterion("temp_shipper_member_token.member_name is not null");
            return (Criteria) this;
        }

        public Criteria andMemberNameEqualTo(String value) {
            addCriterion("temp_shipper_member_token.member_name =", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotEqualTo(String value) {
            addCriterion("temp_shipper_member_token.member_name <>", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThan(String value) {
            addCriterion("temp_shipper_member_token.member_name >", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThanOrEqualTo(String value) {
            addCriterion("temp_shipper_member_token.member_name >=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThan(String value) {
            addCriterion("temp_shipper_member_token.member_name <", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThanOrEqualTo(String value) {
            addCriterion("temp_shipper_member_token.member_name <=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLike(String value) {
            addCriterion("temp_shipper_member_token.member_name like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotLike(String value) {
            addCriterion("temp_shipper_member_token.member_name not like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameIn(List<String> values) {
            addCriterion("temp_shipper_member_token.member_name in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotIn(List<String> values) {
            addCriterion("temp_shipper_member_token.member_name not in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameBetween(String value1, String value2) {
            addCriterion("temp_shipper_member_token.member_name between", value1, value2, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotBetween(String value1, String value2) {
            addCriterion("temp_shipper_member_token.member_name not between", value1, value2, "memberName");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("temp_shipper_member_token.password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("temp_shipper_member_token.password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("temp_shipper_member_token.password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("temp_shipper_member_token.password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("temp_shipper_member_token.password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("temp_shipper_member_token.password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("temp_shipper_member_token.password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("temp_shipper_member_token.password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("temp_shipper_member_token.password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("temp_shipper_member_token.password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("temp_shipper_member_token.password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("temp_shipper_member_token.password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("temp_shipper_member_token.password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("temp_shipper_member_token.password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andStaltIsNull() {
            addCriterion("temp_shipper_member_token.stalt is null");
            return (Criteria) this;
        }

        public Criteria andStaltIsNotNull() {
            addCriterion("temp_shipper_member_token.stalt is not null");
            return (Criteria) this;
        }

        public Criteria andStaltEqualTo(String value) {
            addCriterion("temp_shipper_member_token.stalt =", value, "stalt");
            return (Criteria) this;
        }

        public Criteria andStaltNotEqualTo(String value) {
            addCriterion("temp_shipper_member_token.stalt <>", value, "stalt");
            return (Criteria) this;
        }

        public Criteria andStaltGreaterThan(String value) {
            addCriterion("temp_shipper_member_token.stalt >", value, "stalt");
            return (Criteria) this;
        }

        public Criteria andStaltGreaterThanOrEqualTo(String value) {
            addCriterion("temp_shipper_member_token.stalt >=", value, "stalt");
            return (Criteria) this;
        }

        public Criteria andStaltLessThan(String value) {
            addCriterion("temp_shipper_member_token.stalt <", value, "stalt");
            return (Criteria) this;
        }

        public Criteria andStaltLessThanOrEqualTo(String value) {
            addCriterion("temp_shipper_member_token.stalt <=", value, "stalt");
            return (Criteria) this;
        }

        public Criteria andStaltLike(String value) {
            addCriterion("temp_shipper_member_token.stalt like", value, "stalt");
            return (Criteria) this;
        }

        public Criteria andStaltNotLike(String value) {
            addCriterion("temp_shipper_member_token.stalt not like", value, "stalt");
            return (Criteria) this;
        }

        public Criteria andStaltIn(List<String> values) {
            addCriterion("temp_shipper_member_token.stalt in", values, "stalt");
            return (Criteria) this;
        }

        public Criteria andStaltNotIn(List<String> values) {
            addCriterion("temp_shipper_member_token.stalt not in", values, "stalt");
            return (Criteria) this;
        }

        public Criteria andStaltBetween(String value1, String value2) {
            addCriterion("temp_shipper_member_token.stalt between", value1, value2, "stalt");
            return (Criteria) this;
        }

        public Criteria andStaltNotBetween(String value1, String value2) {
            addCriterion("temp_shipper_member_token.stalt not between", value1, value2, "stalt");
            return (Criteria) this;
        }

        public Criteria andTratersPasswordIsNull() {
            addCriterion("temp_shipper_member_token.traters_password is null");
            return (Criteria) this;
        }

        public Criteria andTratersPasswordIsNotNull() {
            addCriterion("temp_shipper_member_token.traters_password is not null");
            return (Criteria) this;
        }

        public Criteria andTratersPasswordEqualTo(String value) {
            addCriterion("temp_shipper_member_token.traters_password =", value, "tratersPassword");
            return (Criteria) this;
        }

        public Criteria andTratersPasswordNotEqualTo(String value) {
            addCriterion("temp_shipper_member_token.traters_password <>", value, "tratersPassword");
            return (Criteria) this;
        }

        public Criteria andTratersPasswordGreaterThan(String value) {
            addCriterion("temp_shipper_member_token.traters_password >", value, "tratersPassword");
            return (Criteria) this;
        }

        public Criteria andTratersPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("temp_shipper_member_token.traters_password >=", value, "tratersPassword");
            return (Criteria) this;
        }

        public Criteria andTratersPasswordLessThan(String value) {
            addCriterion("temp_shipper_member_token.traters_password <", value, "tratersPassword");
            return (Criteria) this;
        }

        public Criteria andTratersPasswordLessThanOrEqualTo(String value) {
            addCriterion("temp_shipper_member_token.traters_password <=", value, "tratersPassword");
            return (Criteria) this;
        }

        public Criteria andTratersPasswordLike(String value) {
            addCriterion("temp_shipper_member_token.traters_password like", value, "tratersPassword");
            return (Criteria) this;
        }

        public Criteria andTratersPasswordNotLike(String value) {
            addCriterion("temp_shipper_member_token.traters_password not like", value, "tratersPassword");
            return (Criteria) this;
        }

        public Criteria andTratersPasswordIn(List<String> values) {
            addCriterion("temp_shipper_member_token.traters_password in", values, "tratersPassword");
            return (Criteria) this;
        }

        public Criteria andTratersPasswordNotIn(List<String> values) {
            addCriterion("temp_shipper_member_token.traters_password not in", values, "tratersPassword");
            return (Criteria) this;
        }

        public Criteria andTratersPasswordBetween(String value1, String value2) {
            addCriterion("temp_shipper_member_token.traters_password between", value1, value2, "tratersPassword");
            return (Criteria) this;
        }

        public Criteria andTratersPasswordNotBetween(String value1, String value2) {
            addCriterion("temp_shipper_member_token.traters_password not between", value1, value2, "tratersPassword");
            return (Criteria) this;
        }

        public Criteria andTratersStaltIsNull() {
            addCriterion("temp_shipper_member_token.traters_stalt is null");
            return (Criteria) this;
        }

        public Criteria andTratersStaltIsNotNull() {
            addCriterion("temp_shipper_member_token.traters_stalt is not null");
            return (Criteria) this;
        }

        public Criteria andTratersStaltEqualTo(String value) {
            addCriterion("temp_shipper_member_token.traters_stalt =", value, "tratersStalt");
            return (Criteria) this;
        }

        public Criteria andTratersStaltNotEqualTo(String value) {
            addCriterion("temp_shipper_member_token.traters_stalt <>", value, "tratersStalt");
            return (Criteria) this;
        }

        public Criteria andTratersStaltGreaterThan(String value) {
            addCriterion("temp_shipper_member_token.traters_stalt >", value, "tratersStalt");
            return (Criteria) this;
        }

        public Criteria andTratersStaltGreaterThanOrEqualTo(String value) {
            addCriterion("temp_shipper_member_token.traters_stalt >=", value, "tratersStalt");
            return (Criteria) this;
        }

        public Criteria andTratersStaltLessThan(String value) {
            addCriterion("temp_shipper_member_token.traters_stalt <", value, "tratersStalt");
            return (Criteria) this;
        }

        public Criteria andTratersStaltLessThanOrEqualTo(String value) {
            addCriterion("temp_shipper_member_token.traters_stalt <=", value, "tratersStalt");
            return (Criteria) this;
        }

        public Criteria andTratersStaltLike(String value) {
            addCriterion("temp_shipper_member_token.traters_stalt like", value, "tratersStalt");
            return (Criteria) this;
        }

        public Criteria andTratersStaltNotLike(String value) {
            addCriterion("temp_shipper_member_token.traters_stalt not like", value, "tratersStalt");
            return (Criteria) this;
        }

        public Criteria andTratersStaltIn(List<String> values) {
            addCriterion("temp_shipper_member_token.traters_stalt in", values, "tratersStalt");
            return (Criteria) this;
        }

        public Criteria andTratersStaltNotIn(List<String> values) {
            addCriterion("temp_shipper_member_token.traters_stalt not in", values, "tratersStalt");
            return (Criteria) this;
        }

        public Criteria andTratersStaltBetween(String value1, String value2) {
            addCriterion("temp_shipper_member_token.traters_stalt between", value1, value2, "tratersStalt");
            return (Criteria) this;
        }

        public Criteria andTratersStaltNotBetween(String value1, String value2) {
            addCriterion("temp_shipper_member_token.traters_stalt not between", value1, value2, "tratersStalt");
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