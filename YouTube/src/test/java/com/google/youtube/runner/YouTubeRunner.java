package com.google.youtube.runner;

import com.google.youtube.pages.BaseClass;
import com.google.youtube.pages.BaseTest;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = { "pretty", "json:target/reports/youtube.json", "html:target/reports/youtube"},
		monochrome = true, 
		features = "src/test/resources/features/YouTubeDemo.feature", 
		dryRun = false,  
		glue = "com.google.youtube.steps")

public class YouTubeRunner extends BaseClass	{
	
}

