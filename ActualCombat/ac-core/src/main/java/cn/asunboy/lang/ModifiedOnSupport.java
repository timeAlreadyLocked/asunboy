package cn.asunboy.lang;

import java.util.Date;

/**
 * 数据更新控制接口
 * @author LiPengJu
 * @date 2018/7/31
 */
public interface ModifiedOnSupport {
    Date getModifiedOn();
    void setModifiedOn(Date modifiedOn);
}
