package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.ApiDefinitionEntity;
import com.alibaba.csp.sentinel.dashboard.rule.ApiDefinitionProvider;
import com.alibaba.csp.sentinel.datasource.Converter;

public class ApiDefinitionNacosProvider implements ApiDefinitionProvider {

	@Autowired
	private NacosClientProxy nacosClientProxy;

	@Autowired
	private Converter<String, List<ApiDefinitionEntity>> converter;

	@Override
	public List<ApiDefinitionEntity> getRules(String appName) throws Exception {

		return null;
	}

	@Override
	public List<ApiDefinitionEntity> getRules(String app, String ip, Integer port) throws Exception {

		return this.nacosClientProxy.get(app, ip, port, NacosConfigConstant.GATEWAY_API_DATA_ID_POSTFIX, converter);
	}

}
