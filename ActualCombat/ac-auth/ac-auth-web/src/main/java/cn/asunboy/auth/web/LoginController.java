package cn.asunboy.auth.web;

import cn.asunboy.auth.entity.AcUser;
import cn.asunboy.auth.service.AcUserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
    @PostMapping("/loginPost")
    public void loginPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        AcUser user = userService.getUserByUserNameAndPwd(loginName, loginPwd);
        System.out.println(response);
        AcUser user=new AcUser();
        user.setName("李鹏举");
        user.setId(100L);
        String name="李鹏举";
        String fileName="li.text";
        byte[] bytes = name.getBytes("utf-8");
        response.setHeader("content-disposition", "attachment;filename="+fileName);
        response.getOutputStream().write(bytes);
//        return ResponseEntity.ok(user);
//        return ResponseEntity.ok(new AcUser());
    }
}
