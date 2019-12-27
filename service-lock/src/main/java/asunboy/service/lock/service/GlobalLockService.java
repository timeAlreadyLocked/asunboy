package asunboy.service.lock.service;

import asunboy.service.lock.annotation.GlobalLock;
import asunboy.service.lock.exception.ServiceException;
import asunboy.service.lock.mapper.AppMapper;
import asunboy.service.lock.model.App;
import com.sun.org.apache.bcel.internal.generic.FADD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.security.Key;

/**
 * @author LiPengJu
 * @date: 2019/12/13
 */
@Service
public class GlobalLockService {
    @Autowired
    private AppMapper appMapper;
    @Autowired
    private GlobalLockService globalLockService;

    @Transactional
    @GlobalLock(key = "#time+'-saa'", message = "正在同步中", waitLock = false)
    public String test1(Integer time) {
        try {
            System.out.println("业务代码执行中----test1---");
            appMapper.updateByPrimaryKeySelective(App.builder().id(1001).description(System.currentTimeMillis() + "").build());
            App app = appMapper.selectByPrimaryKey(1001);
            System.out.println("test1---修改后的数据但没提交：" + app.getDescription());
            globalLockService.test2(null);
            globalLockService.test4("a", "b");
            Thread.sleep(time);
            System.out.println("业务代码执行完成---");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new ServiceException("test1抛异常");
//        return "test1";
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @GlobalLock("test2")
    public String test2(Integer time) {
        try {
            System.out.println("----test2");
            appMapper.updateByPrimaryKeySelective(App.builder().id(101).description(System.currentTimeMillis() + "").build());
            App app = appMapper.selectByPrimaryKey(101);
            System.out.println("test2---修改后的数据但没提交：" + app.getDescription());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test2";
    }

    @GlobalLock(value = {"#time+'-saa'", "test2"})
    public String test3(Integer time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test3";
    }

    @GlobalLock
    public String test4(String a, String b) {
        System.out.println("test4");
        return "test4";
    }

    @GlobalLock(key = {"A", "B"}, holdTime = 10)
    public String test5(Integer time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test5";
    }

    @GlobalLock(key = {"C", "B"}, waitTime = 10)
    public String test6() {
        return "test6";
    }

    @GlobalLock(key = "B")
    public String test7(Integer time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test7";
    }

    @GlobalLock(key = "A", waitLock = false, message = "正在同步中", code = "2")
    public String test8() {
        return "test8";
    }

    @GlobalLock({"A", "B"})
    public String test9() {
        return "test9";
    }

    @GlobalLock(value = "A", waitLock = false, code = "100", message = "正在生成报表")
    public String test10() {
        return "test10";
    }
}
