package com.tutorialsninja.automation.framework;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private  int retrycount=0;
    private static final int maxcount =2;
    @Override
    public boolean retry(ITestResult iTestResult) {


        if(retrycount<maxcount)
        {
            retrycount++;
            return true;
        }
        return false;

    }
}
