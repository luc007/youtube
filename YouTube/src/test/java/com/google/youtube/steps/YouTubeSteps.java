package com.google.youtube.steps;

import com.google.youtube.pages.BaseTest;
import org.testng.Assert;

import com.google.youtube.pages.YouTubePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class YouTubeSteps {

	private YouTubePage youtubePage = new YouTubePage(BaseTest.getDriver(), BaseTest.getWait());

	@Given("the user opens a Youtube application")
	public void theUserOpensAYouTubeApplication() {
		Assert.assertTrue(youtubePage.isYouTubeLogo());
	}

	@When("the user search {string} and play")
	public void theUserSearchAndPlay(String searchText) {
		youtubePage.searchText(searchText);
		youtubePage.videoPlay(searchText);
	}

	@When("the user search {string} and save {string} to playlist")
	public void theUserSearchAndSaveToPlaylist(String searchText, String videoName) {
		youtubePage.searchText(searchText);
		youtubePage.saveToPlaylist(videoName);
	}

	@Then("Youtube video is playing")
	public void youtubeVideoPlay() {
		Assert.assertTrue(youtubePage.isVideoPlaying());
	}
}
