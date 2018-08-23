package cn.asunboy.auth.web.security;

/**
 * 登陆用户
 *
 * @author LiPengJu
 * @date 2018/8/23
 */
public class LoginUser {
    private Long userId;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
