package com.SeleniumFramework.testcases;

import com.SeleniumFramework.utilities.ReadConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class BaseClass {
    ReadConfig readConfig = new ReadConfig();

    public static WebDriver driver;
    Logger logger;
    public String baseUrl=readConfig.getbaseURL();
    public String username=readConfig.getUserName();
    public String password=readConfig.getPassword();


   @Parameters("browser")
    @BeforeClass
    public void setup(String browser){

        logger =Logger.getLogger("SeleniumFramework");
        PropertyConfigurator.configure("log4j.properties");
        switch (browser){
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver =new ChromeDriver();
                break;
            case "FireFox":
                WebDriverManager.firefoxdriver().setup();
                driver =new FirefoxDriver();
                break;
            case "IE":
                WebDriverManager.iedriver().setup();
                driver =new InternetExplorerDriver();
                break;
            case "Edge":
                    WebDriverManager.edgedriver().setup();
                    driver =new EdgeDriver();
        }

       driver.get(baseUrl);

    }
    @AfterClass
    public void tear()
    {
        driver.quit();
    }
    public void getScreenShot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/Screenshots/" +screenshotName+dateName +".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);

    }
}
