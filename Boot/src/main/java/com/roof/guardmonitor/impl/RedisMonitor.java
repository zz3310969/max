package com.roof.guardmonitor.impl;

import com.roof.guardmonitor.MonitorContext;
import com.roof.guardmonitor.Status;
import com.roof.guardmonitor.AbstractMonitor;
import org.springframework.data.redis.support.collections.DefaultRedisMap;

public class RedisMonitor extends AbstractMonitor {
	private static final String GUARD_MONITOR_TEST_KEY = "guard_monitor_test_key";
	private DefaultRedisMap<String, String> redisMap;

	public DefaultRedisMap<String, String> getRedisMap() {
		return redisMap;
	}

	public void setRedisMap(DefaultRedisMap<String, String> redisMap) {
		this.redisMap = redisMap;
	}

	@Override
	protected void doInTry(MonitorContext monitorContext) {
		redisMap.put(GUARD_MONITOR_TEST_KEY, "1");
		redisMap.remove(GUARD_MONITOR_TEST_KEY);
		monitorContext.setStatus(Status.RUNNING);
	}

	@Override
	protected void doFinally() {
	}

}
