package com.alibaba.csp.sentinel.dashboard.rule.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.client.SentinelApiClient;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DegradeRulePublisher;

public class DegradeRuleApiPublisher implements DegradeRulePublisher{

	@Autowired
	private SentinelApiClient sentinelApiClient;
	
	@Override
	public void publish(String app, List<DegradeRuleEntity> rules) throws Exception {
		
	}

	@Override
	public boolean publish(String app, String ip, Integer port, List<DegradeRuleEntity> rules) throws Exception {
		
		return sentinelApiClient.setDegradeRuleOfMachine(app, ip, port, rules);
	}

}
