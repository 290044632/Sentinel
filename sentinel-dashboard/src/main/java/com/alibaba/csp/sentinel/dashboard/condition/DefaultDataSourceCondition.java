package com.alibaba.csp.sentinel.dashboard.condition;

import com.alibaba.csp.sentinel.dashboard.config.DashboardDataSourceConfig;

public class DefaultDataSourceCondition extends DynamicDataSourceCondition {

	@Override
	protected boolean matches(DashboardDataSourceConfig config) {

		return config == null || config.getNacos() == null;
	}

}
