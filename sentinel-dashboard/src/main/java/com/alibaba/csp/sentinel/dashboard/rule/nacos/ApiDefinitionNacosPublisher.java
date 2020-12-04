package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.ApiDefinitionEntity;
import com.alibaba.csp.sentinel.dashboard.rule.ApiDefinitionProvider;
import com.alibaba.csp.sentinel.dashboard.rule.ApiDefinitionPublisher;
import com.alibaba.csp.sentinel.datasource.Converter;

public class ApiDefinitionNacosPublisher implements ApiDefinitionPublisher {

	@Autowired
	private NacosClientProxy nacosClientProxy;

	@Autowired
	private Converter<List<ApiDefinitionEntity>, String> converter;

	@Override
	public void publish(String app, List<ApiDefinitionEntity> rules) throws Exception {

	}

	@Override
	public boolean publish(String app, String ip, Integer port, List<ApiDefinitionEntity> rules) throws Exception {
		return nacosClientProxy.publish(app, ip, port, rules, NacosConfigConstant.GATEWAY_API_DATA_ID_POSTFIX,
				converter);
	}

}
