package com.ss.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import java.util.concurrent.TimeUnit;

@Listeners({com.ss.core.TestListener.class})
public class WebDriverTestBase {

    protected WebDriver driver;
    protected WebDriverManager manager;
    //private String browser = System.getProperty("browser", "CHROME");
    public String browser = "firefox";
    @BeforeClass
    protected void setup() {
        switch (browser) {
            case "firefox": {
                manager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--disable-notifications");
                driver = new FirefoxDriver(options);
                break;
            }
            case "chrome": {
                manager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                break;
            }
            case "edge": {
                manager.edgedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                break;
            }
        }
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(
                PropertiesCache.getProperty("wait.page")), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(
                PropertiesCache.getProperty("wait.implicit")), TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(Long.parseLong(
                PropertiesCache.getProperty("wait.script")), TimeUnit.SECONDS);
    }

    @AfterClass
    protected void tearDown() {
        driver.quit();
    }
}
