package com.ss.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    @FindBy(how = How.XPATH, using = "//input[@id='login_txt!!!!!!!!!!!!!!!!!!!!!!']")
    private WebElement emailField;

    @FindBy(how = How.XPATH, using = "//input[@id='pass_txt']")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//input[@type='submit']")
    private WebElement logimButton;

    @FindBy(how = How.XPATH, using = "//div[@class='alert_body']")
    private WebElement alertWindow;

    public boolean login(String email, String pass){
        emailField.sendKeys(email);
        passwordField.sendKeys(pass);
        logimButton.click();
        return alertWindow.isDisplayed();
    }
}
