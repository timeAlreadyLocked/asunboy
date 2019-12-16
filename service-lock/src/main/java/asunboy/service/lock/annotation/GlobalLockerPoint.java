package asunboy.service.lock.annotation;

import asunboy.service.lock.exception.ServiceException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
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
        Objects.requireNonNull(globalLock, "what globalLock is null?");
        String[] keys = globalLock.key();
        String[] values = globalLock.value();
        String[] userKeys = keys.length == 0 ? values : keys;
        if (userKeys.length == 0)
            throw new RuntimeException("why key is null?");
        Object[] keyValues = new Object[userKeys.length];
        for (int index = 0; index < userKeys.length; index++) {
            keyValues[index] = AspectSupportUtils.getKeyValue(point, userKeys[index]);
            System.out.println(keyValues[index]);
        }
        List<RLock> locks = new ArrayList<>(keyValues.length);
        int waitTime = globalLock.waitLock() ? globalLock.waitTime() : 0;
        for (Object keyValue : keyValues) {
            RLock lock = redissonClient.getLock(keyValue.toString());
            boolean result = lock.tryLock(waitTime, globalLock.holdTime(), TimeUnit.SECONDS);
            if (!result && !globalLock.waitLock())
                throw new ServiceException(globalLock.message());
            locks.add(lock);
        }
        Object proceed = point.proceed();
        for (RLock lock : locks) {
            lock.unlock();
        }
        return proceed;
    }

}
