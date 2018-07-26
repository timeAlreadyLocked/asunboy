package cn.asunboy.auth.entity;

public class AcLoginKey {
    private Byte loginTypeId;

    private Long loginTargetId;

    public Byte getLoginTypeId() {
        return loginTypeId;
    }

    public void setLoginTypeId(Byte loginTypeId) {
        this.loginTypeId = loginTypeId;
    }

    public Long getLoginTargetId() {
        return loginTargetId;
    }

    public void setLoginTargetId(Long loginTargetId) {
        this.loginTargetId = loginTargetId;
    }
}