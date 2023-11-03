package com.tutorialsninja.automation.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReport {
    ExtentReports extentReport = new ExtentReports();
    ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/Spark.html");
    @BeforeTest
    public void Befor() {
        extentReport.attachReporter(sparkReporter);
    }

    @Test
    public void test1() {
        ExtentTest extentTest= extentReport.createTest("testing");
        extentTest.log(Status.PASS,"Hello");
        extentTest.pass("passed");
    }

    @Test
    public void test2() {
        ExtentTest extentTest= extentReport.createTest("testing2");
        extentTest.info("pass");
        extentTest.warning("warning");
    }
    @AfterTest
    public void After() {
        extentReport.flush();
    }
}
