package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBordPage {
    public DashBordPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div[@id='expand']")
    public WebElement userSetings;

    @FindBy(xpath = "//li[@data-id='logout']")
    public WebElement logOut;
}
