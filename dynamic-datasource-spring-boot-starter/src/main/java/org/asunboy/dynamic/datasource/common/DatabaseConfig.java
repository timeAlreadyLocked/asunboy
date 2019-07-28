package org.asunboy.dynamic.datasource.common;

import com.zaxxer.hikari.HikariConfig;

/**
 * 数据库配置信息
 */
public interface DatabaseConfig {
    /**
     * 获取数据库配置唯一标识
     *
     * @return
     */
    Long getId();

    /**
     * 设置数据库配置唯一标识
     *
     * @param id
     */
    void setId(Long id);

    HikariConfig getConfig();

    void setConfig(HikariConfig config);
}
