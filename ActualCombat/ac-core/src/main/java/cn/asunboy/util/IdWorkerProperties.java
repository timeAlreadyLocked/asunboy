package cn.asunboy.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author LiPengJu
 * @date 2018/8/5
 */
@ConfigurationProperties(IdWorkerProperties.CONFIG_PREFIX)
public class IdWorkerProperties {
    public static final String CONFIG_PREFIX = "sc.idcenter";

    private Long workerId = 1L;
    private Long sequence = 1L;
    private Long idepoch = 1344322705519L;

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public Long getIdepoch() {
        return idepoch;
    }

    public void setIdepoch(Long idepoch) {
        this.idepoch = idepoch;
    }
}
