package cn.asunboy.entity;

import java.util.Date;

public class AcAppModule {
    private Integer id;

    private String moduleKey;

    private String name;

    private String description;

    private Date createOn;

    private Long createBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModuleKey() {
        return moduleKey;
    }

    public void setModuleKey(String moduleKey) {
        this.moduleKey = moduleKey == null ? null : moduleKey.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }
}