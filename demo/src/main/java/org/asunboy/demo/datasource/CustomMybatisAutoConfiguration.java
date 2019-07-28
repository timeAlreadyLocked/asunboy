package org.asunboy.demo.datasource;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@org.springframework.context.annotation.Configuration
@EnableConfigurationProperties(MybatisProperties.class)
@AutoConfigureBefore(MybatisAutoConfiguration.class)
public class CustomMybatisAutoConfiguration implements ConfigurationCustomizer {
    private final MybatisProperties properties;

    public CustomMybatisAutoConfiguration(MybatisProperties properties) {
        this.properties = properties;
    }

    @Override
    public void customize(Configuration configuration) {
        final List<String> mapperLocations = new ArrayList<>();
        if (properties.getMapperLocations() != null) {
            mapperLocations.addAll(Arrays.asList(properties.getMapperLocations()));
        }
        final String defaultMapperLocation = "classpath*:mapper/*.xml";
        if (!mapperLocations.contains(defaultMapperLocation)) {
            mapperLocations.add(defaultMapperLocation);
            properties.setMapperLocations(mapperLocations.toArray(new String[mapperLocations.size()]));
        }
        configuration.setCacheEnabled(false);
        configuration.setMapUnderscoreToCamelCase(true);
    }
}
