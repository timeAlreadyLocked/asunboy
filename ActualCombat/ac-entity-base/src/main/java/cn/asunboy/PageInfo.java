package cn.asunboy;

/**
 * 分页信息
 *
 * @author LiPengJu
 * @date 2018/9/8
 */
public interface PageInfo {
    Integer getPageNumber();

    void setPageNumber(Integer pageNumber);

    Integer getPageSize();

    void setPageSize(Integer pageSize);

    Integer getTotalCount();

    void setTotalCount(Integer totalCount);
}
