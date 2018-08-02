package cn.asunboy.auth.service.impl;

import cn.asunboy.auth.data.AcUserMapper;
import cn.asunboy.auth.entity.AcUser;
import cn.asunboy.auth.service.AcUserServcie;

import java.util.List;

/**
 * 用户服务实现
 *
 * @author LiPengJu
 * @date 2018/7/25
 */
public class AcUserServiceImpl implements AcUserServcie {
    private final AcUserMapper userMapper;

    public AcUserServiceImpl(AcUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Long createUser(AcUser user) {
        user.setCreatedOn(null);
        return null;
    }

    @Override
    public void updateUser(AcUser user) {

    }

    @Override
    public AcUser getUserByUserId(Long userId) {
        return null;
    }

    @Override
    public List<AcUser> listUser() {
        return null;
    }
}
