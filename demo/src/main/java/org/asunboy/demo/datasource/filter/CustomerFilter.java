package org.asunboy.demo.datasource.filter;

import org.asunboy.dynamic.datasource.common.CurrentDbSchemaHolder;
import org.asunboy.dynamic.datasource.common.DatabaseConfig;
import org.asunboy.dynamic.datasource.common.DefaultDatabaseConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiPengJu
 * @date: 2019/7/28
 */
@Component
public class CustomerFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //根据规则获取数据源配置信息（这里根据url规则）
        Map<String, DatabaseConfig> dynamicMap = obtainConfig();
        String url = httpServletRequest.getRequestURL().toString();
        String key = url.substring(url.lastIndexOf("/"));
        //设置当前线程数据源配置信息
        CurrentDbSchemaHolder.setLocalConfig(dynamicMap.get(key));
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        //清除当前线程的数据源配置信息
        CurrentDbSchemaHolder.setLocalConfig(null);
    }

    private Map<String, DatabaseConfig> obtainConfig() {
        Map<String, DatabaseConfig> dynamicMap = new HashMap<>();
        dynamicMap.put("/test1", new DefaultDatabaseConfig(2L,
                "jdbc:sqlserver://192.168.10.176:1433;DatabaseName=assetnew",
                "sa",
                "admin123456",
                "com.microsoft.sqlserver.jdbc.SQLServerDriver"));
        dynamicMap.put("/test3", new DefaultDatabaseConfig(3L,
                "jdbc:mysql://127.0.0.1:3306/tenant_center?useUnicode=true&characterEncoding=utf-8",
                "root",
                "123456",
                null));
        return dynamicMap;
    }
}
