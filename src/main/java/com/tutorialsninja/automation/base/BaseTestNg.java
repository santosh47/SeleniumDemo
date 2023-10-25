package com.tutorialsninja.automation.base;

import com.tutorialsninja.automation.framework.Retry;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BaseTestNg {
   public static WebDriver driver;


   @Parameters("browser")
    @BeforeTest
    public void setUp(String browser){


       if(browser.equalsIgnoreCase("chrome"))
       {
           driver=new ChromeDriver();
       }
      else
       {
           driver=new EdgeDriver();
       }

    }

    @AfterTest
    public void tearDown()
    {
        driver.close();
    }

    @Test(retryAnalyzer = Retry.class)
    public void test()
    {
        driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.14.0");
        String str=driver.getTitle();
        Assert.assertEquals(str,"Just ");

    }
}
