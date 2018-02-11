package com.ss.pages;

import com.ss.core.WebDriverTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
    @FindBy(how = How.XPATH, using = "//span/*[@title='Latviski' or @title='По-русски']")
    private WebElement languageButton;

    @FindBy(how = How.XPATH, using = "//*[@id='mtd_97']")
    private WebElement carsDirectory;

    @FindBy(how = How.XPATH, using = "//*[@title='Искать объявления' or @title='Meklēt sludinājumus']")
    WebElement searchDirectory;

    @FindBy(how = How.XPATH, using = "//*[@href='/ru/new/']")
    WebElement newAdsLink;

    public void changeLanguageToRu(){
        if (languageButton.getAttribute("title").equals("По-русски")){
            languageButton.click();
        }
    }

    public void changeLanguageToLv(){
        if (languageButton.getAttribute("title").equals("Latviski")){
            languageButton.click();
        }
    }

    public void getCarDirectory(){
        carsDirectory.click();
    }

    public void getSearchDirectory(){
        searchDirectory.click();
    }

    public void getMyAdsDirectory(){
        newAdsLink.click();
    }
}
