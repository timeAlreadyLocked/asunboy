package cn.asunboy.auth.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiPengJu
 * @date 2018/7/28
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    public ResponseEntity<String> login() {
        String loginHtml = "login";
        return ResponseEntity.ok(loginHtml);
    }
}
