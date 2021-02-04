package com.trycloud.tests;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.image.Kernel;

public class US5_TC1_TC2 extends TestBase {

    @Test
    public void contactsTitleVerification(){
        //Finding the Contacts button and clicking it
        Driver.getDriver().findElement(By.xpath("//a[@aria-label='Contacts']")).click();
        //Verifying that current Title contains "Contacts"
        String currentTitle = Driver.getDriver().getTitle();
        String expectedTitle ="Contacts";
        Assert.assertTrue(currentTitle.contains(expectedTitle));
        //Closing Browser
        Driver.closeDriver();

    }
    @Test
    public void contactListVerification(){
        //Finding the Contacts button and clicking it
        Faker faker = new Faker();
        Driver.getDriver().findElement(By.xpath("//a[@aria-label='Contacts']")).click();
        //Locating the New contact button
        Driver.getDriver().findElement(By.id("new-contact-button")).click();
        String name = "Tamerlan";
        //Locating name space
        WebElement nameSpace = Driver.getDriver().findElement(By.xpath("//input[@id='contact-fullname']"));
        nameSpace.sendKeys(Keys.COMMAND+"A");
        nameSpace.sendKeys("Tamerlan");
        //Locating Phone space
        Driver.getDriver().findElement(By.xpath("//input[@inputmode='tel']")).sendKeys(faker.phoneNumber().cellPhone());
        //locating email space
        Driver.getDriver().findElement(By.xpath("//input[@inputmode='email']")).sendKeys(faker.internet().emailAddress());
        //locating company space
        Driver.getDriver().findElement(By.xpath("//input[@placeholder='Company']")).sendKeys("Cybertek");
        //locating Title space
        Driver.getDriver().findElement(By.xpath("//input[@placeholder='Title']")).sendKeys("SDET");
        









    }

}
