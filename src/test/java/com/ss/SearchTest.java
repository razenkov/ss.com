package com.ss;

import com.ss.core.WebDriverTestBase;
import com.ss.pages.CarSearchPage;
import com.ss.pages.HomePage;
import com.ss.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SearchTest extends WebDriverTestBase{
    @Test
    public void addToFavoritesTest(){
        driver.get("https://www.ss.com");
        driver.manage().window().maximize();

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.changeLanguageToRu();
        //homePage.changeLanguageToLv();
        homePage.getCarDirectory();

        CarSearchPage carSearchPage = PageFactory.initElements(driver, CarSearchPage.class);
        carSearchPage.fillSearchRequest();
    }
}
