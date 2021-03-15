package com.SeleniumFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Scanner;

public class LoginPage {
    WebDriver driver;

   public LoginPage(WebDriver ldriver){
        driver=ldriver;
        PageFactory.initElements(ldriver,this);
    }
    @FindBy(xpath = "//input[@id='email']")
    @CacheLookup
    WebElement textusername;

    @FindBy(xpath = "//input[@id=\"passwd\"]")
    @CacheLookup
    WebElement textpassword;

    @FindBy(xpath =  "//button[@id=\"SubmitLogin\"]")
    @CacheLookup
    WebElement Submit ;

    public void setUsername(String email)
    {
        textusername.sendKeys(email);
    }

    public void setPassword(String password)
    {
        textpassword.sendKeys(password);
    }
    public void submit()
    {
        Submit.click();
    }
}
