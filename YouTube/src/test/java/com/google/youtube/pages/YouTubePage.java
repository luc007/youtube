package com.google.youtube.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class YouTubePage extends BasePage {
	private static Logger logger = Logger.getLogger(YouTubePage.class);
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='YouTube']")
	private MobileElement youtubeLogo;
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Search']" )
	private MobileElement searchButton;
	
	@FindBy(id = "com.google.android.youtube:id/search_edit_text")
	private MobileElement searchText;
	
	@FindBy(id = "com.google.android.youtube:id/text")
	private MobileElement searchSelected;


    public YouTubePage(AppiumDriver<MobileElement> driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
    public boolean isYouTubeLogo() {
    	waitForElement(youtubeLogo);
    	waitForElement(searchButton);
    	return true;
    }
    
    public void searchText(String text) {
    	clickOnElement(searchButton);
    	setText(searchText, text);
    	clickOnElement(searchSelected);
    }
}
