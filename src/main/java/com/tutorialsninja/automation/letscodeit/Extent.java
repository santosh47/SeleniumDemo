package com.tutorialsninja.automation.letscodeit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Extent {
    WebDriver driver;


    @Test
    public void test() {
        ExtentReports reports = new ExtentReports();
        ExtentSparkReporter sparkReporter=new ExtentSparkReporter("target/spark.html");
        reports.attachReporter(sparkReporter);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.co.in");
        reports.createTest("test").log(Status.PASS, "test");
        reports.flush();
    }
}