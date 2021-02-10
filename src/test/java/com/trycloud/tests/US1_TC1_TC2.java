package com.trycloud.tests;

import com.github.javafaker.Faker;
import com.trycloud.pages.DashBordPage;
import com.trycloud.pages.LogInPage;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US1_TC1_TC2 extends TestBase {
    public DashBordPage dashBordPage= new DashBordPage();
    @Test
    public void logInVerification() {
        String expectedURL = "http://qa2.trycloud.net/index.php/apps/dashboard/";
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }
    @Test
    public void logOutVerification(){

        dashBordPage.userSetings.click();
        dashBordPage.logOut.click();
        Assert.assertEquals(ConfigurationReader.getProperty("environment"),Driver.getDriver().getCurrentUrl());
    }

    @Test
    public void logInInvalidVerification() {
        dashBordPage.userSetings.click();
        dashBordPage.logOut.click();
        //negative case
        logInPage.loginInput.sendKeys(ConfigurationReader.getProperty("login1"));
        Faker faker = new Faker();
        logInPage.passwordInput.sendKeys(faker.internet().password());

        logInPage.logInButton.click();

        boolean messageIsDisplayed = logInPage.warningMessage.isDisplayed();
        String actualWarningMessageMessage = logInPage.warningMessage.getText();
        String expectedWarningMessage = "Wrong username or password.";

        Assert.assertTrue(messageIsDisplayed);
        Assert.assertEquals(actualWarningMessageMessage, expectedWarningMessage);
    }
}