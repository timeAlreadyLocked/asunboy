package org.asunboy.dynamic.datasource.common;


import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class CurrentDbSchemaTimer {
    /**
     * 空闲时间周期。超过这个时长没有访问的数据库连接将被释放。默认为一天。
     */
    private static long idlePeriodTime = 24 * 60 * 60 * 1000;

    /**
     * 动态数据源
     */
    private DataSource dataSource;

    /**
     * 上一次访问的时间
     */
    private long lastUseTime;

    public CurrentDbSchemaTimer(DataSource dataSource) {
        this.dataSource = dataSource;
        this.lastUseTime = System.currentTimeMillis();
    }

    /**
     * 更新最近访问时间
     */
    public void refreshTime() {
        lastUseTime = System.currentTimeMillis();
    }

    /**
     * 检测数据连接是否超时关闭。
     *
     * @return true-已超时关闭; false-未超时
     */
    public boolean checkAndClose() {
        //不同数据源判断
        HikariDataSource hikariDataSource = null;
        if (dataSource instanceof HikariDataSource)
            hikariDataSource = (HikariDataSource) dataSource;
        if (System.currentTimeMillis() - lastUseTime > idlePeriodTime) {
            if (!hikariDataSource.isClosed())
                hikariDataSource.close();
            return true;
        }
        return hikariDataSource.isClosed();
    }

    public DataSource getCurrentDbSchema() {
        return dataSource;
    }
}
