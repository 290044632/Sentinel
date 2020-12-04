package com.alibaba.csp.sentinel.dashboard.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.alibaba.csp.sentinel.dashboard.condition.DefaultDataSourceCondition;
import com.alibaba.csp.sentinel.dashboard.rule.FlowRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.FlowRulePublisher;
import com.alibaba.csp.sentinel.dashboard.rule.GatewayFlowRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.GatewayFlowRulePublisher;
import com.alibaba.csp.sentinel.dashboard.rule.api.FlowRuleApiProvider;
import com.alibaba.csp.sentinel.dashboard.rule.api.FlowRuleApiPublisher;
import com.alibaba.csp.sentinel.dashboard.rule.api.GatewayFlowRuleApiProvider;
import com.alibaba.csp.sentinel.dashboard.rule.api.GatewayFlowRuleApiPublisher;

@Configuration
@EnableConfigurationProperties(value = { DashboardDataSourceConfig.class })
public class DashboardDynamicDataSourceAutoConfiguration {

	@Bean
	@Conditional(DefaultDataSourceCondition.class)
	public FlowRuleProvider defaultFlowRuleProvider() {
		return new FlowRuleApiProvider();
	}

	@Bean
	@Conditional(DefaultDataSourceCondition.class)
	public FlowRulePublisher defaultFlowRulePublisher() {
		return new FlowRuleApiPublisher();
	}

	@Bean
	@Conditional(DefaultDataSourceCondition.class)
	public GatewayFlowRuleProvider defaultGatewayFlowRuleProvider() {
		return new GatewayFlowRuleApiProvider();
	}

	@Bean
	@Conditional(DefaultDataSourceCondition.class)
	public GatewayFlowRulePublisher defaultGatewayFlowRulePublisher() {
		return new GatewayFlowRuleApiPublisher();
	}
}
