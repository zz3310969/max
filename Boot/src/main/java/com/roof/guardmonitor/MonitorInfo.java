package com.roof.guardmonitor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.roof.guardmonitor.extension.MonitorStatusManager;
import com.roof.guardmonitor.impl.AndStatusMonitorListener;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
public class MonitorInfo {
	private Map<String, String> statusMap;
	private ObjectMapper mapper = new ObjectMapper();
	private AndStatusMonitorListener statusMonitorListener;
	private MonitorStatusManager monitorStatusManager;

	@RequestMapping({ "/status" })
	@ResponseBody
	public String getStatus() throws JsonProcessingException {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		String addr = request.getRemoteAddr();
		String host = request.getRemoteHost();
		String xForwardedFor = request.getHeader("X-Forwarded-For");
		String xClientIP = request.getHeader("X-ClientIP");
		if (this.monitorStatusManager.isStopped(new String[] { addr, host, xForwardedFor, xClientIP })) {
			return this.mapper.writeValueAsString(this.monitorStatusManager.getStoppedStatusMap());
		}
		return this.mapper.writeValueAsString(this.statusMap);
	}

	@RequestMapping({ "/running/{status}/{password}" })
	@ResponseBody
	public String running(@PathVariable boolean status, @PathVariable String password) {
		if (!this.monitorStatusManager.validPassword(password)) {
			return "wrong password";
		}
		this.statusMonitorListener.setRunning(status);
		return "success";
	}

	@RequestMapping({ "/rc/{password}" })
	@ResponseBody
	public String reloadConifg(@PathVariable String password) {
		if (!this.monitorStatusManager.validPassword(password)) {
			return "wrong password";
		}
		this.monitorStatusManager.loadConfig();
		return "success";
	}

	public Map<String, String> getStatusMap() {
		return this.statusMap;
	}

	@Resource(name = "statusMap")
	public void setStatusMap(Map<String, String> statusMap) {
		this.statusMap = statusMap;
	}

	@Resource(name = "andStatusMonitorListener")
	public void setStatusMonitorListener(AndStatusMonitorListener statusMonitorListener) {
		this.statusMonitorListener = statusMonitorListener;
	}

	@Resource
	public void setMonitorStatusManager(MonitorStatusManager monitorStatusManager) {
		this.monitorStatusManager = monitorStatusManager;
	}
}
