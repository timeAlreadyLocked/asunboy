package cn.asunboy.auth.web;

import cn.asunboy.auth.entity.AcUser;
import cn.asunboy.auth.service.AcUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiPengJu
 * @date 2018/7/28
 */
@SpringBootApplication
@RestController
public class LoginController {

    private final AcUserService userService;

    public LoginController(AcUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ResponseEntity<AcUser> login(@RequestParam String loginName, @RequestParam String loginPwd) {
        AcUser user = userService.getUserByUserNameAndPwd(loginName, loginPwd);
        return ResponseEntity.ok(user);
//        return ResponseEntity.ok(new AcUser());
    }

    public static void main(String[] args) {
        SpringApplication.run(LoginController.class, args);
    }
}
