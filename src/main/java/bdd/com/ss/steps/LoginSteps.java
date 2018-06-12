package bdd.com.ss.steps;

import bdd.com.ss.pages.LoginPageCucumber;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginSteps {

    public static final String LOGIN_PAGE = "https://www.ss.com/ru/login/";

    private WebDriver driver;
    private LoginPageCucumber loginPage;

    @Given("I am on new project login page")
    public void openLoginPage() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.get(LOGIN_PAGE);
        System.out.println("@Given-call");
    }
    @When("I fill login \"([^\"]*)\" and pass \"([^\"]*)\"")
    public void tryLogin(String firstName, String lastName){
        loginPage = PageFactory.initElements(driver, LoginPageCucumber.class);
        loginPage.login(firstName, lastName);
        System.out.println("@When-call");

    }
    @Then("result is ([^\"]*)\"")
    public void checkForResult(String res){
        //Assert.assertEquals(loginPage.isAllertDisplay(), Boolean.parseBoolean(res));
        Assert.assertTrue(loginPage.isAllertDisplay());
        driver.close();
        System.out.println("@Then-call");

    }


}

