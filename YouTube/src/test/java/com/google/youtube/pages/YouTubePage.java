package com.google.youtube.pages;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
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


	@FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,'Minions 2015 - Memorable Moments')]")
	private MobileElement miniosVideo;

	
	@FindBy(xpath = "//android.widget.FrameLayout[contains(@content-desc,'Video player')]")
	private MobileElement videoPlayer;

	
	// Save to Playlist
	@FindBy(xpath = "(//android.widget.ImageView[@content-desc='Action menu'])[1]")
	private MobileElement actionMenu;
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc='Save to playlist']")
	private MobileElement saveToPlaylist;
	
	@FindBy(id = "com.google.android.youtube:id/add_to_playlist_bottom_sheet_close_button")
	private MobileElement doneButton;
	
	// Search Filter
	@FindBy(id = "com.google.android.youtube:id/menu_filter_results")
	private MobileElement searchFilter;

	@FindBy(id = "com.google.android.youtube:id/spinner_0")
	private MobileElement sortBy;

	@FindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]")
	private MobileElement sortByViewCount;
	
	@FindBy(id = "com.google.android.youtube:id/button")
	private MobileElement addNewPlaylistButton;
	
	@FindBy(id = "com.google.android.youtube:id/name")
	private MobileElement newPlaylistText;
	
	@FindBy(xpath = "//android.widget.Button[@text='CREATE']")
	private MobileElement playlistCreateButton;
	
	@FindBy(xpath = "//android.widget.Button[@content-desc='Library']/android.widget.ImageView")
	private MobileElement libraryButton;
	
	@FindBys(@FindBy(xpath = "//android.widget.TextView[contains('@resource-id', 'title')]"))
	private List<MobileElement> getPlaylistTitle;
	
	
	@FindBy(xpath="android.widget.TextView")
	private MobileElement homeButton;
	
	
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
    
    public void videoPlay() {
    	clickOnElement(miniosVideo);
    	clickOnElement(videoPlayer);
    }
    
    public boolean isVideoPlaying() {
    	return waitForElement(videoPlayer);
    }
    
    public void saveToPlaylist(String text) {
    	clickOnElement(actionMenu);
    	clickOnElement(saveToPlaylist);
    	clickOnElement(addNewPlaylistButton);
    	setText(newPlaylistText, text);
    	clickOnElement(playlistCreateButton);
    }
    

}
