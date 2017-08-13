package com.roof.guardmonitor.extension;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.roof.guardmonitor.Status;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.AntPathMatcher;

public class MonitorStatusManager implements InitializingBean {
	private static Logger logger = Logger.getLogger(MonitorStatusManager.class);
	private String filePath = null;
	private static final String STOPPED_KEY = "monitor.stopped";
	private static final String PASSWORD_KEY = "monitor.password";
	private String[] stoppedPatterns = null;
	private AntPathMatcher antPathMatcher = new AntPathMatcher();
	private Long updateInterval = 60000L;
	private Map<String, String> statusMap = new HashMap<String, String>();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String password = null;

	public void afterPropertiesSet() throws Exception {
		loadConfig();
	}

	public MonitorStatusManager() {
		this.statusMap.put("status", Status.STOPPED.toString());
		this.statusMap.put("lastUpdate", this.sdf.format(new Date()));
		this.statusMap.put("updateInterval", this.updateInterval.toString());
	}

	/* Error */
	public void loadConfig() {
		FileSystemResource resource = new FileSystemResource(filePath);
		Properties properties = new Properties();
		try {
			properties.load(resource.getInputStream());
			password = properties.getProperty(PASSWORD_KEY);
			String str = properties.getProperty(STOPPED_KEY);
			stoppedPatterns = str.split(",");
		} catch (IOException e) {
			e.printStackTrace();
		};
	}

	public boolean isStopped(String... paths) {
		String[] arrayOfString1;
		int j = (arrayOfString1 = this.stoppedPatterns).length;
		for (int i = 0; i < j; i++) {
			String pattern = arrayOfString1[i];
			String[] arrayOfString2;
			int m = (arrayOfString2 = paths).length;
			for (int k = 0; k < m; k++) {
				String path = arrayOfString2[k];
				if ((path != null) && (this.antPathMatcher.match(pattern, path))) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean validPassword(String password) {
		if (this.password.equals(password)) {
			return true;
		}
		return false;
	}

	public Map<String, String> getStoppedStatusMap() {
		return this.statusMap;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
