package com.alibaba.csp.sentinel.dashboard.rule.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.alibaba.csp.sentinel.dashboard.condition.DefaultDataSourceCondition;
import com.alibaba.csp.sentinel.dashboard.rule.FlowRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.FlowRulePublisher;
import com.alibaba.csp.sentinel.dashboard.rule.GatewayFlowRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.GatewayFlowRulePublisher;

@Configuration
@Conditional(DefaultDataSourceCondition.class)
public class ApiDataSourceAutoConfiguration {

	@Bean
	public FlowRuleProvider defaultFlowRuleProvider() {
		return new FlowRuleApiProvider();
	}

	@Bean
	public FlowRulePublisher defaultFlowRulePublisher() {
		return new FlowRuleApiPublisher();
	}

	@Bean
	public GatewayFlowRuleProvider defaultGatewayFlowRuleProvider() {
		return new GatewayFlowRuleApiProvider();
	}

	@Bean
	public GatewayFlowRulePublisher defaultGatewayFlowRulePublisher() {
		return new GatewayFlowRuleApiPublisher();
	}

	@Bean
	public ApiDefinitionApiProvider defaultApiDefinitionProvider() {
		return new ApiDefinitionApiProvider();
	}

	@Bean
	public ApiDefinitionApiPublisher defaultApiDefinitionPublisher() {
		return new ApiDefinitionApiPublisher();
	}
}
