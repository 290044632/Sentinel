package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DegradeRulePublisher;
import com.alibaba.csp.sentinel.datasource.Converter;

public class DegradeRuleNacosPublisher implements DegradeRulePublisher {

	@Autowired
	private NacosClientProxy nacosClientProxy;

	@Autowired
	private Converter<List<DegradeRuleEntity>, String> converter;

	@Override
	public void publish(String app, List<DegradeRuleEntity> rules) throws Exception {

	}

	@Override
	public boolean publish(String app, String ip, Integer port, List<DegradeRuleEntity> rules) throws Exception {

		return nacosClientProxy.publish(app, ip, port, rules, NacosConfigConstant.DEGRADE_RULE_DATA_ID_POSTFIX,
				converter);
	}

}
