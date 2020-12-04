package com.alibaba.csp.sentinel.dashboard.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = DashboardDataSourceConfig.DASHBOARD_DATASOURCE_PREFIX)
public class DashboardDataSourceConfig {
	
	public static final String DASHBOARD_DATASOURCE_PREFIX = "sentinel.dashboard.datasource";
	
	private String dataType = "json";
	
	private NacosDataSourceProperties nacos;

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public NacosDataSourceProperties getNacos() {
		return nacos;
	}

	public void setNacos(NacosDataSourceProperties nacos) {
		this.nacos = nacos;
	}
	
	
}
