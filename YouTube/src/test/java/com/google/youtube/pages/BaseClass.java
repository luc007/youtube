package com.google.youtube.pages;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.google.youtube.utils.MobileProperties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class BaseClass extends AbstractTestNGCucumberTests {


	public static AppiumDriver<MobileElement> driver;
    private static WebDriverWait wait;

	@BeforeMethod(alwaysRun = true)
	@Parameters({"platform", "udid", "systemPort"})
	public void setup(String platform, String udid, String systemPort) throws Exception {
	    String[] platformInfo = platform.split(" ");
	    
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, MobileProperties.AUTOMATION_NAME);
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformInfo[0]);
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo[1]);
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, MobileProperties.DEVICE_NAME);
	    capabilities.setCapability(MobileCapabilityType.UDID, udid);
	    capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
	  //  capabilities.setCapability(MobileCapabilityType.APP, MobileProperties.APPLICATION_PATH);
	    capabilities.setCapability(MobileCapabilityType.ORIENTATION, MobileProperties.DEVICE_ORIENTATION);
	    capabilities.setCapability(MobileCapabilityType.NO_RESET, MobileProperties.NO_RESET);
	    capabilities.setCapability("appPackage", MobileProperties.APPLICATION_PACKAGE);
	    capabilities.setCapability("appActivity",MobileProperties.APPLICATION_ACTIVITY); 
	    

	    URL url = new URL(MobileProperties.APPIUM_SERVER_URL);

	    driver = new AppiumDriver<MobileElement>(url, capabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    wait = new WebDriverWait(driver, 20);
	}	

	
    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }    
    
	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception{
		if(driver != null) {
			driver.quit(); 
		}
	}

}
