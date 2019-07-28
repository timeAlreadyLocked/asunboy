package org.asunboy.dynamic.datasource.config;

import org.asunboy.dynamic.datasource.DynamicDataSource;
import org.asunboy.dynamic.datasource.common.CurrentDbSchemaHolder;
import org.asunboy.dynamic.datasource.common.DefaultDatabaseConfig;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataSourceConfig {

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DynamicDataSource getDataSource(DataSourceProperties properties) {
        //创建数据源模板
        DynamicDataSource dataSource = properties.initializeDataSourceBuilder().type(DynamicDataSource.class).build();
        //初始化默认数据源配置
        CurrentDbSchemaHolder.setDefaultConfig(new DefaultDatabaseConfig(0L, dataSource));
        return dataSource;
    }
}
