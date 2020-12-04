package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.GatewayFlowRulePublisher;
import com.alibaba.csp.sentinel.datasource.Converter;

public class GatewayFlowRuleNacosPublisher implements GatewayFlowRulePublisher {

	@Autowired
	private NacosClientProxy nacosClientProxy;

	@Autowired
	private Converter<List<GatewayFlowRuleEntity>, String> converter;

	@Override
	public void publish(String app, List<GatewayFlowRuleEntity> rules) throws Exception {

	}

	@Override
	public boolean publish(String app, String ip, Integer port, List<GatewayFlowRuleEntity> rules) throws Exception {

		return this.nacosClientProxy.publish(app, ip, port, rules, NacosConfigConstant.GATEWAY_FLOW_DATA_ID_POSTFIX,
				converter);
	}

}
