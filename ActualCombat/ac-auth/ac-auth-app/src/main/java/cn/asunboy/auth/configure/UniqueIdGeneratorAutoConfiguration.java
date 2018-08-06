package cn.asunboy.auth.configure;

import cn.asunboy.service.IdWorkerUniqueIdGenerator;
import cn.asunboy.service.UniqueIdGenerator;
import cn.asunboy.util.IdWorkerProperties;
import cn.asunboy.util.SnowflakeIdWorker;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiPengJu
 * @date 2018/8/5
 */
@Configuration
@ConditionalOnClass({SnowflakeIdWorker.class, IdWorkerUniqueIdGenerator.class})
@EnableConfigurationProperties(IdWorkerProperties.class)
public class UniqueIdGeneratorAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean(UniqueIdGenerator.class)
    public UniqueIdGenerator uniqueIdGenerator(SnowflakeIdWorker idWorker) {
        return new IdWorkerUniqueIdGenerator(idWorker);
    }

    @Bean
    @ConditionalOnMissingBean(SnowflakeIdWorker.class)
    public SnowflakeIdWorker snowflakeIdWorker(IdWorkerProperties properties) {
        return new SnowflakeIdWorker(properties.getWorkerId(), properties.getSequence(), properties.getIdepoch());
    }

//    @Bean
//    @ConditionalOnMissingBean(SnowflakeSidWorker.class)
//    public SnowflakeSidWorker snowflakeSidWorker(SnowflakeIdWorker snowflakeIdWorker) {
//        return new SnowflakeSidWorker(snowflakeIdWorker);
//    }
}
