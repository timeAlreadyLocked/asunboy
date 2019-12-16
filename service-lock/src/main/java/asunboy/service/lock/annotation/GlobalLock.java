package asunboy.service.lock.annotation;

import java.lang.annotation.*;

/**
 * 分布式锁注解
 *
 * @author LiPengJu
 * @date: 2019/12/13
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GlobalLock {
    /**
     * 获取锁的key 支持spring el表达式  默认值:方法全路径名-参数值
     *
     * @return
     */
    String[] key() default {};

    /**
     * 等待获得锁的时间 单位秒
     *
     * @return
     */
    int waitTime() default 30;

    /**
     * 持有锁的时间  单位秒
     *
     * @return
     */
    int holdTime() default 20;

    /**
     * 没获得锁是否等待锁释放
     *
     * @return
     */
    boolean waitLock() default true;

    String code() default "1";

    /**
     * 消息
     *
     * @return
     */
    String message() default "";

    String[] value() default {""};

}
