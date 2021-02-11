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

import java.awt.*;
import java.awt.image.Kernel;
import java.util.List;

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
        String name = faker.name().name();
        //Locating name space
        WebElement nameSpace = Driver.getDriver().findElement(By.xpath("//input[@id='contact-fullname']"));
        nameSpace.sendKeys(Keys.COMMAND+"A");
        nameSpace.sendKeys(name);
        //Locating Phone space
        Driver.getDriver().findElement(By.xpath("//input[@inputmode='tel']")).sendKeys(faker.phoneNumber().cellPhone());
        //locating email space
        Driver.getDriver().findElement(By.xpath("//input[@inputmode='email']")).sendKeys(faker.internet().emailAddress());
        //locating company space
        Driver.getDriver().findElement(By.xpath("//input[@placeholder='Company']")).sendKeys("Cybertek");
        //locating Title space
        Driver.getDriver().findElement(By.xpath("//input[@placeholder='Title']")).sendKeys("SDET");
        //locating post office box
        Driver.getDriver().findElement(By.xpath("(//input[@class='property__value'])[1]")).sendKeys("12345-123");
        //locating address
        Driver.getDriver().findElement(By.xpath("(//input[@class='property__value'])[2]")).sendKeys(faker.address().cityName());
        //locating extended address
        Driver.getDriver().findElement(By.xpath("(//input[@class='property__value'])[3]")).sendKeys(faker.address().fullAddress());
        //locating Postcode
        Driver.getDriver().findElement(By.xpath("(//input[@class='property__value'])[4]")).sendKeys(faker.address().zipCode());
        //locating City
        Driver.getDriver().findElement(By.xpath("(//input[@class='property__value'])[5]")).sendKeys(faker.address().city());
        //locating State or province
        Driver.getDriver().findElement(By.xpath("(//input[@class='property__value'])[6]")).sendKeys(faker.address().state());
        //locating country
        Driver.getDriver().findElement(By.xpath("(//input[@class='property__value'])[7]")).sendKeys(faker.address().country());


        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//main//div"));

        boolean nameDisplayed = false;

        for (WebElement each : list) {
            if (each.getText().contains(name)) {
                nameDisplayed = true;
            }
        }

        if (nameDisplayed) {
            Assert.assertTrue(nameDisplayed, "Expected name is Displayed on the list of contacts");
        }
            BrowserUtils.sleep(5);
            Driver.getDriver().close();










    }

}
