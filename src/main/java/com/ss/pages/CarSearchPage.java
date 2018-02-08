package com.ss.pages;

import com.ss.core.PropertiesCache;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;
import java.util.Random;

public class CarSearchPage {
    private boolean formIsCompleted = false;

    @FindBy(how = How.XPATH, using = "//*[@id='f_o_8_min11111']")
    private WebElement priceFromField;

    @FindBy(how=How.XPATH, using = "//*[@id='f_o_8_max']")
    private WebElement priceToFielld;

    @FindBy(how = How.XPATH, using = "//*[@id='f_o_18_min']")
    private WebElement minYearDropDown;

    @FindBy(how = How.XPATH, using = "//*[@id='f_o_18_max']")
    private WebElement maxYearDropDown;

    @FindBy(how = How.XPATH, using = "//*[@id='f_o_15_min']")
    private WebElement minEngineCapDropDown;

    @FindBy(how = How.XPATH, using = "//*[@id='f_o_15_max']")
    private WebElement maxEngineCapDropDown;

    @FindBy(how = How.XPATH, using = "//*[@id='f_o_34']")
    private WebElement engineTypeDropDown;

    @FindBy(how = How.XPATH, using = "//*[@id='f_o_35']")
    private WebElement gearBoxDropDown;

    @FindBy(how = How.XPATH, using = "//*[@id='f_o_17']")
    private WebElement colorDropDown;

    @FindBy(how = How.XPATH, using = "//*[@id='f_o_32']")
    private WebElement bodyDropDown;

    @FindBy(how = How.XPATH, using = "//*[@class='filter_sel' and @style='min-width:50px;max-width:200px;']")
    private WebElement carBrand;

    @FindBy(how = How.XPATH, using = "//*[@class='filter_sel' and @style='min-width:54px;max-width:200px;']")
    private WebElement model;

    @FindBy(how = How.XPATH, using = "//*[@value='Искать' or @value='Meklēt']")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//*[@type='checkbox']")
    List<WebElement> allCheckboxes;

    @FindBy(how = How.XPATH, using = "//*[@type='checkbox']")
    WebElement favoriteCheckboxes;

    @FindBy(how = How.XPATH, using = "//*[@href='/ru/favorites/']")
    private WebElement favorites;

    public void fillSearchRequest(){
        priceFromField.sendKeys(PropertiesCache.getProperty("price.min"));
        priceToFielld.sendKeys(PropertiesCache.getProperty("price.max"));

        Select minYear = new Select(minYearDropDown);
        minYear.selectByValue(PropertiesCache.getProperty("year.min"));

        Select maxYear = new Select(maxYearDropDown);
        maxYear.selectByValue(PropertiesCache.getProperty("year.max"));

        Select minEngCap = new Select(minEngineCapDropDown);
        minEngCap.selectByValue(PropertiesCache.getProperty("engineCapMin"));

        Select maxEngCap = new Select(maxEngineCapDropDown);
        maxEngCap.selectByValue(PropertiesCache.getProperty("engineCapMax"));

        Select engType = new Select(engineTypeDropDown);
        engType.selectByValue(PropertiesCache.getProperty("engineType"));

        Select gearBox = new Select(gearBoxDropDown);
        gearBox.selectByValue(PropertiesCache.getProperty("gearbox"));

        Select body = new Select(bodyDropDown);
        body.selectByValue(PropertiesCache.getProperty("body"));

        Select color = new Select(colorDropDown);
        color.selectByValue(PropertiesCache.getProperty("color"));

        Select carBrandDropDown = new Select(carBrand);
        carBrandDropDown.selectByValue(PropertiesCache.getProperty("carBrand"));

        Select modelDropDown = new Select(model);
        modelDropDown.selectByValue(PropertiesCache.getProperty("model"));

        int index = new Random().nextInt(allCheckboxes.size()-1);
        String id = allCheckboxes.get(index).getAttribute("id");
        allCheckboxes.get(index).click();
        favorites.click();

        String id2 = favoriteCheckboxes.getAttribute("id");
        Assert.assertTrue(id.equals(id2));
    }
}
