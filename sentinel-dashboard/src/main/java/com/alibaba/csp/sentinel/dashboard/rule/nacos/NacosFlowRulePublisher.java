package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.config.DashboardDataSourceConfig;
import com.alibaba.csp.sentinel.dashboard.config.NacosDataSourceProperties;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.FlowRulePublisher;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.nacos.api.config.ConfigService;

public class NacosFlowRulePublisher implements FlowRulePublisher {

	@Autowired
	private ConfigService configService;

	@Autowired
	private Converter<List<FlowRuleEntity>, String> converter;

	@Autowired
	private DashboardDataSourceConfig dataSourceConfig;

	@Override
	public void publish(String app, List<FlowRuleEntity> rules) throws Exception {
		NacosDataSourceProperties nacos = dataSourceConfig.getNacos();
		String dataType = dataSourceConfig.getDataType();
		int indexOf = dataType.indexOf(".");
		if (indexOf < 0) {
			dataType = "." + dataType;
		}
		configService.publishConfig(app + NacosConfigConstant.FLOW_DATA_ID_POSTFIX + dataType, nacos.getGroupId(),
				converter.convert(rules));
	}
}
