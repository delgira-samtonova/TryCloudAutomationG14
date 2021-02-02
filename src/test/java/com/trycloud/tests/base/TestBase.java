package com.trycloud.tests.base;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    public Random random = new Random();

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("environment"));
        //Array of possible logins
        ArrayList<String> logIns = new ArrayList<String>();
        logIns.addAll(Arrays.asList(ConfigurationReader.getProperty("login1"),ConfigurationReader.getProperty("login2"),ConfigurationReader.getProperty("login3"),ConfigurationReader.getProperty("login4")));
        //defining wich login to use by using Random
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(logIns.get(random.nextInt(logIns.size())));
        BrowserUtils.sleep(1);
        driver.findElement(By.id("password")).sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        driver.findElement(By.id("submit-form")).click();
    }

    @AfterMethod
    public void tearDown() {
        // driver.close();
    }
}
