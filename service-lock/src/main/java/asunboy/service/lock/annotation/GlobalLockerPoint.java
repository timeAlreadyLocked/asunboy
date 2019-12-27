package asunboy.service.lock.annotation;

import asunboy.service.lock.exception.ServiceException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.redisson.api.RFuture;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 消息自定义? 前端解决
 *
 * @author LiPengJu
 * @date: 2019/12/13
 */
@Component
@Aspect
public class GlobalLockerPoint {
    @Autowired
    private RedissonClient redissonClient;

    @Pointcut("@annotation(globalLock)")
    public void globalLockPoint(GlobalLock globalLock) {
    }

    @Around("globalLockPoint(globalLock)")
    public Object around(ProceedingJoinPoint point, GlobalLock globalLock) throws Throwable {
        Objects.requireNonNull(globalLock, "why globalLock is null?");
        //获取key
        String[] keys = globalLock.key();
        String[] values = globalLock.value();
        String[] userKeys = keys.length == 0 ? values : keys;
        boolean waitLock = globalLock.verifyLock() ? false : globalLock.waitLock();
        if (userKeys.length == 0)
            throw new RuntimeException("why key is null?");
        Object[] keyValues = new Object[userKeys.length];
        for (int index = 0; index < userKeys.length; index++) {
            keyValues[index] = AspectSupportUtils.getKeyValue(point, userKeys[index]);
            System.out.println(keyValues[index]);
        }
        //开始加锁
        RLock[] locks = new RLock[keyValues.length];
        int waitTime = waitLock ? globalLock.waitTime() : 0;
        for (int index = 0; index < keyValues.length; index++) {
            RLock lock = redissonClient.getLock(keyValues[index].toString());
            locks[index] = lock;
        }
        RLock multiLock = redissonClient.getMultiLock(locks);
        Boolean result;
        if (waitLock) {
            RFuture<Boolean> tryLockAsync = multiLock.tryLockAsync(waitTime, globalLock.holdTime(), TimeUnit.SECONDS);
            result = tryLockAsync.get();
            //没有得到锁---impossible
            if (!result)
                throw new ServiceException("Why didn't you get the lock?");
        } else {
            //非等待锁不需要控制所有锁都获得后才去计算当前锁(指定锁的集合)的持有时间
            for (RLock lock : locks) {
                if (globalLock.verifyLock()) {
                    result = lock.isLocked();
                } else {
                    result = lock.tryLock(waitTime, globalLock.holdTime(), TimeUnit.SECONDS);
                }
                //直接返回结果类型的锁
                if (!result) {
                    for (RLock item : locks) {
                        if (item.isLocked() && item != lock)
                            item.unlock();
                    }
                    throw new ServiceException(globalLock.code(), globalLock.message());
                }
            }
        }
        try {
            //执行业务
            return point.proceed();
        } finally {
            //解锁
            boolean isSuccess = true;
            for (RLock lock : locks) {
                try {
                    lock.unlock();
                } catch (Exception e) {
                    //持有锁时间过长，数据回滚
                    isSuccess = false;
                }
            }
            if (!isSuccess)
                throw new ServiceException(globalLock.code(), "业务执行过长请稍后再试!");
        }
    }

}