package com.trycloud.tests;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US1_TC1_TC2 extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
    }

    @Test
    public void logInVerification() {
        String expectedURL = "http://qa.trycloud.net/index.php/apps/files/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }
    @Test
    public void logOutVerification(){
        driver.findElement(By.xpath("//div[@id='expand']")).click();
        driver.findElement(By.xpath("//li[@data-id='logout']")).click();
        Assert.assertEquals(ConfigurationReader.getProperty("environment"),driver.getCurrentUrl());
    }

    @Test
    public void logInInvalidVerification() {
        driver.findElement(By.xpath("//div[@id='expand']")).click();
        driver.findElement(By.xpath("//li[@data-id='logout']")).click();
        BrowserUtils.sleep(1);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(ConfigurationReader.getProperty("login1"));
        BrowserUtils.sleep(2);
        Faker faker = new Faker();
        driver.findElement(By.id("password")).sendKeys(faker.internet().password());
        BrowserUtils.sleep(1);
        driver.findElement(By.id("submit-form")).click();

        WebElement warningMessage = driver.findElement(By.xpath("//p[@class='warning wrongPasswordMsg']"));
        boolean messageIsDisplayed = warningMessage.isDisplayed();
        String actualWarningMessageMessage = warningMessage.getText();
        String expectedWarningMessage = "Wrong username or password.";
        Assert.assertTrue(messageIsDisplayed);
        Assert.assertEquals(actualWarningMessageMessage, expectedWarningMessage);
    }
}