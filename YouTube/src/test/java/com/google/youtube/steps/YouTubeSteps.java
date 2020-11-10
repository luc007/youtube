package com.google.youtube.steps;

import org.testng.Assert;

import com.google.youtube.pages.BaseClass;
import com.google.youtube.pages.YouTubePage;
import com.google.youtube.utils.AppManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class YouTubeSteps {

//	private YouTubePage youtubePage = new YouTubePage(AppManager.getDriver(), AppManager.getWait());
	private YouTubePage youtubePage = new YouTubePage(BaseClass.getDriver(), BaseClass.getWait());
	
	@Given("the user opens a Youtube application")
	public void theUserOpensAYouTubeApplication() {
		Assert.assertTrue(youtubePage.isYouTubeLogo());
	}
	
	@When("the user search {string} and play in {string}")
	public void theUserSearchAndPlay(String searchText, String resolution) {
		youtubePage.searchText(searchText);
	}
}
