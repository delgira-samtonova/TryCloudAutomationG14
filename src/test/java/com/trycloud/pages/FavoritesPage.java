package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FavoritesPage {
    public FavoritesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[@class='nav-icon-favorites svg']")
    public WebElement favoritesPageBtn;
    @FindBy(xpath = "(//tbody[@id='fileList'])[3]/tr")
    public List<WebElement> allFavorites;
}
