package cn.asunboy;

import java.util.List;

/**
 * 分页数据和分页信息
 *
 * @author LiPengJu
 * @date 2018/9/8
 */
public interface Page<T> {
    List<T> getData();

    PageInfo getPag();

}
