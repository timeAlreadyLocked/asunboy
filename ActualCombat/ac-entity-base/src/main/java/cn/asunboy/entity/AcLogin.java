package cn.asunboy.entity;

public class AcLogin extends AcLoginKey {
    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }
}