package com.google.youtube.utils;

import java.io.InputStream;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.google.common.io.Resources;

public class MobileProperties {

	private static final Logger logger = LogManager.getLogger(MobileProperties.class);
	
	private static Properties prop;
	
	private static Properties getProp() {
		if (prop == null) {
			prop = new Properties();
			InputStream input = null;
			try {
				input = Resources.getResource("./config/MobileConfig.properties").openStream();
				prop.load(input);
			} catch (Exception e) {
				logger.error("Error cause: " + e.getCause());
				logger.error("Error Message: " + e.getMessage());
			}
		}

		return prop;
	}

	public static String getSingleProp(String key) {
		return getProp().getProperty(key);
	}
	
	
    public static final String PLATFORM_NAME = getProp().getProperty("platform.name");
    public static final String PLATFORM_VERSION = getProp().getProperty("platform.version");
    public static final String DEVICE_NAME = getProp().getProperty("device.name");
    public static final String DEVICE_UDID = getProp().getProperty("platform.name");
    public static final String NO_RESET = getProp().getProperty("no.reset");
    public static final String AUTOMATION_INSTRUMENTATION = getProp().getProperty("automation.instrumentation");
    public static final String APPLICATION_PATH = getProp().getProperty("application.path");
    public static final String APPLICATION_PACKAGE = getProp().getProperty("application.package");
    public static final String APPLICATION_ACTIVITY = getProp().getProperty("application.activity");
    public static final String NEW_COMMAND_TIMEOUT = getProp().getProperty("new.command.timeout");
    public static final String DEVICE_READY_TIMEOUT = getProp().getProperty("device.ready.timeout");
    public static final String BROWSER_NAME = getProp().getProperty("browser.name");
    public static final String REMOTE_URL = getProp().getProperty("remote.url");
 
}
