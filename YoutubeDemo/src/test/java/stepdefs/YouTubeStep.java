package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.YouTubePage;

public class YouTubeStep {
	
  
  @Given("I open Youtube application")
  public void openYouTube() throws Throwable {
	  System.out.println("Hello World");
  }

  @When("I search and play {string} in {string}")
  public void searchAndPlay(String search, String resolution) throws Throwable {
	//  youTubePage.tabSearchBtn();
  }
  

  @Then("Youtube will play")
  public void playYouTube() throws Throwable {
	  
  }

}
