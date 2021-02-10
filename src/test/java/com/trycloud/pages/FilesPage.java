package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage {
    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//li[@data-id='files'])[1]")
    public WebElement filesMenu;
    @FindBy(xpath = "//tbody[@id='fileList']/tr")
    public List<WebElement> allFilesOnPage ;

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement addItemButton;
    @FindBy(id = "file_upload_start")
    public WebElement upLoadFileInput;
    @FindBy(xpath = "//a[@class='menuitem action action-delete permanent']")
    public WebElement deleteItemButton;

    @FindBy(xpath = "//a[@class='menuitem action action-favorite permanent']")
    public WebElement addFavoriteBtn;
}
