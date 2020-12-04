package com.alibaba.csp.sentinel.dashboard.rule.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.client.SentinelApiClient;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.ApiDefinitionEntity;
import com.alibaba.csp.sentinel.dashboard.rule.ApiDefinitionProvider;

public class ApiDefinitionApiProvider implements ApiDefinitionProvider {

	@Autowired
	private SentinelApiClient sentinelApiClient;

	@Override
	public List<ApiDefinitionEntity> getRules(String appName) throws Exception {

		return null;
	}

	@Override
	public List<ApiDefinitionEntity> getRules(String app, String ip, Integer port) throws Exception {

		return sentinelApiClient.fetchApis(app, ip, port).get();
	}

}
