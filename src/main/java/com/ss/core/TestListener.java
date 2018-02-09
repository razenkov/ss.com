package com.ss.core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class TestListener implements ITestListener {
    private WebDriver driver;
    @Override
    public void onTestStart(ITestResult iTestResult) {
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        driver = ((WebDriverTestBase) iTestResult.getInstance()).driver;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File f = new File("/Users/mymac/IdeaProjects/ss.com/FailedTestsScreens");
        try {
            FileUtils.cleanDirectory(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileUtils.copyFile(scrFile,
                    //new File("C:/Users/adm1n/Documents/KitCenter/Screenshots"
                      new File("FailedTestsScreens/" + iTestResult.getMethod().getMethodName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }
    @Override
    public void onStart(ITestContext iTestContext) {
    }
    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}
