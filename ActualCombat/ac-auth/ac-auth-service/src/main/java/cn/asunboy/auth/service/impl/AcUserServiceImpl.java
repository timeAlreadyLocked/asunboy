package cn.asunboy.auth.service.impl;

import cn.asunboy.Page;
import cn.asunboy.PageQueryCond;
import cn.asunboy.auth.data.AcUserMapper;
import cn.asunboy.auth.entity.AcUser;
import cn.asunboy.auth.entity.AcUserExample;
import cn.asunboy.auth.model.UserQueryCond;
import cn.asunboy.auth.service.AcUserService;
import cn.asunboy.data.DbVersionUtil;
import cn.asunboy.service.UniqueIdGenerator;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 用户服务实现
 *
 * @author LiPengJu
 * @date 2018/7/25
 */
@Service
public class AcUserServiceImpl implements AcUserService {
    private final AcUserMapper userMapper;
    private final UniqueIdGenerator generator;

    public AcUserServiceImpl(AcUserMapper userMapper, UniqueIdGenerator generator) {
        this.userMapper = userMapper;
        this.generator = generator;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Long createUser(AcUser user) {
        DbVersionUtil.prepareCreate(user);
        user.setId(generator.generator(""));
        userMapper.insertSelective(user);
        return user.getId();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateUser(AcUser user) {
        Objects.requireNonNull(user.getModifiedBy());
        Objects.requireNonNull(user.getModifiedOn());
        Objects.requireNonNull(user.getId());
        DbVersionUtil.prepareUpdate(user);
        AcUser oldUser = userMapper.selectByPrimaryKey(user.getId());
        DbVersionUtil.validateModifiedOn(user, oldUser, "用户");
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public AcUser getUserByUserId(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<AcUser> listUser() {
        AcUserExample userExample = new AcUserExample();
        List<AcUser> users = userMapper.selectByExample(userExample);
        return users;
    }

    @Override
    public AcUser getUserByUserNameAndPwd(String loginName, String loginPwd) {
        AcUserExample userExample = new AcUserExample();
        userExample.createCriteria().andNameEqualTo(loginName).andLoginPwdEqualTo(loginPwd);
        List<AcUser> users = userMapper.selectByExample(userExample);
        if (users == null || users.size() == 0) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public Page<AcUser> listUser(PageQueryCond<UserQueryCond> cond) {
        Supplier<String> supplier = () -> "ss";
        PageHelper.startPage(3, 10);
        AcUserExample userExample = new AcUserExample();
        userMapper.selectByExample(userExample);
//        Consumer<String> consumer= (x) -> {return "ss";};
//        consumer.accept();`
        supplier.get();
        return null;
    }
}
