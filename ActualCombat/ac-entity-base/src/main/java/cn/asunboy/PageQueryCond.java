package cn.asunboy;

/**
 * 页面查询接口
 *
 * @author LiPengJu
 * @date 2018/9/11
 */
public class PageQueryCond<T> implements SortPolicySupport {
    /**
     * 过滤条件
     */
    private T filter;
    /**
     * 分页条件
     */
    private PageInfo pageInfo;
    /**
     * 排序策略
     */
    private String sortPolicy;

    public T getFilter() {
        return filter;
    }

    public void setFilter(T filter) {
        this.filter = filter;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    @Override
    public void setSortPolicy(String sortPolicy) {
        this.sortPolicy = sortPolicy;
    }

    @Override
    public String getSortPolicy() {
        return this.sortPolicy;
    }
}
