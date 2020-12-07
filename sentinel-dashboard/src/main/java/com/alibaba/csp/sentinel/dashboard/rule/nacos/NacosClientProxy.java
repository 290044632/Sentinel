package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.config.DashboardDataSourceConfig;
import com.alibaba.csp.sentinel.dashboard.config.NacosDataSourceProperties;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.nacos.api.config.ConfigService;

public class NacosClientProxy {

	@Autowired
	private ConfigService configService;

	@Autowired
	private DashboardDataSourceConfig dataSourceConfig;

	public <T> boolean publish(String app, String ip, Integer port, T rules, String ruleType,
			Converter<T, String> converter) throws Exception {
		NacosDataSourceProperties nacos = dataSourceConfig.getNacos();
		String dataId = this.getDataId(app, ip, port, ruleType);
		String content = converter.convert(rules);
		return configService.publishConfig(dataId, nacos.getGroupId(), content);
	}

	public <T> T get(String app, String ip, Integer port, String ruleType, Converter<String, T> converter)
			throws Exception {
		NacosDataSourceProperties nacos = dataSourceConfig.getNacos();
		String dataId = this.getDataId(app, ip, port, ruleType);
		String content = configService.getConfig(dataId, nacos.getGroupId(), nacos.getTimeout());
		return converter.convert(content);
	}

	private String getDataId(String app, String ip, Integer port, String ruleType) {
		String dataType = dataSourceConfig.getDataType();
		int indexOf = dataType.indexOf(".");
		if (indexOf < 0) {
			dataType = "." + dataType;
		}
		return new StringBuilder(app).append("-").append(ip).append("-").append(port).append(ruleType).toString();
	}
}
