package com.alibaba.csp.sentinel.dashboard.rule.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.client.SentinelApiClient;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.ApiDefinitionEntity;
import com.alibaba.csp.sentinel.dashboard.rule.ApiDefinitionPublisher;

public class ApiDefinitionApiPublisher implements ApiDefinitionPublisher {

	@Autowired
	private SentinelApiClient sentinelApiClient;

	@Override
	public void publish(String app, List<ApiDefinitionEntity> rules) throws Exception {
	}

	@Override
	public boolean publish(String app, String ip, Integer port, List<ApiDefinitionEntity> rules) throws Exception {

		return sentinelApiClient.modifyApis(app, ip, port, rules);
	}

}
