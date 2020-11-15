package com.google.youtube.utils;


import com.google.youtube.pages.BaseTest;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot implements ITestListener {
    private static Logger logger = LogManager.getLogger(ScreenShot.class);

    public ScreenShot() {
        logger.info("Initializing - ScreenShot");
    }

    // This method will execute before starting of Test suite.
    public void onStart(ITestContext tr) { }

    // This method will execute, Once the Test suite is finished.
    public void onFinish(ITestContext tr) {

    }
    // This method will execute only when the test is pass.
    public void onTestSuccess(ITestResult tr) {
        captureScreenShot(tr, "pass");
    }

    // This method will execute only on the event of fail test.
    public void onTestFailure(ITestResult tr) {
        captureScreenShot(tr, "fail");
    }

    // This method will execute before the main test start (@Test)
    public void onTestStart(ITestResult tr) {

    }

    // This method will execute only if any of the main test(@Test) get skipped
    public void onTestSkipped(ITestResult tr) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
    }

    // Function to capture screenshot.
    public void captureScreenShot(ITestResult result, String status) {
        // AndroidDriver driver=ScreenshotOnPassFail.getDriver();
        String destDir = "";
        String passfailMethod = result.getMethod().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName();
        // To capture screenshot.
        File scrFile = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        // If status = fail then set folder name "screenshots/Failures"
        if (status.equalsIgnoreCase("fail")) {
            destDir = "screenshots/Failures";
        }
        // If status = pass then set folder name "screenshots/Success"
        else if (status.equalsIgnoreCase("pass")) {
            destDir = "screenshots/Success";
        }

        // To create folder to store screenshots
        new File(destDir).mkdirs();
        // Set file name with combination of test class name + date time.
        String destFile = passfailMethod + " - " + dateFormat.format(new Date()) + ".png";

        try {
            // Store file at destination folder location
            FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
        } catch (IOException e) {
            logger.error("Cause: " + e.getCause());
            logger.error("Error: " + e.getMessage());
        }
    }

    public static void embedScreenShotInReport(Scenario scenario, String scenarioName, WebDriver driver) {
        logger.debug("Finished running scenario - '" + scenarioName + "', Embedding screenshot in report");
        if (null != driver) {
            final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenarioName); // ... and embed it in the report.
        }
    }
}
