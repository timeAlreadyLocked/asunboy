package asunboy.service.lock.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@ApiModel(value="")
public class App {
    @ApiModelProperty(value="idAPP ID（数值）")
    private Integer id;

    @ApiModelProperty(value="platform应用平台。sowtrd：瑞软；weixin：微信")
    private String platform;

    @ApiModelProperty(value="appKey所在平台的应用唯一标识")
    private String appKey;

    @ApiModelProperty(value="name应用名称")
    private String name;

    @ApiModelProperty(value="description应用介绍")
    private String description;

    @ApiModelProperty(value="createdOn创建时间")
    private Date createdOn;

    @ApiModelProperty(value="createdBy创建者")
    private Long createdBy;

    @ApiModelProperty(value="modifiedOn更新时间")
    private Date modifiedOn;

    @ApiModelProperty(value="modifiedBy更新者")
    private Long modifiedBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public static App.Builder builder() {
        return new App.Builder();
    }

    public static class Builder {
        private App obj;

        public Builder() {
            this.obj = new App();
        }

        public Builder id(Integer id) {
            obj.setId(id);
            return this;
        }

        public Builder platform(String platform) {
            obj.setPlatform(platform);
            return this;
        }

        public Builder appKey(String appKey) {
            obj.setAppKey(appKey);
            return this;
        }

        public Builder name(String name) {
            obj.setName(name);
            return this;
        }

        public Builder description(String description) {
            obj.setDescription(description);
            return this;
        }

        public Builder createdOn(Date createdOn) {
            obj.setCreatedOn(createdOn);
            return this;
        }

        public Builder createdBy(Long createdBy) {
            obj.setCreatedBy(createdBy);
            return this;
        }

        public Builder modifiedOn(Date modifiedOn) {
            obj.setModifiedOn(modifiedOn);
            return this;
        }

        public Builder modifiedBy(Long modifiedBy) {
            obj.setModifiedBy(modifiedBy);
            return this;
        }

        public App build() {
            return this.obj;
        }
    }

    public enum Column {
        id("id", "id", "INTEGER", false),
        platform("platform", "platform", "CHAR", false),
        appKey("app_key", "appKey", "VARCHAR", false),
        name("name", "name", "VARCHAR", false),
        description("description", "description", "VARCHAR", false),
        createdOn("created_on", "createdOn", "TIMESTAMP", false),
        createdBy("created_by", "createdBy", "BIGINT", false),
        modifiedOn("modified_on", "modifiedOn", "TIMESTAMP", false),
        modifiedBy("modified_by", "modifiedBy", "BIGINT", false);

        private static final String BEGINNING_DELIMITER = "\"";

        private static final String ENDING_DELIMITER = "\"";

        private final String column;

        private final boolean isColumnNameDelimited;

        private final String javaProperty;

        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }
    }
}