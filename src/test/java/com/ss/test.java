package com.ss;

import com.ss.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.locks.Condition;

public class test extends WebDriverTestBase {
    @Test
    public void test5() throws IOException {
        driver.get("https://ruhighload.com/");
        int numberOfLinksToCheck = 3;

        List<WebElement> links = driver.findElements(By.xpath("//*[@id=\"posts\"]/li/a"));

        if (!links.isEmpty() && links.size() >= numberOfLinksToCheck) {


            for (int i = 0; i < numberOfLinksToCheck; ++i) {
                String temp = links.get(i).getAttribute("href");
                URL myUrl = new URL(temp);
                HttpURLConnection myUrlCon = (HttpURLConnection) myUrl.openConnection();
                String method = myUrlCon.getRequestMethod();
                Assert.assertTrue("GET".equals(method));
            }
        }
        //driver.close();
    }

    @Test
    public void test2() throws InterruptedException {



        this.login();

        //WebElement sideBar = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div[1]/div/div[3]/div[1]/div[2]/div/div[1]"));
        WebElement home = driver.findElement(By.xpath("//*[@data-id='10']"));
        WebElement article = driver.findElement(By.xpath("//*[@data-id='20']"));
        WebElement authors = driver.findElement(By.xpath("//*[@data-id='30']"));


        for (int i = 0; i < 3; ++i){
            article.click();
            Thread.sleep(5000);
            authors.click();
            Thread.sleep(5000);
            home.click();
            Thread.sleep(5000);

        }

//        System.out.println();
//        sideBar.click();
//        System.out.println();
//        WebElement sideBar2 = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div[1]/div/div[3]/div[1]/div[2]/div/div[2]"));
//        sideBar2.click();
//        System.out.println();

        //WebElement data_list = driver.findElement(By.xpath("//*[@class='data_list data_list_pubs']"));
        //List<WebElement> list = driver.findElements(By.xpath("//*[@class='data_filters data_filters_list ']"));

        //WebElement screenOverlayBtn = driver.findElement(By.xpath("//*[@class='run-widget']"));
        //screenOverlayBtn.click();

        //WebElement home = driver.findElement(By.xpath("//*[@qa-id='home']"));
        //WebElement sideBar = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div[1]/div/div[3]/div[1]/div[2]"));
        //driver.switchTo().frame(sideBar);
//        WebElement home = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("//*[@qa-id='home']")));
//        home.click();TAB 2 = CDwindow-(3E0CD1FEEE9E7D5B28A6594B7D806297)
//        Assert.assertTrue(data_list.isDisplayed());
//        Assert.assertTrue(list.size()==2);

        System.out.println("-------------");
        //*[@data-tooltip='Launch fullscreen mode']???????
    }

    @Test
    public void test3(){
        // переключиться между табами и проверить разницу во времени
        driver.get("https://media.onthe.io/Gzb_9oMawcAHAd8s0jAcSuNwbWyIu9Ja?xw5e1s");
        ArrayList<String> listOfDates = new ArrayList<>();
        List<WebElement> list = driver.findElements(By.xpath("//*[@class='col col_3 clear related ']"));

        for (int i = 0; i < list.size(); ++i){
            //list.get(i).getText();
            System.out.println(listOfDates.add(list.get(i).getText()));

        }




    }








    public void login() throws InterruptedException {
        driver.get("https://onthe.io/auth");
        WebElement emailFiels = driver.findElement(By.name("email"));
        emailFiels.sendKeys("gexibawer@one2mail.info");
        WebElement pass = driver.findElement(By.name("pwd"));
        pass.sendKeys("q");
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"auth\"]/button"));
        loginBtn.submit();
        WebElement RuHighloadBtn = driver.findElement(By.xpath("//a[@href='https://media.onthe.io/Gzb_9oMawcAHAd8s0jAcSuNwbWyIu9Ja']"));
        RuHighloadBtn.click();

        WebElement btn2 = driver.findElement(By.xpath("/html/body/div[10]/div[2]/button"));
        btn2.click();

        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        if (!tabs2.isEmpty()) {
            System.out.println(tabs2.get(0).toString());
            //System.out.println(tabs2.get(1).toString());
            System.out.println("LIST SIZE  = " + tabs2.size());

            if (tabs2.size() == 2){
                System.out.println("TAB ! = " + tabs2.get(0).toString());
                System.out.println("TAB 2 = " + tabs2.get(1).toString());

                driver.switchTo().window(tabs2.get(0).toString());
                Map<String, String> tabsList = new HashMap<>();


                WebElement links = driver.findElement(By.xpath("//*[@id=\"posts\"]/li/a"));
                driver.switchTo().window(tabs2.get(0).toString());

                if(links.isDisplayed()){
                    tabsList.put("LinksPage", tabs2.get(0).toString());
                    tabsList.put("StatPage", tabs2.get(1).toString());
                }else {
                    tabsList.put("StatPage", tabs2.get(0).toString());
                    tabsList.put("LinksPage", tabs2.get(1).toString());
                }

                driver.switchTo().window(tabsList.get("StatPage"));
                System.out.println("-----I M ON StatPage PAGE!");

            }

        }



    }
}


