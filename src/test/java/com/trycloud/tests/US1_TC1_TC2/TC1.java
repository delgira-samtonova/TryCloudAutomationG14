package com.trycloud.tests.US1_TC1_TC2;

import com.trycloud.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC1 extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
    }

    @Test
    public void logInVerification() {
        String expectedURL = "http://qa.trycloud.net/index.php/apps/files/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);

    }

    @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();
    }
}
