package com.google.youtube.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

public class YouTubePage extends BasePage {
	private static Logger logger = Logger.getLogger(YouTubePage.class);

	@AndroidFindBy(accessibility="YouTube")
	private MobileElement youtubeLogo;

	@AndroidFindBy(accessibility="Search")
	private MobileElement searchButton;

	@AndroidFindBy(id = "com.google.android.youtube:id/search_edit_text")
	private MobileElement searchText;

	@AndroidFindBy(id = "com.google.android.youtube:id/text")
	private MobileElement searchSelected;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(translate(@content-desc,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'minions mini')]")
	private MobileElement selectVideo;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[contains(@content-desc,'Video player')]")
	private MobileElement videoPlayer;


	// Save to Playlist
	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc='Action menu'])[1]")
	private MobileElement actionMenu;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Save to playlist']")
	private MobileElement saveToPlaylist;

	@AndroidFindBy(id = "com.google.android.youtube:id/add_to_playlist_bottom_sheet_close_button")
	private MobileElement doneButton;

	// Search Filter
	@AndroidFindBy(id = "com.google.android.youtube:id/menu_filter_results")
	private MobileElement searchFilter;

	@AndroidFindBy(id = "com.google.android.youtube:id/spinner_0")
	private MobileElement sortBy;

	@AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]")
	private MobileElement sortByViewCount;

	@AndroidFindBy(id = "com.google.android.youtube:id/button")
	private MobileElement addNewPlaylistButton;

	@AndroidFindBy(id = "com.google.android.youtube:id/name")
	private MobileElement newPlaylistText;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='CREATE']")
	private MobileElement playlistCreateButton;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Library']/android.widget.ImageView")
	private MobileElement libraryButton;

	@AndroidFindBy(xpath="android.widget.TextView")
	private MobileElement homeButton;

	final String xpathContent = "//*[@content-desc='%s']";
	final String xpathAccessibility = "//*[@content-desc='%s']";
	final String xpathContainsText = "//*[contains(@text, '%s')]";
	final String xpathContainsContent = "//*[contains(@content-desc, '%s')]";

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

	public void videoPlay(String text) {
		clickOnElement(selectVideo);
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
