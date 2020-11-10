package tests;

import static java.time.Duration.ofSeconds;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {


	//static AppiumDriver<MobileElement> driver;
	protected static AppiumDriver<MobileElement> driver;

	@BeforeTest public void setup() {

		//Load the properties file 
		Properties prop = new Properties(); 
		try {
			InputStream inputStream =
					getClass().getClassLoader().getResourceAsStream("config.properties");
			prop.load(inputStream);
	
			DesiredCapabilities caps = new DesiredCapabilities();
	
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.get("platform.name")); 
			// caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.get("platform.version"));
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, prop.get("device.name")); 
			// caps.setCapability(MobileCapabilityType.UDID,prop.get("device.udid"));
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, prop.get("new.command.timeout")); 
			// caps.setCapability(MobileCapabilityType.APP, prop.get("application.path"));
			caps.setCapability(MobileCapabilityType.NO_RESET, prop.get("no.reset"));
			caps.setCapability("appPackage", prop.get("application.package"));
			caps.setCapability("appActivity", prop.get("application.activity")); 
			// caps.setCapability(MobileCapabilityType.BROWSER_NAME,prop.get("browser.name") );
	
			URL url = new URL((String) prop.get("remote.url"));
	
			driver = new AppiumDriver<MobileElement>(url, caps);
	
			//This time out is set because test can be run on slow Android SDK emulator
	        PageFactory.initElements(new AppiumFieldDecorator(driver, ofSeconds(5)), this);
	        
		}catch(Exception e) { 
			System.out.println("Cause is: " + e.getCause());
			System.out.println("Message: " + e.getMessage()); e.printStackTrace(); 
		} 
	}


	@AfterTest public void teardown() {
		driver.close(); 
		driver.quit(); 
	}

}
