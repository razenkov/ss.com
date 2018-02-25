package com.ss;

import com.ss.core.WebDriverTestBase;
import com.ss.pages.CarSearchPage;
import com.ss.pages.HomePage;
import com.ss.pages.LoginPage;
import com.ss.pages.SearchPage;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends WebDriverTestBase{
    @Test
    public void addToFavoritesTest(){
        driver.get("https://www.ss.com");
        driver.manage().window().maximize();

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.changeLanguageToRu();
        homePage.getCarDirectory();

        CarSearchPage carSearchPage = PageFactory.initElements(driver, CarSearchPage.class);
        carSearchPage.fillSearchRequest();
    }

    @Test
    public void searchForItem() throws InterruptedException {
        driver.get("https://www.ss.com");
        driver.manage().window().maximize();

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.changeLanguageToRu();
        homePage.getSearchDirectory();

        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);

        searchPage.fillSearchForm(driver);

        Thread.sleep(3000);
        WebElement headLine = driver.findElement(By.xpath("//*[@id=\"head_line\"]/td[1]"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(headLine));

        Assert.assertTrue(searchPage.isSearchSuccessful());
    }
}
