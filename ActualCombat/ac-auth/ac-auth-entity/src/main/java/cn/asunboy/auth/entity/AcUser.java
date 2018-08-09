package cn.asunboy.auth.entity;

import cn.asunboy.lang.VersionSupport;

import java.util.Date;

public class AcUser implements VersionSupport {
    private Long id;

    private String nickname;

    private String name;

    private Byte age;

    private Boolean sex;

    private String mobile;

    private Byte typeId;

    private String loginPwd;

    private Byte pwdFailTimes;

    private String status;

    private Date lockedOn;

    private Date lastLoginOn;

    private Date createdOn;

    private Date modifiedOn;

    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Byte getTypeId() {
        return typeId;
    }

    public void setTypeId(Byte typeId) {
        this.typeId = typeId;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    public Byte getPwdFailTimes() {
        return pwdFailTimes;
    }

    public void setPwdFailTimes(Byte pwdFailTimes) {
        this.pwdFailTimes = pwdFailTimes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getLockedOn() {
        return lockedOn;
    }

    public void setLockedOn(Date lockedOn) {
        this.lockedOn = lockedOn;
    }

    public Date getLastLoginOn() {
        return lastLoginOn;
    }

    public void setLastLoginOn(Date lastLoginOn) {
        this.lastLoginOn = lastLoginOn;
    }

    @Override
    public Date getCreatedOn() {
        return createdOn;
    }

    @Override
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public Long getCreatedBy() {
        return null;
    }

    @Override
    public void setCreatedBy(Long createdBy) {

    }

    @Override
    public Long getModifiedBy() {
        return null;
    }

    @Override
    public void setModifiedBy(Long modifiedBy) {

    }

    @Override
    public Date getModifiedOn() {
        return modifiedOn;
    }

    @Override
    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }
}