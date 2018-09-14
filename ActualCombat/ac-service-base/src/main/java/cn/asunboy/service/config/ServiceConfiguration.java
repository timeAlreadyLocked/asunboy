package cn.asunboy.service.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiPengJu
 * @date 2018/9/13
 */
@Configuration
@ComponentScan(basePackages = {"cn.asunboy"})
public class ServiceConfiguration {

    @Bean
    public PageInterceptor pageInterceptor() {
        return new PageInterceptor();
    }
}
