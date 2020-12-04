package com.alibaba.csp.sentinel.dashboard.rule.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.client.SentinelApiClient;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.GatewayFlowRuleProvider;

public class GatewayFlowRuleApiProvider implements GatewayFlowRuleProvider {

	@Autowired
	private SentinelApiClient sentinelApiClient;

	@Override
	public List<GatewayFlowRuleEntity> getRules(String appName) throws Exception {
		return null;
	}

	@Override
	public List<GatewayFlowRuleEntity> getRules(String appName, String ip, Integer port) throws Exception {
		return sentinelApiClient.fetchGatewayFlowRules(appName, ip, port).get();
	}

}
