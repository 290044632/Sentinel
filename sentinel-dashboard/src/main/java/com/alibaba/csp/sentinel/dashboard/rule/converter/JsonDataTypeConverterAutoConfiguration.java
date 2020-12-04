package com.alibaba.csp.sentinel.dashboard.rule.converter;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.alibaba.csp.sentinel.dashboard.condition.JsonDataTypeCondition;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
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

}
