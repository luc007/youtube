package com.google.youtube.runner;


import com.google.youtube.pages.BaseTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/sanity/Sanity.feature",
		glue = "com.google.youtube.steps",
		plugin = {
				"pretty",
				"html:target/cucumber",
				"json:target/cucumber.json"
		},
		monochrome = true,
		dryRun = false
)

public class SanityRunner extends BaseTest {

}

