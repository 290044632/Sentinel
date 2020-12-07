package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.SystemRuleProvider;
import com.alibaba.csp.sentinel.datasource.Converter;

public class SystemRuleNacosProvider implements SystemRuleProvider {

	@Autowired
	private NacosClientProxy nacosClientProxy;

	@Autowired
	private Converter<String, List<SystemRuleEntity>> converter;

	@Override
	public List<SystemRuleEntity> getRules(String appName) throws Exception {
		return null;
	}

	@Override
	public List<SystemRuleEntity> getRules(String app, String ip, Integer port) throws Exception {

		return this.nacosClientProxy.get(app, ip, port, NacosConfigConstant.SYSTEM_RULE_DATA_ID_POSTFIX, converter);
	}

}
