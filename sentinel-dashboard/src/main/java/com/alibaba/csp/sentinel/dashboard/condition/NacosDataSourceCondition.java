package com.alibaba.csp.sentinel.dashboard.condition;

import com.alibaba.csp.sentinel.dashboard.config.DashboardDataSourceConfig;

public class NacosDataSourceCondition extends DynamicDataSourceCondition {

	@Override
	protected boolean matches(DashboardDataSourceConfig config) {

		return null != config && config.getNacos() != null;
	}

}
