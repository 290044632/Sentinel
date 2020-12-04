package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.alibaba.csp.sentinel.dashboard.condition.NacosDataSourceCondition;
import com.alibaba.csp.sentinel.dashboard.config.DashboardDataSourceConfig;
import com.alibaba.csp.sentinel.dashboard.config.NacosDataSourceProperties;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigFactory;
import com.alibaba.nacos.api.config.ConfigService;

@Configuration
@Conditional(NacosDataSourceCondition.class)
public class NacosDataSourceAutoConfiguration {

	@Bean
	public FlowRuleNacosProvider nacosFlowRuleProvider() {
		return new FlowRuleNacosProvider();
	}

	@Bean
	public FlowRuleNacosPublisher nacosFlowRulePublisher() {
		return new FlowRuleNacosPublisher();
	}

	@Bean
	public GatewayFlowRuleNacosProvider nacosGatewayFlowRuleProvider() {
		return new GatewayFlowRuleNacosProvider();
	}

	@Bean
	public GatewayFlowRuleNacosPublisher nacosGatewayFlowRulePublisher() {
		return new GatewayFlowRuleNacosPublisher();
	}
	
	@Bean
	public NacosClientProxy  nacosClientProxy() {
		return new NacosClientProxy();
	}

	@Bean
	public ConfigService nacosConfigService(DashboardDataSourceConfig dataSourceConfig) throws Exception {
		NacosDataSourceProperties nacos = dataSourceConfig.getNacos();
		Properties properties = new Properties();
		properties.put(PropertyKeyConst.SERVER_ADDR, nacos.getServerAddr());
		String username = nacos.getUsername();
		if (null != username) {
			properties.put(PropertyKeyConst.USERNAME, username);
		}
		String password = nacos.getPassword();
		if (null != password) {
			properties.put(PropertyKeyConst.PASSWORD, password);
		}
		String namespace = nacos.getNamespace();
		if (null != namespace) {
			properties.put(PropertyKeyConst.NAMESPACE, namespace);
		}
		String endpoint = nacos.getEndpoint();
		if (null != endpoint) {
			properties.put(PropertyKeyConst.ENDPOINT, endpoint);
		}
		String accessKey = nacos.getAccessKey();
		if (null != accessKey) {
			properties.put(PropertyKeyConst.ACCESS_KEY, accessKey);
		}
		String secretKey = nacos.getSecretKey();
		if (null != secretKey) {
			properties.put(PropertyKeyConst.SECRET_KEY, secretKey);
		}
		return ConfigFactory.createConfigService(properties);
	}

}
