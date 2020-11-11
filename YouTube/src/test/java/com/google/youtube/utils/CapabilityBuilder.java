package com.google.youtube.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class CapabilityBuilder {

	/*
	 * public DesiredCapabilities build(String platform) {
	 * 
	 * DesiredCapabilities capabilities = new DesiredCapabilities();
	 * 
	 * System.out.println("Setting capabilities for platform: " + platform);
	 * 
	 * // configuration.yaml under 'devices' key Map<String, Object> devicesMap =
	 * (Map<String, Object>) Config.instance().getYamlProperty("devices." + platform
	 * + ".capabilities"); if (devicesMap == null) { throw new
	 * RuntimeException("Cannot find devices entry in configuration.yaml. : " +
	 * platform); }
	 * 
	 * devicesMap.entrySet().stream().forEach(entry -> { String key =
	 * entry.getKey(); String value = entry.getValue().toString();
	 * System.out.println("Setting capability " + key + " = " + value);
	 * capabilities.setCapability(key, value); });
	 * 
	 * return capabilities; }
	 */
	public DesiredCapabilities build() {
		DesiredCapabilities cap = new DesiredCapabilities();

		try {
			//Load the properties file 
			Properties prop = new Properties(); 

			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("android.properties");
			prop.load(inputStream);


			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.get("platform.name")); 
			// caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.get("platform.version"));
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.get("device.name")); 
			// caps.setCapability(MobileCapabilityType.UDID,prop.get("device.udid"));
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, prop.get("new.command.timeout")); 
			// caps.setCapability(MobileCapabilityType.APP, prop.get("application.path"));
			cap.setCapability(MobileCapabilityType.NO_RESET, prop.get("no.reset"));
			cap.setCapability("appPackage", prop.get("application.package"));
			cap.setCapability("appActivity", prop.get("application.activity")); 
		}catch(Exception e) { 
			System.out.println("Cause is: " + e.getCause());
			System.out.println("Message: " + e.getMessage()); e.printStackTrace(); 
		} 

		return cap;
	}

}