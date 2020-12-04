package com.alibaba.csp.sentinel.dashboard.condition;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.alibaba.csp.sentinel.dashboard.config.DashboardDataSourceConfig;

public abstract class DynamicDataSourceCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment environment = context.getEnvironment();
		Binder binder = Binder.get(environment);
		BindResult<DashboardDataSourceConfig> bind = binder.bind(DashboardDataSourceConfig.DASHBOARD_DATASOURCE_PREFIX,
				DashboardDataSourceConfig.class);
		return this.matches(bind.orElse(null));
	}

	protected abstract boolean matches(DashboardDataSourceConfig config);
}
