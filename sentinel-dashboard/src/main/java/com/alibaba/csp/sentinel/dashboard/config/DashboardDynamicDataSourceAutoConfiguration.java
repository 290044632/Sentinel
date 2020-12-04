package com.alibaba.csp.sentinel.dashboard.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = { DashboardDataSourceConfig.class })
public class DashboardDynamicDataSourceAutoConfiguration {

}
