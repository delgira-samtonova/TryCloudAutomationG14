package com.trycloud.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
public static WebDriver getDriver(String webBrowserTyp){
    if(webBrowserTyp.equalsIgnoreCase("chrome")){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }else if(webBrowserTyp.equalsIgnoreCase("firefox")){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }else {
        System.err.println("only chrome or fireFox is aloud!");
        return null;
    }
}
}
