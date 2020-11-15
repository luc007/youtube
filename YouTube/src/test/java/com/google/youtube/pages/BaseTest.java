package com.google.youtube.pages;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.google.youtube.utils.ScreenShot;
import io.cucumber.java8.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.google.youtube.utils.MobileProperties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@Listeners({ScreenShot.class })
public class BaseTest extends AbstractTestNGCucumberTests {

	private static Logger logger = LogManager.getLogger(BaseTest.class);

	public static AppiumDriver<MobileElement> driver;
	private static WebDriverWait wait;

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}


	@BeforeTest(alwaysRun = true)
	@Parameters({"platform", "udid", "systemPort", "tags"})
	public void createDriverOptions(String platform, String udid, String systemPort, String tags)  throws Exception{
		logger.info("Starting ... ");

		String[] platformInfo = platform.split(" ");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, MobileProperties.AUTOMATION_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformInfo[0]);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo[1]);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, MobileProperties.DEVICE_NAME);
		capabilities.setCapability(MobileCapabilityType.UDID, udid);
		capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
		capabilities.setCapability(MobileCapabilityType.ORIENTATION, MobileProperties.DEVICE_ORIENTATION);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, MobileProperties.NO_RESET);
		capabilities.setCapability("appPackage", MobileProperties.APPLICATION_PACKAGE);
		capabilities.setCapability("appActivity",MobileProperties.APPLICATION_ACTIVITY);

		URL url = new URL(MobileProperties.APPIUM_SERVER_URL);
		driver = new AppiumDriver<MobileElement>(url, capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);

		System.setProperty("cucumber.filter.tags", tags);
	//	logger.log("Capabilities Configured Successfully");
	}

/*
	@Before
	public void setup(Scenario scenario) {
		logger.info("Running scenario: " + scenario.getName());
	}
*/

	public static AppiumDriver<MobileElement> getDriver() {
		return driver;
	}

	public static WebDriverWait getWait() {
		return wait;
	}



	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception{
		logger.info("Closing YouTube");
		if(driver != null) {
			driver.quit();
		}
	}

}
