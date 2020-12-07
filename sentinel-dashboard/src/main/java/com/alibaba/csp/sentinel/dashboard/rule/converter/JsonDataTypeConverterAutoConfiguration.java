package com.alibaba.csp.sentinel.dashboard.rule.converter;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.alibaba.csp.sentinel.dashboard.condition.JsonDataTypeCondition;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.ApiDefinitionEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.fastjson.JSON;

@Configuration
@Conditional(JsonDataTypeCondition.class)
public class JsonDataTypeConverterAutoConfiguration {

	@Bean
	public Converter<List<FlowRuleEntity>, String> flowRuleEntityEncoder() {
		return JSON::toJSONString;
	}

	@Bean
	public Converter<String, List<FlowRuleEntity>> flowRuleEntityDecoder() {
		return s -> JSON.parseArray(s, FlowRuleEntity.class);
	}

	@Bean
	public Converter<List<GatewayFlowRuleEntity>, String> gatewayFlowRuleEntityEncoder() {
		return JSON::toJSONString;
	}

	@Bean
	public Converter<String, List<GatewayFlowRuleEntity>> gatewayFlowRuleEntityDecoder() {
		return s -> JSON.parseArray(s, GatewayFlowRuleEntity.class);
	}

	@Bean
	public Converter<List<ApiDefinitionEntity>, String> apiDefinitionEntityEncoder() {
		return JSON::toJSONString;
	}

	@Bean
	public Converter<String, List<ApiDefinitionEntity>> apiDefinitionEntityDecoder() {
		return s -> JSON.parseArray(s, ApiDefinitionEntity.class);
	}

	@Bean
	public Converter<List<DegradeRuleEntity>, String> degradeRuleEntityEncoder() {
		return JSON::toJSONString;
	}

	@Bean
	public Converter<String, List<DegradeRuleEntity>> degradeRuleEntityDecoder() {
		return s -> JSON.parseArray(s, DegradeRuleEntity.class);
	}

	@Bean
	public Converter<List<SystemRuleEntity>, String> systemRuleEntityEncoder() {
		return JSON::toJSONString;
	}

	@Bean
	public Converter<String, List<SystemRuleEntity>> systemRuleEntityDecoder() {
		return s -> JSON.parseArray(s, SystemRuleEntity.class);
	}

}
