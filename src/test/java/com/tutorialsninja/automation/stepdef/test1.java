package com.tutorialsninja.automation.stepdef;
import  com.tutorialsninja.automation.base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class test1 {


    @Test
    public void test()
    {
        WebDriver driver;
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://toolsqa.com/automation-practice-form/");
    }

    @Test
    public void test2()
    {
        Base.driver.get("https://www.udemy.com/course/selenium-by-arun/learn/lecture/13621086#overview");

    }
}
