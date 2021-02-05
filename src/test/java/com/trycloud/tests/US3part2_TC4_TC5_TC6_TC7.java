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

import java.util.List;

public class US3part2_TC4_TC5_TC6_TC7 extends TestBase {

    @Test
    public void removeFileVerification() {
    /*
    This part of functionality developed particularly for login2
    However the program designed for any User log in key .

        Driver.getDriver().findElement(By.xpath("//div[@id='expand']")).click();
        Driver.getDriver().findElement(By.xpath("//li[@data-id='logout']")).click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//input[@id='user']")).sendKeys(ConfigurationReader.getProperty("login2"));
        BrowserUtils.sleep(2);

        Driver.getDriver().findElement(By.id("password")).sendKeys(ConfigurationReader.getProperty("password"));

        Driver.getDriver().findElement(By.id("submit-form")).click();
*/
        Driver.getDriver().findElement(By.xpath("(//li[@data-id='files'])[1]")).click();
        BrowserUtils.sleep(2);
        //adding new file, by clicking the menu button

            WebElement addFileButton = Driver.getDriver().findElement(By.xpath("//a[@class='button new']"));
            addFileButton.click();
            //upload the file, YOU GOT A MAKE SURE YOY UPLODE YOUR OWN FILE BEFORE THE PROGRAM RUNS all so provide your own path
            WebElement upplodeFile = Driver.getDriver().findElement(By.id("file_upload_start"));
            upplodeFile.sendKeys("/Users/liubovtrudova/Desktop/back.jpg");

        //handling uprearing form
        if (Driver.getDriver().findElement(By.xpath("//button[@class='cancel']")).isDisplayed()) {
            Driver.getDriver().findElement(By.xpath("//button[@class='cancel']")).click();
        }
        ///adding to the favorites the file or folder
        Driver.getDriver().findElement(By.xpath("(//a[@class='action action-menu permanent'])[3]")).click();
        WebElement addFavorets = Driver.getDriver().findElement(By.xpath("//a[@class='menuitem action action-favorite permanent']"));
        addFavorets.click();

        //go to the favorits
        Driver.getDriver().findElement(By.xpath("//a[@class='nav-icon-favorites svg']")).click();
        List<WebElement> numberOfupplodetFavoretes = Driver.getDriver().findElements(By.xpath("(//tbody[@id='fileList'])[3]/tr"));

        //deleting from favorites
        Driver.getDriver().findElement(By.xpath("(//a[@class='action action-menu permanent'])[4]")).click();
        Driver.getDriver().findElement(By.xpath("//a[@class='menuitem action action-favorite permanent']")).click();

        Driver.getDriver().navigate().refresh();
        //Verifying the file despaired from the favorites
        int actualNumbersOdrows = Driver.getDriver().findElements(By.xpath("(//tbody[@id='fileList'])[3]/tr")).size();
        Assert.assertEquals(numberOfupplodetFavoretes.size(), actualNumbersOdrows + 1);

        //1. Login as a user
        //2. Click action-icon from any file on the page
        //3. Click “Remove from Favorites” option
        //4. Verify that the file is removed from Favorites sub-module’s table.
        //(Pre-condition: there should be at least 1 file is added to favorites table)
    }
}
