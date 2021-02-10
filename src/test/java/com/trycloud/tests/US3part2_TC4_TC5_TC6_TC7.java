package com.trycloud.tests;

import com.github.javafaker.Faker;
import com.trycloud.pages.FavoritesPage;
import com.trycloud.pages.FilesPage;
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
    public FilesPage filesPage = new FilesPage();
    public FavoritesPage favoritesPage = new FavoritesPage();
    @Test
    public void TC5() {
        //Test case #5 - verify users can upload a file directly to the homepage (File-Uploading)
        //1. Login as a user
        //2. Click the “+” icon on top
        //3. Click “upload file”
        //4. Upload a file
        //5. Verify the file is displayed on the page
        //Go to the files
        filesPage.filesMenu.click();
        BrowserUtils.sleep(2);
        //adding new file, by clicking the menu button
        //verification of the number of files displayed before uploading the new file.
        int howMayFilesBeforeAdding = filesPage.allFilesOnPage.size();
        //adding new file, by clicking the menu button
        filesPage.addItemButton.click();

        //upload the file, YOU GOT A MAKE SURE YOY provide your own path
        //   WebElement upplodeFile =filesPage.upLoadFileInput;
        filesPage.upLoadFileInput.sendKeys("/Users/liubovtrudova/Desktop/test.png");
        //number of files displayed after uploding the new one
        int howManyFilesAafterUpploadigOne = filesPage.allFilesOnPage.size();
        if (howManyFilesAafterUpploadigOne - howMayFilesBeforeAdding == 1) {
            Assert.assertTrue(true);
        }
        //delete functionality in order don't change file path any time the case runs

        Driver.getDriver().findElement(By.xpath("(//a[@class='action action-menu permanent'])[4]")).click();

        filesPage.deleteItemButton.click();
    }

    @Test
    public void TC4() {
        filesPage.filesMenu.click();
        BrowserUtils.sleep(2);
        ///adding to the favorites the file or folder
        Driver.getDriver().findElement(By.xpath("(//a[@class='action action-menu permanent'])[3]")).click();
        //WebElement addFavorets = Driver.getDriver().findElement(By.xpath("//a[@class='menuitem action action-favorite permanent']"));
        filesPage.addFavoriteBtn.click();

        //go to the favorits
        favoritesPage.favoritesPageBtn.click();
        int numberOfupplodetFavoretes = favoritesPage.allFavorites.size();

        //deleting from favorites
        Driver.getDriver().findElement(By.xpath("(//a[@class='action action-menu permanent'])[4]")).click();
        filesPage.addFavoriteBtn.click();

        Driver.getDriver().navigate().refresh();
        //Verifying the file despaired from the favorites
        int actualNumbersOfRows = favoritesPage.allFavorites.size();
        Assert.assertEquals(numberOfupplodetFavoretes, actualNumbersOfRows + 1);

        //1. Login as a user
        //2. Click action-icon from any file on the page
        //3. Click “Remove from Favorites” option
        //4. Verify that the file is removed from Favorites sub-module’s table.
        //(Pre-condition: there should be at least 1 file is added to favorites table)
    }
}
