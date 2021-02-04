package com.trycloud.tests;

import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US3_TC6_TC7  extends TestBase {

    @Test
    public void fileAcces(){



        Driver.getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        Driver.getDriver().findElement(By.cssSelector("#appmenu > li:nth-child(2) > a")).click();
 /*
 Actions actions= new Actions(driver);

 actions.moveToElement(ok,20,20).click().perform();

solution two
  */


        Driver.getDriver().findElement(By.xpath("//span[@class='icon icon-add']")).click();
        Driver.getDriver().findElement(By.xpath("//li//span[.='New folder']")).click();
        Driver.getDriver().findElement(By.xpath("//input[@id='view13-input-folder']")).sendKeys("Ruslan K Folder", Keys.ENTER);
        WebElement folder =Driver.getDriver().findElement(By.xpath("//span[@class='nametext']//span[.='Ruslan K Folder']"));

        Assert.assertTrue(folder.isDisplayed());
    }
}
