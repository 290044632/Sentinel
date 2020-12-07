package com.alibaba.csp.sentinel.dashboard.rule.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.client.SentinelApiClient;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.SystemRulePublisher;

public class SystemRuleApiPublisher implements SystemRulePublisher {

	@Autowired
	private SentinelApiClient sentinelApiClient;

	@Override
	public void publish(String app, List<SystemRuleEntity> rules) throws Exception {
	}

	@Override
	public boolean publish(String app, String ip, Integer port, List<SystemRuleEntity> rules) throws Exception {

		return this.sentinelApiClient.setSystemRuleOfMachine(app, ip, port, rules);
	}

}
