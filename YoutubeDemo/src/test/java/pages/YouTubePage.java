package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;



public class YouTubePage extends BaseClass {

	public YouTubePage( AppiumDriver<MobileElement> driver ) {
		super(driver);
	}
	
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Search']" )
	private MobileElement searchButton;
	
	
	/*
	 * public YouTube(AppiumDriver<MobileElement> driver) {
	 * PageFactory.initElements(new AppiumFieldDecorator(driver), this); }
	 */	
	public void tabSearchBtn() {
		searchButton.click();
	}
}
