package cn.asunboy.service;

import cn.asunboy.util.SnowflakeIdWorker;

/**
 * @author LiPengJu
 * @date 2018/8/4
 */
public class IdWorkerUniqueIdGenerator implements UniqueIdGenerator {
    private final SnowflakeIdWorker idWorker;

    public IdWorkerUniqueIdGenerator(SnowflakeIdWorker idWorker) {
        this.idWorker = idWorker;
    }

    @Override
    public Long generator(String name) {
        return idWorker.getWorkerId();
    }
}
