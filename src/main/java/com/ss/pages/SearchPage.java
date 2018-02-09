package com.ss.pages;

import com.ss.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchPage {
    @FindBy(how = How.XPATH, using = "//input[@id='ptxt']")
    WebElement wordField;

    @FindBy(how = How.XPATH, using = "//select[@name='cid_0']")
    WebElement sectionDropdown;

    @FindBy(how = How.XPATH, using = "//select[@name='search_region']")
    WebElement townDropdown;

    @FindBy(how = How.XPATH, using = "//select[@name='pr']")
    WebElement periodDropdown;

    @FindBy(how = How.XPATH, using = "//*[@id='sbtn']")
    WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//select[@name='cid_0']")
    WebElement categoryDropdown;

    @FindBy(how = How.XPATH, using = "//*[@class='ads_cat_names']")
    List<WebElement> resultList;

    @FindBy(how = How.XPATH, using = "//*[@valign='top']")
    WebElement backGround;

    public String searchData = "Ноутбук";

    public void fillSearchForm(WebDriver driver){


        Select section = new Select(driver.findElement(
                By.xpath("//*[@onchange='load( 1, this[this.selectedIndex].value );this.form.cid.value=this.value;check_s_region(this[this.selectedIndex].value);']")));
        section.selectByValue("6");

        Select category = new Select(driver.findElement(By.xpath("//*[@onchange ='this.form.cid.value=this.value;']")));
        category.selectByValue("4781");

        Select town = new Select(driver.findElement(By.xpath("//*[@id ='s_region_select']")));
        town.selectByValue("riga_f");

        Select period = new Select(driver.findElement(By.xpath("//*[@name ='pr']")));
        period.selectByValue("7");

        wordField.sendKeys(searchData);

        searchButton.click();


    }

    public boolean isSearchSuccessful(){
        int numberOfMatchLinks = 0;
        for (int i = 0; i < resultList.size(); ++i){
            if(resultList.get(i).getText().contains(searchData)){
                numberOfMatchLinks++;
            }
        }
        if(numberOfMatchLinks > 0){
            return true;
        }else {
            return false;
        }
    }
}
