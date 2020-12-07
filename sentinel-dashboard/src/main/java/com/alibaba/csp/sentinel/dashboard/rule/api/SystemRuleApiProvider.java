package com.alibaba.csp.sentinel.dashboard.rule.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.client.SentinelApiClient;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.SystemRuleProvider;

public class SystemRuleApiProvider implements SystemRuleProvider {

	@Autowired
	private SentinelApiClient sentinelApiClient;

	@Override
	public List<SystemRuleEntity> getRules(String appName) throws Exception {

		return null;
	}

	@Override
	public List<SystemRuleEntity> getRules(String app, String ip, Integer port) throws Exception {
		return sentinelApiClient.fetchSystemRuleOfMachine(app, ip, port);
	}

}
