package com.trycloud.tests.US1_TC1_TC2_;

import com.trycloud.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1 extends TestBase {

    @Test
    public void logInVerification() {
        String expectedURL = "http://qa.trycloud.net/index.php/apps/files/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }

}
