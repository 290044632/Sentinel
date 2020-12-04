package com.alibaba.csp.sentinel.dashboard.rule.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.client.SentinelApiClient;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.GatewayFlowRulePublisher;

public class GatewayFlowRuleApiPublisher implements GatewayFlowRulePublisher {

	@Autowired
	private SentinelApiClient sentinelApiClient;

	@Override
	public void publish(String app, List<GatewayFlowRuleEntity> rules) throws Exception {

	}

	@Override
	public boolean publish(String app, String ip, Integer port, List<GatewayFlowRuleEntity> rules) throws Exception{
		return sentinelApiClient.modifyGatewayFlowRules(app, ip, port, rules);
	}

}
