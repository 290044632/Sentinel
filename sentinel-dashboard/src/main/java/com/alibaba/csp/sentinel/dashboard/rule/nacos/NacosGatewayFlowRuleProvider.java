package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.GatewayFlowRuleProvider;
import com.alibaba.csp.sentinel.datasource.Converter;

public class NacosGatewayFlowRuleProvider implements GatewayFlowRuleProvider {

	@Autowired
	private NacosClientProxy nacosClientProxy;

	@Autowired
	private Converter<String, List<GatewayFlowRuleEntity>> converter;

	@Override
	public List<GatewayFlowRuleEntity> getRules(String appName) throws Exception {

		return null;
	}

	@Override
	public List<GatewayFlowRuleEntity> getRules(String appName, String ip, Integer port) throws Exception {

		return this.nacosClientProxy.get(appName, ip, port, NacosConfigConstant.GATEWAY_FLOW_DATA_ID_POSTFIX,
				converter);
	}

}
