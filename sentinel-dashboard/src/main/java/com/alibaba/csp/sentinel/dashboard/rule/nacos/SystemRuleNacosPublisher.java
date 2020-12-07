package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.SystemRulePublisher;
import com.alibaba.csp.sentinel.datasource.Converter;

public class SystemRuleNacosPublisher implements SystemRulePublisher {

	@Autowired
	private NacosClientProxy nacosClientProxy;

	@Autowired
	private Converter<List<SystemRuleEntity>, String> converter;

	@Override
	public void publish(String app, List<SystemRuleEntity> rules) throws Exception {

	}

	@Override
	public boolean publish(String app, String ip, Integer port, List<SystemRuleEntity> rules) throws Exception {
		return nacosClientProxy.publish(app, ip, port, rules, NacosConfigConstant.SYSTEM_RULE_DATA_ID_POSTFIX,
				converter);
	}

}
