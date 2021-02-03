package com.trycloud.tests.US1_TC1_TC2_;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC2 extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        //  driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://qa.trycloud.net/index.php/login?clear=1");
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(ConfigurationReader.getProperty("login1"));
        BrowserUtils.sleep(1);
        Faker faker = new Faker();
        driver.findElement(By.id("password")).sendKeys(faker.internet().password());
        BrowserUtils.sleep(1);
        driver.findElement(By.id("submit-form")).click();
    }
@Test
public void logInInvalidVerification(){
    String ligInURL="http://qa.trycloud.net/index.php/login?";
    String actualUrl = driver.getCurrentUrl();
    WebElement warningMessage=driver.findElement(By.xpath("//p[@class='warning wrongPasswordMsg']"));
    boolean messageIsDisplayed= warningMessage.isDisplayed();
    String actualWarningMessageMessage = warningMessage.getText();
    String expectedWarningMessage = "Invalid user name or password.";
    Assert.assertTrue(messageIsDisplayed);
    Assert.assertTrue(actualUrl.contains(ligInURL));
    Assert.assertEquals(actualWarningMessageMessage,expectedWarningMessage);
}
    @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();
    }
}
