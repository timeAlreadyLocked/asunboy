package cn.asunboy.lang;

import java.util.Date;

/**
 * 数据版本控制接口
 * @author LiPengJu
 * @date 2018/7/31
 */
public interface VersionSupport extends ModifiedOnSupport {
    /**
     * 获取创建时间
     * @return
     */
    Date getCreatedOn();

    /**
     * 设置创建时间
     */
    void setCreatedOn(Date createdOn);

    /**
     * 获得创建者
     * @return
     */
    Long getCreatedBy();

    /**
     * 设置创建者
     */
    void setCreatedBy(Long createdBy);

    /**
     * 设置修改者
     */
    void setModifiedBy(Long modifiedBy);

    /**
     * 获得修改者
     * @return
     */
    Long getModifiedBy();

}
