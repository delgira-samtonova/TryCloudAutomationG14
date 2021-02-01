package com.trycloud.tests.base;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://qa.trycloud.net/index.php/login?clear=1");
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(ConfigurationReader.getProperty("login1"));
        BrowserUtils.sleep(1);
        driver.findElement(By.id("password")).sendKeys(ConfigurationReader.getProperty("password"));
         BrowserUtils.sleep(1);
        driver.findElement(By.id("submit-form")).click();

    }

    @AfterMethod
    public void tearDown(){
       driver.close();
    }
}
