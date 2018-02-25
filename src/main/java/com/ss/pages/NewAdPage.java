package com.ss.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewAdPage {
    @FindBy(how = How.XPATH, using = "//*[@id='opt_cid_0-4']")
    WebElement animalsRadioBtn;

    @FindBy(how = How.XPATH, using = "//*[@id='opt_cid_1-300']")
    WebElement dogsRadioBtn;

    @FindBy(how = How.XPATH, using = "//*[@class='b new_ad_select']")
    WebElement continueBtn;

    @FindBy(how = How.XPATH, using = "//*[@href='https://www.ss.com/ru/registration/']")
    WebElement infomessage;


    String dogsList = "//*[@name='cid_2']";

    public void activateAnimalsRadioBtn(){
        animalsRadioBtn.click();
    }

    public void activateDogsRadioBtn(){
        dogsRadioBtn.click();
    }

    public String getDogsListLocator(){
        return dogsList;
    }

    public void pressContinueBtn(){
        continueBtn.click();
    }

    public boolean isinfoMessage(){
        return infomessage.isDisplayed(); //infomessage.getText().contains("Укажите данные для входа, либо ");
    }
}
