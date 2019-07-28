package org.asunboy.dynamic.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.asunboy.dynamic.datasource.common.CurrentDbSchemaHolder;
import org.asunboy.dynamic.datasource.common.DatabaseConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DynamicDataSource extends HikariDataSource {

    private static Logger log = LogManager.getLogger(DynamicDataSource.class);

    /**
     * 改写本方法是为了在请求不同工程的数据时去连接不同的数据库。
     */
    @Override
    public Connection getConnection() {
        //1、获取数据源
        DataSource dataSource = CurrentDbSchemaHolder.instance().getCurrentDbSchema();
        //2、如果数据源不存在则创建
        if (dataSource == null) {
            //防止重复创建数据源
            synchronized (this) {
                dataSource = CurrentDbSchemaHolder.instance().getCurrentDbSchema();
                if (dataSource == null) {
                    DataSource newDataSource = initDbSchema();
                    if (newDataSource != null)
                        CurrentDbSchemaHolder.instance().addDbSchema(newDataSource);
                    dataSource = newDataSource;
                }
            }
        }
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 初始化当前数据源
     *
     * @return dds
     */
    private DataSource initDbSchema() {
        DatabaseConfig localConfig = CurrentDbSchemaHolder.getLocalConfig();
        HikariDataSource dataSource = new HikariDataSource(localConfig.getConfig());
        log.info("created datasource for config -> "+localConfig.getConfig());
        return dataSource;
    }
}
