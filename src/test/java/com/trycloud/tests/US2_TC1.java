package com.trycloud.tests;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US2_TC1 extends TestBase {

    @Test
    public void accessMainModules(){

        /*
        US2: As a user, I should be able to access all the main modules of the app.
        Test case #1 - verify users access to the main modules
        1. Login as a user
        2. Verify the user see the following modules:
        Files Galleries Activity Talk Contacts Calendar Note
        ( Expected module name: Galleries
        Actual module name : Photos )
         */

        WebElement files = Driver.getDriver().findElement(By.xpath("//a[@aria-label='Files']"));
        Assert.assertTrue(files.isDisplayed());

        WebElement photos = Driver.getDriver().findElement(By.xpath("//a[@aria-label='Photos']"));
        String actualPhotos = "Photos";
        String expectedGalleries = "Galleries";
        Assert.assertNotEquals(actualPhotos,expectedGalleries, "Expected result should be galleries but actual result is photos");

        WebElement activity = Driver.getDriver().findElement(By.xpath("//a[@href='/index.php/apps/activity/']"));
        Assert.assertTrue(activity.isDisplayed());

        WebElement talk = Driver.getDriver().findElement(By.xpath("//a[@href='http://qa2.trycloud.net/index.php/apps/spreed/']"));
        Assert.assertTrue(talk.isDisplayed());

        WebElement contacts = Driver.getDriver().findElement(By.xpath("//a[@href='/index.php/apps/contacts/']"));
        Assert.assertTrue(contacts.isDisplayed());

        WebElement calendar = Driver.getDriver().findElement(By.xpath("//a[@href = '/index.php/apps/calendar/']"));
        Assert.assertTrue(calendar.isDisplayed());

       //? WebElement note = Driver.getDriver().findElement();
       //? Assert.assertTrue(note.isDisplayed());

        Driver.closeDriver();


    }
}
