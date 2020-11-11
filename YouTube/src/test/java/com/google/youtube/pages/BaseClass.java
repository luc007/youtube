package com.google.youtube.pages;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.youtube.utils.MobileProperties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class BaseClass extends AbstractTestNGCucumberTests {


	public static AppiumDriver<MobileElement> driver;
    private static WebDriverWait wait;


	@BeforeMethod(alwaysRun = true)
	public void setUp() {

		try {
			DesiredCapabilities cap = new DesiredCapabilities();

			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobileProperties.PLATFORM_NAME ); 
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, MobileProperties.PLATFORM_VERSION);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, MobileProperties.DEVICE_NAME); 
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, MobileProperties.NEW_COMMAND_TIMEOUT); 
			cap.setCapability(MobileCapabilityType.NO_RESET, MobileProperties.NO_RESET);
			
			if(MobileProperties.PLATFORM_NAME.contains("Android")) {
			//	cap.setCapability(MobileCapabilityType.APP, MobileProperties.APPLICATION_PATH);
				cap.setCapability("appPackage", MobileProperties.APPLICATION_PACKAGE);
				cap.setCapability("appActivity",MobileProperties.APPLICATION_ACTIVITY); 
			//	cap.setCapability(MobileCapabilityType.BROWSER_NAME,MobileProperties.BROWSER_NAME );
			} else { // iOS
				//caps.setCapability(MobileCapabilityType.UUID, MobileProperties.);
				
			}

			URL url = new URL((String) MobileProperties.REMOTE_URL);
	
			driver = new AppiumDriver<MobileElement>(url, cap);
			wait = new WebDriverWait(driver, 20);
		} catch (Exception ex) {
			
		}
			
	}

	
    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit(); 
	}

}
