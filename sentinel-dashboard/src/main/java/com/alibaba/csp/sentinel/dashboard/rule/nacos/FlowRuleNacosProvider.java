package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.config.DashboardDataSourceConfig;
import com.alibaba.csp.sentinel.dashboard.config.NacosDataSourceProperties;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.FlowRuleProvider;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.nacos.api.config.ConfigService;

public class FlowRuleNacosProvider implements FlowRuleProvider {
	@Autowired
	private ConfigService configService;

	@Autowired
	private Converter<String, List<FlowRuleEntity>> converter;

	@Autowired
	private DashboardDataSourceConfig dataSourceConfig;

	@Override
	public List<FlowRuleEntity> getRules(String appName) throws Exception {
		NacosDataSourceProperties nacos = dataSourceConfig.getNacos();
		String dataType = dataSourceConfig.getDataType();
		int indexOf = dataType.indexOf(".");
		if (indexOf < 0) {
			dataType = "." + dataType;
		}
		String rules = configService.getConfig(appName + NacosConfigConstant.FLOW_DATA_ID_POSTFIX + dataType,
				nacos.getGroupId(), nacos.getTimeout());
		if (StringUtil.isEmpty(rules)) {
			return new ArrayList<>();
		}
		return converter.convert(rules);
	}

}
