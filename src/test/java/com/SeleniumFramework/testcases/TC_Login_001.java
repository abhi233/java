package com.SeleniumFramework.testcases;

import com.SeleniumFramework.Listeners.Reporting;
import com.SeleniumFramework.pageObjects.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_Login_001 extends BaseClass{
    @Test
    public void login() throws InterruptedException, IOException {

    logger.info("WebPage is Opened");
        Thread.sleep(4000);
        LoginPage loginPage=new LoginPage(driver);
        loginPage.setUsername(username);
        getScreenShot(driver,"login");
        loginPage.setPassword(password);
        Thread.sleep(4000);
        loginPage.submit();
        //Thread.sleep(2000);
      //  getScreenShot(driver,"login");
        Assert.assertTrue(driver.getTitle().contains("fgfgf"));
        //getScreenShot(driver,"login");
        logger.info("TestMethod got failed");

    }
    @Test
    public void listener() throws InterruptedException {
        System.out.println("Test is passed");

    }
}
