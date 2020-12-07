package com.alibaba.csp.sentinel.dashboard.rule.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.client.SentinelApiClient;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DegradeRuleProvider;

public class DegradeRuleApiProvider implements DegradeRuleProvider {

	@Autowired
	private SentinelApiClient sentinelApiClient;

	@Override
	public List<DegradeRuleEntity> getRules(String appName) throws Exception {

		return null;
	}

	@Override
	public List<DegradeRuleEntity> getRules(String app, String ip, Integer port) throws Exception {

		return sentinelApiClient.fetchDegradeRuleOfMachine(app, ip, port);
	}

}
