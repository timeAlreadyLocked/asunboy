package cn.asunboy.auth.service;

import cn.asunboy.auth.entity.AcUser;

import java.util.List;

/**
 * 用户服务
 * @author LiPengJu
 * @date 2018/7/25
 */
public interface AcUserService {
    /**
     * 创建用户
     * @param user 用户信息
     * @return 用户id
     */
    Long createUser(AcUser user);

    /**
     * 更新用户
     * @param user 用户信息
     */
    void updateUser(AcUser user);

    /**
     * 根据用户Id获取用户信息
     * @param userId 用户Id
     * @return 用户信息
     */
    AcUser getUserByUserId(Long userId);

    /**
     * 获得所有用户
     * @return 用户集合
     */
    List<AcUser> listUser();

    AcUser getUserByUserNameAndPwd(String loginName,String loginPwd);

}
