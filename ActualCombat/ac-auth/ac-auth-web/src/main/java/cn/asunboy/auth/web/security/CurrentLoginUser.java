package cn.asunboy.auth.web.security;

/**
 * 当前登陆用户
 * @author LiPengJu
 * @date 2018/8/23
 */
public class CurrentLoginUser {
    private CurrentLoginUser(){}
    private static final ThreadLocal<LoginUser> _LOCAL_INSTANCE = new ThreadLocal<>();
    public static void setLoginUser(LoginUser loginUser){

    }
    public static LoginUser current(){return _LOCAL_INSTANCE.get();}
}
