package com.trycloud.tests.base;

import com.trycloud.pages.LogInPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public Random random = new Random();
    public LogInPage logInPage = new LogInPage();

    @BeforeMethod
    public void setUp() {
        // Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("environment"));
        //Array of possible logins
        ArrayList<String> logIns = new ArrayList<String>();
        logIns.addAll(Arrays.asList(ConfigurationReader.getProperty("login1"), ConfigurationReader.getProperty("login2"), ConfigurationReader.getProperty("login3"), ConfigurationReader.getProperty("login4")));

        //defining wich login to use by using Random
        logInPage.loginInput.sendKeys(logIns.get(random.nextInt(logIns.size())));

        logInPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));

        logInPage.logInButton.click();
    }

    @AfterMethod
    public void tearDown() {
        // Driver.closeDriver();
    }
}
