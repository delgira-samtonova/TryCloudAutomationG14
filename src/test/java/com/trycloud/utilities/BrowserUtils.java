package com.trycloud.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
    public static void sleep(int second){
        second*=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){
            e.getStackTrace();
            System.out.println("Threa.sleep method was used");
        }
    }


//
//    public static void explicitWaitVisibility(WebDriver driver, int sec, String locator){
//
//        WebDriverWait webDriverWait = new WebDriverWait(driver,sec);
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
//
//    }

//    public static void explicitWaitClick(WebDriver driver,int sec,String locator){
//
//        WebDriverWait webDriverWait = new WebDriverWait(driver,sec);
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
//
//    }
}
