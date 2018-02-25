package com.ss;

        import com.ss.core.WebDriverTestBase;
        import com.ss.pages.ApiPage;
        import com.ss.pages.HomePage;
        import org.openqa.selenium.support.PageFactory;
        import org.testng.Assert;
        import org.testng.annotations.Test;

public class CooperationPageTest extends WebDriverTestBase{
    @Test
    public void getHTMLForMyPage() {
        driver.get("https://www.ss.com/ru/api/");
        driver.manage().window().maximize();

        ApiPage apiPage = PageFactory.initElements(driver, ApiPage.class);
        apiPage.fillForm();

        Assert.assertTrue(apiPage.isHTMLResultCorrect(apiPage.getHTMLGeneratorText()));
    }
}

