package com.alibaba.csp.sentinel.dashboard.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.alibaba.csp.sentinel.dashboard.condition.DefaultDataSourceCondition;
import com.alibaba.csp.sentinel.dashboard.rule.FlowRuleApiProvider;
import com.alibaba.csp.sentinel.dashboard.rule.FlowRuleApiPublisher;
import com.alibaba.csp.sentinel.dashboard.rule.FlowRuleDynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.FlowRuleDynamicRulePublisher;

@Configuration
@EnableConfigurationProperties(value = { DashboardDataSourceConfig.class })
public class DashboardDynamicDataSourceAutoConfiguration {

	@Bean
	@Conditional(DefaultDataSourceCondition.class)
	public FlowRuleDynamicRuleProvider defaultFlowRuleProvider() {
		return new FlowRuleApiProvider();
	}

	@Bean
	@Conditional(DefaultDataSourceCondition.class)
	public FlowRuleDynamicRulePublisher defaultFlowRulePublisher() {
		return new FlowRuleApiPublisher();
	}

}
