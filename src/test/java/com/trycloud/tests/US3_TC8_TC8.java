package com.trycloud.tests;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;


public class US3_TC8_TC8 extends TestBase{

        /*
        Test case #8 - verify users can delete a file/folder.
    1. Login as a user
    2. Click action-icon from any file on the page
    3. Choose “delete files” option
    4. Click deleted files on the left bottom corner
    5. Verify the deleted file is displayed on the page.
    (Pre-condition: there should be at least 1 file is uploaded inside files page)
         */
        @Test
        public void TC8_1(){
            Driver.getDriver().findElement(By.xpath("(//a[@aria-label='Files'])[1]")).click();
            BrowserUtils.sleep(2);
            WebElement obj1 = Driver.getDriver().findElement(By.xpath("(//span[.='forTest'])[2]"));
            Actions actions = new Actions(Driver.getDriver());
            BrowserUtils.sleep(2);
            actions.contextClick(obj1).perform();
            BrowserUtils.sleep(2);

            Driver.getDriver().findElement(By.xpath("//span[@class='icon icon icon-delete']")).click();
            BrowserUtils.sleep(2);
            Driver.getDriver().findElement(By.xpath("//a[.='Deleted files']")).click();
            BrowserUtils.sleep(5);
            WebElement deletedFile = Driver.getDriver().findElement(By.xpath("//span[.='forTest.png']"));
            BrowserUtils.sleep(2);

            Assert.assertTrue(deletedFile.isDisplayed());


        }

        /*
        Test case #8 - verify users can write comments to files/folders.
    1. Login as a user
    2. Click action-icon from any file on the page
    3. Click details
    4. Write a comment inside to the input box
    5. Click the submit button to post it
    6. Verify the comment is displayed in the comment section.
    (Pre-condition: there should be at least 1 file is uploaded inside files page)
         */
         @Test
         public void TC8_2(){

        Driver.getDriver().findElement(By.xpath("(//a[@aria-label='Files'])[1]")).click();
        BrowserUtils.sleep(2);

        WebElement obj1 = Driver.getDriver().findElement(By.xpath("(//span[.='forTest'])[2]"));

        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);

        actions.contextClick(obj1).perform();
        BrowserUtils.sleep(2);

        Driver.getDriver().findElement(By.xpath("//span[@class='icon icon icon-details']")).click();
        BrowserUtils.sleep(2);

        Driver.getDriver().findElement(By.xpath("//a[@id='commentsTabView']")).click();
        BrowserUtils.sleep(2);

        String message = "testing here";
        Driver.getDriver().findElement(By.xpath("//div[@class='message']")).sendKeys(message);
        BrowserUtils.sleep(2);

        Driver.getDriver().findElement(By.xpath("(//input[@type='submit'])[2]")).click();
        BrowserUtils.sleep(2);
        WebElement messageBox = Driver.getDriver().findElement(By.xpath("//div[.='"+message+"']"));
        Assert.assertTrue(messageBox.isDisplayed());

    }

}
