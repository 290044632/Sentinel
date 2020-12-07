package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DegradeRuleProvider;
import com.alibaba.csp.sentinel.datasource.Converter;

public class DegradeRuleNacosProvider implements DegradeRuleProvider {

	@Autowired
	private NacosClientProxy nacosClientProxy;

	@Autowired
	private Converter<String, List<DegradeRuleEntity>> converter;

	@Override
	public List<DegradeRuleEntity> getRules(String appName) throws Exception {

		return null;
	}

	@Override
	public List<DegradeRuleEntity> getRules(String app, String ip, Integer port) throws Exception {

		return nacosClientProxy.get(app, ip, port, NacosConfigConstant.DEGRADE_RULE_DATA_ID_POSTFIX, converter);
	}

}
