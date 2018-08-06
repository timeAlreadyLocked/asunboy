package cn.asunboy.util;

import java.util.Random;

/**
 * from https://github.com/twitter/snowflake/blob/master/src/main/scala/com/twitter/service/snowflake/IdWorker.scala
 *
 * @author LiPengJu
 * @date 2018/8/4
 */
public class SnowflakeIdWorker {
    /**
     * 工作机器ID
     */
    private final long workerId;

    private final long idepoch;

    private static final long WORKER_ID_BITS = 5L;
    private static final long MAX_WORKER_ID = -1L ^ (-1L << WORKER_ID_BITS);

    private static final long SEQUENCE_BITS = 8L;
    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS;
    private static final long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;
    private static final long SEQUENCE_MASK = -1L ^ (-1L << SEQUENCE_BITS);

    private long lastTimestamp = -1L;
    private long sequence;
    private static final Random r = new Random();

    public SnowflakeIdWorker(long workerId, long sequence) {
        this(workerId, sequence, 1344322705519L);
    }

    public SnowflakeIdWorker(long workerId, long sequence, long idepoch) {
        this.workerId = workerId;
        this.sequence = sequence;
        this.idepoch = idepoch;
        if (workerId < 0 || workerId > MAX_WORKER_ID) {
            throw new IllegalArgumentException("workerId is illegal: " + workerId);
        }
        if (idepoch >= System.currentTimeMillis()) {
            throw new IllegalArgumentException("idepoch is illegal: " + idepoch);
        }
    }

    public long getWorkerId() {
        return workerId;
    }

    public long getTime() {
        return System.currentTimeMillis();
    }

    public synchronized long nextId() {
        long timestamp = getTime();
        if (timestamp < lastTimestamp) {
            throw new IllegalStateException("Clock moved backwards.");
        }
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & SEQUENCE_MASK;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }
        lastTimestamp = timestamp;
        long id = ((timestamp - idepoch) << TIMESTAMP_LEFT_SHIFT) | (workerId << WORKER_ID_SHIFT) | sequence;
        return id;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = getTime();
        while (timestamp <= lastTimestamp) {
            timestamp = getTime();
        }
        return timestamp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SnowflakeIdWorker{");
        sb.append("workerId=").append(workerId);
        sb.append(", idepoch=").append(idepoch);
        sb.append(", lastTimestamp=").append(lastTimestamp);
        sb.append(", sequence=").append(sequence);
        sb.append('}');
        return sb.toString();
    }
}
