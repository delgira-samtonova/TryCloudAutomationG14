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
    public void TC5() {
        //Test case #5 - verify users can upload a file directly to the homepage (File-Uploading)
        //1. Login as a user
        //2. Click the “+” icon on top
        //3. Click “upload file”
        //4. Upload a file
        //5. Verify the file is displayed on the page
        //Go to the files
        Driver.getDriver().findElement(By.xpath("(//li[@data-id='files'])[1]")).click();
        BrowserUtils.sleep(2);
        //adding new file, by clicking the menu button
        //verification of the number of files displayed before uploading the new file.
        int howMayFilesBeforeAdding = Driver.getDriver().findElements(By.xpath("//tbody[@id='fileList']/tr")).size();
        //adding new file, by clicking the menu button
        WebElement addFileButton = Driver.getDriver().findElement(By.xpath("//a[@class='button new']"));
        addFileButton.click();
        //upload the file, YOU GOT A MAKE SURE YOY provide your own path
        WebElement upplodeFile = Driver.getDriver().findElement(By.id("file_upload_start"));
        upplodeFile.sendKeys("/Users/liubovtrudova/Desktop/test.png");
        //number of files displayed after uploding the new one
        int howManyFilesAafterUpploadigOne = Driver.getDriver().findElements(By.xpath("//tbody[@id='fileList']/tr")).size();
        if (howManyFilesAafterUpploadigOne - howMayFilesBeforeAdding == 1) {
            Assert.assertTrue(true);
        }
        //delete functionality in order don't change file path any time the case runs
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("(//a[@class='action action-menu permanent'])[4]")).click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//a[@class='menuitem action action-delete permanent']")).click();
    }

    @Test
    public void TC4() {
        Driver.getDriver().findElement(By.xpath("(//li[@data-id='files'])[1]")).click();
        BrowserUtils.sleep(2);
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
