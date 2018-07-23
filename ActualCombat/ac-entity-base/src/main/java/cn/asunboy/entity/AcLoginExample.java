package cn.asunboy.entity;

import java.util.ArrayList;
import java.util.List;

public class AcLoginExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AcLoginExample() {
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

        public Criteria andLoginTypeIdIsNull() {
            addCriterion("login_type_id is null");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdIsNotNull() {
            addCriterion("login_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdEqualTo(Byte value) {
            addCriterion("login_type_id =", value, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdNotEqualTo(Byte value) {
            addCriterion("login_type_id <>", value, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdGreaterThan(Byte value) {
            addCriterion("login_type_id >", value, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("login_type_id >=", value, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdLessThan(Byte value) {
            addCriterion("login_type_id <", value, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdLessThanOrEqualTo(Byte value) {
            addCriterion("login_type_id <=", value, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdIn(List<Byte> values) {
            addCriterion("login_type_id in", values, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdNotIn(List<Byte> values) {
            addCriterion("login_type_id not in", values, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdBetween(Byte value1, Byte value2) {
            addCriterion("login_type_id between", value1, value2, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginTypeIdNotBetween(Byte value1, Byte value2) {
            addCriterion("login_type_id not between", value1, value2, "loginTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginTargetIdIsNull() {
            addCriterion("login_target_id is null");
            return (Criteria) this;
        }

        public Criteria andLoginTargetIdIsNotNull() {
            addCriterion("login_target_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTargetIdEqualTo(Long value) {
            addCriterion("login_target_id =", value, "loginTargetId");
            return (Criteria) this;
        }

        public Criteria andLoginTargetIdNotEqualTo(Long value) {
            addCriterion("login_target_id <>", value, "loginTargetId");
            return (Criteria) this;
        }

        public Criteria andLoginTargetIdGreaterThan(Long value) {
            addCriterion("login_target_id >", value, "loginTargetId");
            return (Criteria) this;
        }

        public Criteria andLoginTargetIdGreaterThanOrEqualTo(Long value) {
            addCriterion("login_target_id >=", value, "loginTargetId");
            return (Criteria) this;
        }

        public Criteria andLoginTargetIdLessThan(Long value) {
            addCriterion("login_target_id <", value, "loginTargetId");
            return (Criteria) this;
        }

        public Criteria andLoginTargetIdLessThanOrEqualTo(Long value) {
            addCriterion("login_target_id <=", value, "loginTargetId");
            return (Criteria) this;
        }

        public Criteria andLoginTargetIdIn(List<Long> values) {
            addCriterion("login_target_id in", values, "loginTargetId");
            return (Criteria) this;
        }

        public Criteria andLoginTargetIdNotIn(List<Long> values) {
            addCriterion("login_target_id not in", values, "loginTargetId");
            return (Criteria) this;
        }

        public Criteria andLoginTargetIdBetween(Long value1, Long value2) {
            addCriterion("login_target_id between", value1, value2, "loginTargetId");
            return (Criteria) this;
        }

        public Criteria andLoginTargetIdNotBetween(Long value1, Long value2) {
            addCriterion("login_target_id not between", value1, value2, "loginTargetId");
            return (Criteria) this;
        }

        public Criteria andLoginNameIsNull() {
            addCriterion("login_name is null");
            return (Criteria) this;
        }

        public Criteria andLoginNameIsNotNull() {
            addCriterion("login_name is not null");
            return (Criteria) this;
        }

        public Criteria andLoginNameEqualTo(String value) {
            addCriterion("login_name =", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotEqualTo(String value) {
            addCriterion("login_name <>", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThan(String value) {
            addCriterion("login_name >", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("login_name >=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThan(String value) {
            addCriterion("login_name <", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThanOrEqualTo(String value) {
            addCriterion("login_name <=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLike(String value) {
            addCriterion("login_name like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotLike(String value) {
            addCriterion("login_name not like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameIn(List<String> values) {
            addCriterion("login_name in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotIn(List<String> values) {
            addCriterion("login_name not in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameBetween(String value1, String value2) {
            addCriterion("login_name between", value1, value2, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotBetween(String value1, String value2) {
            addCriterion("login_name not between", value1, value2, "loginName");
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