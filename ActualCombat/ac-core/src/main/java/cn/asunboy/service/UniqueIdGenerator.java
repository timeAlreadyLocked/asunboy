package cn.asunboy.service;

/**
 * 唯一id发号器
 *
 * @author LiPengJu
 * @date 2018/8/4
 */
public interface UniqueIdGenerator {

    Long generator(String name);
}
