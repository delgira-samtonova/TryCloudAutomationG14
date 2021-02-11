package com.trycloud.tests;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US3_TC1 extends TestBase {

    /*
    US3: As a user, I should be able to access to Files module.
    Test case #1 - verify users can access to Files module
    1. Login as a user
    2. Verify the page title is Files module’s title
     */

    @Test
    public void verifyFilesPageTitle(){

        Driver.getDriver().findElement(By.xpath("//a[@aria-label='Files']")).click();

        String actualFilesTitle = Driver.getDriver().getTitle();

        String expectedFilesTitle = "Files - Trycloud";

        Assert.assertTrue(actualFilesTitle.equals(expectedFilesTitle));

        Driver.closeDriver();

    }
}