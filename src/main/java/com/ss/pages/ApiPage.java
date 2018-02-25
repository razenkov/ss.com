package com.ss.pages;

import com.ss.core.PropertiesCache;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ApiPage {
    @FindBy(how = How.XPATH, using = "//*[@id='c_val']")
    WebElement colorTheme;

    @FindBy(how = How.XPATH, using = "//*[@id='cid_0']")
    WebElement directory;

    @FindBy(how = How.XPATH, using = "//*[@id='cid_1']")
    WebElement typeOfRequest;

    @FindBy(how = How.XPATH, using = "//*[@id='cid_2']")
    WebElement occupation;

    @FindBy(how = How.XPATH, using = "//*[@id='js_code_div']")
    WebElement HTMLContainerGenerator;

    public String getHTMLGeneratorText(){
        return HTMLContainerGenerator.getText();
    }

    public String expHTMLRes = "<script type=\"text/javascript\" src=\"https://i.ss.com/w_inc/_ss_frame.js\"></script>\n" +
            "<script type=\"text/javascript\">\n" +
            "var _ss_main_url = \"https://www.ss.com/work/i-search-for-work/automechanic/\";\n" +
            "var _ss_frame_width = \"100%\";\n" +
            "var _ss_color_1 = \"pink\";\n" +
            "_ss_show_messages();\n" +
            "</script>";

    public void fillForm(){
        Select colorDrop = new Select(colorTheme);
        colorDrop.selectByValue("pink");

        Select areaDrop = new Select(directory);
        areaDrop.selectByValue("1|/work/");

        Select typeRequestDrop = new Select(typeOfRequest);
        typeRequestDrop.selectByValue("14081|/work/i-search-for-work/");

        Select occupationDrop = new Select(occupation);
        occupationDrop.selectByValue("-1|/work/i-search-for-work/automechanic/");
    }

    public boolean isHTMLResultCorrect(String actualResult){
        return expHTMLRes.equals(actualResult);
    }

}
