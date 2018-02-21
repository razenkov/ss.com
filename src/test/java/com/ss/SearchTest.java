package com.ss;

import com.ss.core.WebDriverTestBase;
import com.ss.pages.CarSearchPage;
import com.ss.pages.HomePage;
import com.ss.pages.LoginPage;
import com.ss.pages.SearchPage;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends WebDriverTestBase{
    @Test
    @Step("!!!HERE IM TRYING TO ADD @STEP -> {0} <- TO REPORT.")
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
    public void searchForItem(){
        driver.get("https://www.ss.com");
        driver.manage().window().maximize();

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.changeLanguageToRu();
        homePage.getSearchDirectory();

        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
        searchPage.fillSearchForm(driver);

        Assert.assertTrue(searchPage.isSearchSuccessful());
    }
}
