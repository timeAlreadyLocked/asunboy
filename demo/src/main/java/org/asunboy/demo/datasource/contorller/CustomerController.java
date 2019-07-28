package org.asunboy.demo.datasource.contorller;

import org.asunboy.demo.datasource.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author LiPengJu
 * @date: 2019/7/26
 */
@RestController
public class CustomerController {
    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping("/test1")
    public Map test1() {
        return customerMapper.get();
    }

    @GetMapping("/test2")
    public Object test2() {
        return customerMapper.get2();
    }

    @GetMapping("/test3")
    public Map test3() {
        return customerMapper.get3();
    }
}
