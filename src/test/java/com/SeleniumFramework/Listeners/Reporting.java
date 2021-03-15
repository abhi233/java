package com.SeleniumFramework.Listeners;

import com.SeleniumFramework.testcases.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting  extends TestListenerAdapter {
    public ExtentReports extentReports;
    public ExtentHtmlReporter extentHtmlReporter;
    public ExtentTest extentTest;
    WebDriver driver;


    @Override
    public void onStart(ITestContext testContext) {
        super.onStart(testContext);
        String timestamp = new SimpleDateFormat("yyyy.mm.dd.HH..mm.ss").format(new Date());
        String repName= "Test-Report"+timestamp+".html";
        extentHtmlReporter=new ExtentHtmlReporter("./test-output/"+repName);
extentReports = new ExtentReports();

        extentReports.attachReporter(extentHtmlReporter);
extentReports.setSystemInfo("HostName","Test");
        extentReports.setSystemInfo("HostName","Test");
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("User Name","RK");
        extentReports.setSystemInfo("HostName","Test");
        extentHtmlReporter.config().setTheme(Theme.DARK);
        extentHtmlReporter.config().setReportName("Automation-Report");
        extentHtmlReporter.config().setDocumentTitle("ExtentReport");



    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);

        extentTest=extentReports.createTest(tr.getName());
        extentTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.BLUE));
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String screenshotPath = "./screenshots/"+tr.getName()+dateName+".PNG";
        //To add it in the extent report
        File src=new File(screenshotPath);
        try {
            extentTest.pass("screenshot is attached"+extentTest.addScreenCaptureFromPath(screenshotPath));
            System.out.println(screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        extentTest = extentReports.createTest(tr.getName());
        extentTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName() + " - Test Case Failed", ExtentColor.RED));
        String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png";

        File f = new File(screenshotPath);

        if (f.exists()) {
            try { System.out.println(screenshotPath);
                extentTest.fail("Screenshot is below:" + extentTest.addScreenCaptureFromPath(screenshotPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
        extentTest=extentReports.createTest(tr.getName());
        extentTest.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.AMBER));
    }
    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
        extentReports.flush();
    }
}
