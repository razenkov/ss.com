package com.ss;

import com.ss.core.WebDriverTestBase;
import com.ss.pages.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends WebDriverTestBase{
    @DataProvider(name = "loginCredentials")


    public Object[][] userCredentials(){
        return new Object[][]{
                {"email", "password"},
                {"",""},
                {"*@*","123456"}
        };
    }
    @Test(dataProvider = "loginCredentials")
    @Step("!!!HERE IM TRYING TO ADD @STEP -> {email} <- TO REPORT.")
    public void loginTest(String email, String pass){
        driver.get("https://www.ss.com/ru/login/");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        Assert.assertTrue(loginPage.login(email, pass));
    }
}
