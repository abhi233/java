package com.SeleniumFramework.Listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {
    public void onTestStart(ITestResult iTestResult)
    {
        System.out.println("Test Starte");
    }
    public void onTestEnd(ITestResult iTestResult)
    {
        System.out.println("Test Ended");
    }
    public void onTestSuccess(ITestResult iTestResult)
    {
        System.out.println("Test Success");
    }
    public void onTestFailure(ITestResult iTestResult)
    {
        System.out.println("Test Failure");
    }
}
