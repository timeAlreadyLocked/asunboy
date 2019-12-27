package asunboy.service.lock.controller;

import asunboy.service.lock.model.RestResult;
import asunboy.service.lock.service.GlobalLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiPengJu
 * @date: 2019/12/13
 */
@RestController
@RequestMapping("/test")
public class GlobalLockController {
    @Autowired
    private GlobalLockService globalLockService;

    @GetMapping("/1")
    public RestResult test1(@RequestParam("num") Integer num) {
        return new RestResult(globalLockService.test1(num));
    }

    @GetMapping("/2")
    public RestResult test2(@RequestParam("num") Integer num) {
        return new RestResult(globalLockService.test2(num));
    }

    @GetMapping("/3")
    public RestResult test3(@RequestParam("num") Integer num) {
        return new RestResult(globalLockService.test3(num));
    }

    @GetMapping("/5")
    public RestResult test5(Integer num) {
        return new RestResult(globalLockService.test5(num));
    }

    @GetMapping("/6")
    public RestResult test56() {
        return new RestResult(globalLockService.test6());
    }

    @GetMapping("/7")
    public RestResult test7(Integer num) {
        return new RestResult(globalLockService.test7(num));
    }

    @GetMapping("/8")
    public RestResult test8() {
        return new RestResult(globalLockService.test8());
    }

    @GetMapping("/9")
    public RestResult test9() {
        return new RestResult(globalLockService.test9());
    }

    @GetMapping("/10")
    public RestResult test10() {
        return new RestResult(globalLockService.test10());
    }
}
