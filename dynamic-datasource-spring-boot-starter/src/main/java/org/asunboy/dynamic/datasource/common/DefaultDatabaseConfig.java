package org.asunboy.dynamic.datasource.common;

import com.zaxxer.hikari.HikariConfig;

/**
 * 数据库配置类
 */
public class DefaultDatabaseConfig implements DatabaseConfig {
    private Long id;
    private HikariConfig config;

    public DefaultDatabaseConfig(Long id, String url, String username, String password, String driverClassName) {
        this.id = id;
        this.config = new HikariConfig();
        DatabaseConfig defaultConfig = CurrentDbSchemaHolder.getDefaultConfig();
        if (url == null)
            url = defaultConfig.getConfig().getJdbcUrl();
        if (username == null)
            username = defaultConfig.getConfig().getUsername();
        if (password == null)
            password = defaultConfig.getConfig().getPassword();
        if (driverClassName == null)
            driverClassName = defaultConfig.getConfig().getDriverClassName();
        this.config.setJdbcUrl(url);
        this.config.setUsername(username);
        this.config.setPassword(password);
        this.config.setDriverClassName(driverClassName);
    }

    public DefaultDatabaseConfig(Long id, HikariConfig config) {
        this.id = id;
        this.config = config;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public HikariConfig getConfig() {
        return this.config;
    }

    @Override
    public void setConfig(HikariConfig config) {
        DatabaseConfig defaultConfig = CurrentDbSchemaHolder.getDefaultConfig();
        if(config == null)
            config = defaultConfig.getConfig();
        this.config = config;
    }
}
