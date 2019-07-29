package org.asunboy.dynamic.datasource.common;


import org.asunboy.dynamic.datasource.util.ClearIdleTimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;

public class CurrentDbSchemaHolder {

    private static Logger logger = LoggerFactory.getLogger(CurrentDbSchemaHolder.class);
    /**
     * 当前请求的数据库配置信息
     */
    private static ThreadLocal<DatabaseConfig> _localConfig = new ThreadLocal<>();

    /**
     * 默认数据库配置
     */
    private static DatabaseConfig _defaultConfig;

    public static DatabaseConfig getLocalConfig() {
        DatabaseConfig databaseConfig = _localConfig.get();
        if (databaseConfig == null) {
            //初始化默认配置
            logger.info("use default databaseConfig");
            return _defaultConfig;
        }
        return databaseConfig;
    }

    public static void setLocalConfig(DatabaseConfig config) {
        if (config == null)
            _localConfig.remove();
        else
            _localConfig.set(config);
    }

    public static DatabaseConfig getDefaultConfig() {
        return _defaultConfig;
    }

    public static void setDefaultConfig(DatabaseConfig _defaultConfig) {
        logger.info("init default database config");
        CurrentDbSchemaHolder._defaultConfig = _defaultConfig;
    }

    /**
     * 管理动态数据源列表。<租户id，数据源>
     */
    private Map<Long, CurrentDbSchemaTimer> currentDbSchemaTimerMap = new ConcurrentHashMap<>();

    /**
     * 通过定时任务周期性清除不使用的数据源
     */
    private static Timer clearIdleTask = new Timer();

    static {
        clearIdleTask.schedule(new ClearIdleTimerTask(), 5000, 60 * 1000 * 1);
    }

    private CurrentDbSchemaHolder() {
    }

    /**
     * 获取单例对象
     */
    public static CurrentDbSchemaHolder instance() {
        return CurrentDbSchemaHolderBuilder.instance;
    }

    /**
     * 添加动态数据源。
     *
     * @param dataSource dataSource
     */
    public void addDbSchema(DataSource dataSource) {
        DatabaseConfig localConfig = getLocalConfig();
        if (localConfig == null) {
            return;
        }
        CurrentDbSchemaTimer currentDbSchemaTimer = new CurrentDbSchemaTimer(dataSource);
        currentDbSchemaTimerMap.put(localConfig.getId(), currentDbSchemaTimer);
    }

    /**
     * 查询动态数据源
     *
     * @return dataSource
     */
    public DataSource getCurrentDbSchema() {
        DatabaseConfig localConfig = getLocalConfig();
        if (currentDbSchemaTimerMap.containsKey(localConfig.getId())) {
            CurrentDbSchemaTimer currentDbSchemaTimer = currentDbSchemaTimerMap.get(localConfig.getId());
            currentDbSchemaTimer.refreshTime();
            return currentDbSchemaTimer.getCurrentDbSchema();
        }
        return null;
    }

    /**
     * 清除超时无人使用的数据源。 确保连接池中的连接被释放,map中引用对象被回收
     */
    public void clearIdleDbSchema() {
        Iterator<Map.Entry<Long, CurrentDbSchemaTimer>> iter = currentDbSchemaTimerMap.entrySet().iterator();
        for (; iter.hasNext(); ) {
            Map.Entry<Long, CurrentDbSchemaTimer> entry = iter.next();
            if (entry.getValue().checkAndClose()) {
                iter.remove();
            }
        }
    }

    public void clearIdleDbSchema(Long id) {
        currentDbSchemaTimerMap.remove(id);
    }

    private static class CurrentDbSchemaHolderBuilder {
        private static CurrentDbSchemaHolder instance = new CurrentDbSchemaHolder();
    }
}
