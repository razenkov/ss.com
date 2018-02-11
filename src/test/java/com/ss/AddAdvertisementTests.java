package com.ss;

import com.ss.core.WebDriverTestBase;
import com.ss.pages.HomePage;
import com.ss.pages.NewAdPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddAdvertisementTests extends WebDriverTestBase{
    @Test
    public void addNewAdvertisement(){
        driver.get("https://www.ss.com");
        driver.manage().window().maximize();
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.changeLanguageToRu();
        homePage.getMyAdsDirectory();

        NewAdPage newAdPage = PageFactory.initElements(driver, NewAdPage.class);
        newAdPage.activateAnimalsRadioBtn();
        newAdPage.activateDogsRadioBtn();


        Select dogsList = new Select(driver.findElement(By.xpath(newAdPage.getDogsListLocator())));
        dogsList.selectByValue("13892");
        newAdPage.pressContinueBtn();

        Assert.assertTrue(newAdPage.isinfoMessage());
    }

}
