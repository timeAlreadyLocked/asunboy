package cn.asunboy;

/**
 * 页面排序支持
 *
 * @author LiPengJu
 * @date 2018/9/11
 */
public interface SortPolicySupport {
    void setSortPolicy(String sortPolicy);

    String getSortPolicy();
}
