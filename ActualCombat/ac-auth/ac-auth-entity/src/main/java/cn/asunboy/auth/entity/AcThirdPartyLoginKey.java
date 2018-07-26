package cn.asunboy.auth.entity;

public class AcThirdPartyLoginKey {
    private Long userId;

    private Byte loginTypeId;

    private Long thirdPartyLoginId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getLoginTypeId() {
        return loginTypeId;
    }

    public void setLoginTypeId(Byte loginTypeId) {
        this.loginTypeId = loginTypeId;
    }

    public Long getThirdPartyLoginId() {
        return thirdPartyLoginId;
    }

    public void setThirdPartyLoginId(Long thirdPartyLoginId) {
        this.thirdPartyLoginId = thirdPartyLoginId;
    }
}