package com.google.youtube.utils;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.util.Properties;

public class AppiumServer {

    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    private DesiredCapabilities cap;
    private int port;

    public void startServer(String ipAddress, int port) {
        System.out.println("Starting Appium server ...");
        this.port = port;
        cap = new DesiredCapabilities();
        cap.setCapability("noReset", "false");

        //Build the Appium service
        builder = new AppiumServiceBuilder()
                .withIPAddress(ipAddress)
                .usingPort(port)
                .withCapabilities(cap)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "error");

        //Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public void startServer() {
    	cap = new DesiredCapabilities();
		//Load the properties file 
		Properties prop = new Properties(); 
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("android.properties");
			prop.load(inputStream);
			
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.get("platform.name")); 
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.get("device.name")); 
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, prop.get("new.command.timeout")); 
			// cap.setCapability(MobileCapabilityType.APP, prop.get("application.path"));
			cap.setCapability("appPackage", prop.get("application.package"));
			cap.setCapability("appActivity", prop.get("application.activity")); 
			
			cap.setCapability(MobileCapabilityType.NO_RESET, prop.get("no.reset"));
			
			builder = new AppiumServiceBuilder()
					.withCapabilities(cap);

			
		}catch(Exception e) { 
			System.out.println("Cause is: " + e.getCause());
			System.out.println("Message: " + e.getMessage()); e.printStackTrace(); 
		} 
			

    }
    
    public void stopServer() {
        service.stop();
    }

    public boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public int getPort() {
        return port;
    }

}
