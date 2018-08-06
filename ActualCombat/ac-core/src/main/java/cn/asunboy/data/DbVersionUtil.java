package cn.asunboy.data;

import cn.asunboy.ApplicationException;
import cn.asunboy.lang.ModifiedOnSupport;
import cn.asunboy.lang.VersionSupport;

import java.util.Objects;

/**
 * 数据版本控制工具
 *
 * @author LiPengJu
 * @date 2018/8/4
 */
public final class DbVersionUtil {

    /**
     * 创建前调用 设置更新者，清除更新时间，创建时间
     * @param entry 需要创建的数据
     */
    public static void prepareCreate(VersionSupport entry) {
        Objects.requireNonNull(entry.getModifiedBy(),"modifiedBy cannot be null");
        entry.setCreatedBy(entry.getModifiedBy());
        entry.setCreatedOn(null);
        entry.setModifiedOn(null);
    }

    /**
     * 更新前调用 设置更新者，清除创建时间和创建者
     * @param entry 更新的数据
     */
    public static void prepareUpdate(VersionSupport entry){
        Objects.requireNonNull(entry.getModifiedBy());
        entry.setCreatedOn(null);
        entry.setCreatedBy(null);
    }

    /**
     * 清除版本信息
     * @param entry 需要清除的数据
     */
    public static void clearVersion(VersionSupport entry){
        entry.setCreatedBy(null);
        entry.setCreatedOn(null);
        entry.setModifiedOn(null);
        entry.setModifiedBy(null);
    }

    /**
     * 更新前的版本检查
     * @param updatingEntry 要更新的数据
     * @param oldEntry 老数据
     * @param name 更新对象(自定义)
     */
    public static void validateModifiedOn(ModifiedOnSupport updatingEntry, ModifiedOnSupport oldEntry,String name){
        if(oldEntry == null){
            throw new ApplicationException(name+"更新失败。数据已被其他用户删除");
        }
        if(!oldEntry.getModifiedOn().equals(updatingEntry.getModifiedOn())){
            throw new ApplicationException(name + "更新失败。数据已被其他用户更新,请重新加载");
        }
        updatingEntry.setModifiedOn(null);
    }
}
