package cn.asunboy.auth.test;


import cn.asunboy.PageInfo;
import cn.asunboy.PageQueryCond;
import cn.asunboy.auth.model.UserQueryCond;
import cn.asunboy.auth.service.AcUserService;
import cn.asunboy.service.config.ServiceConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author LiPengJu
 * @date 2018/9/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {})
public class AcUserServiceTest {
    @Autowired
    private AcUserService userService;
    @Test
    public void listUser(){
        PageQueryCond<UserQueryCond> cond = new PageQueryCond<>();
        cond.setPageInfo(null);
        cond.setSortPolicy("name");
        System.out.println(userService.listUser(cond));
    }
}
