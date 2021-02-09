package com.trycloud.tests;

import com.github.javafaker.Faker;
import com.trycloud.tests.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class US04_TC01_TC2 extends TestBase {
    @Test
    public void testCase01() {
        Driver.getDriver().findElement(By.xpath("(//li[@data-id='spreed'])[1]")).click();
        String titleOfTalk = Driver.getDriver().getTitle();

        Assert.assertTrue(titleOfTalk.contains("Talk - Trycloud"));
    }

    @Test
    public void testCase02() {
        //Driver.getDriver().findElement(By.xpath("//a[@class='app-navigation-toggle'][1]")).click();
        Driver.getDriver().findElement(By.xpath("//input[@class='app-navigation-search__input']")).sendKeys(Keys.SPACE);
        List<WebElement> userList = Driver.getDriver().findElements(By.xpath("//ul[@class='contacts-list']//div[@class='acli__content__line-one']"));
        Driver.getDriver().findElement(By.xpath("//input[@class='app-navigation-search__input']")).sendKeys(userList.get(random.nextInt(userList.size())).getText());
        Driver.getDriver().findElement(By.xpath("//a[@class='acli']")).click();
        WebElement msgInput = Driver.getDriver().findElement(By.xpath("//div[@class='new-message-form__advancedinput']"));
        Faker faker = new Faker();
        msgInput.sendKeys(faker.ancient().hero());
        BrowserUtils.sleep(3);
        Driver.getDriver().findElement(By.xpath("//div[@class='new-message-form__advancedinput']")).sendKeys(Keys.ENTER);
        //msgInput.sendKeys(Keys.ENTER);


        BrowserUtils.sleep(5);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[@class='message__main__text']")).isDisplayed());

    }
}
