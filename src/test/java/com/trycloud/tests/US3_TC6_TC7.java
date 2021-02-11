package com.trycloud.tests;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class US3_TC6_TC7  extends TestBase {

    @Test
    public void fileAcces(){



        Driver.getDriver().findElement(By.cssSelector("#appmenu > li:nth-child(2) > a")).click();
 /*
 Actions actions= new Actions(driver);

 actions.moveToElement(ok,20,20).click().perform();

solution two
  */


        Driver.getDriver().findElement(By.xpath("//span[@class='icon icon-add']")).click();
        Driver.getDriver().findElement(By.xpath("//li//span[.='New folder']")).click();
        Driver.getDriver().findElement(By.xpath("//input[@id='view13-input-folder']")).sendKeys("Ruslan K Folder", Keys.ENTER);
        WebElement folder =Driver.getDriver().findElement(By.xpath("//span[@class='nametext']//span[.='Ruslan K Folder']"));

        Assert.assertTrue(folder.isDisplayed());
    }


    @Test
    public void uploadFile(){

     Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']//li[@data-id='files']")).click();
        BrowserUtils.explicitWaitClick(Driver.getDriver(),10,"//span[@class='icon icon-add']");

        Driver.getDriver().findElement(By.xpath("//span[@class='icon icon-add']")).click();

        Driver.getDriver().findElement(By.xpath("//label[@for='file_upload_start']")).click();


        File file = new File("/Users/ruslankovalchuk/Downloads/dog.JPG");

        BrowserUtils.getUpload(file);

        WebElement dog = Driver.getDriver().findElement(By.xpath("//td[@class='filename ui-draggable ui-draggable-handle']//span[.='dog']"));




        Assert.assertTrue(dog.isDisplayed());
    }
}
