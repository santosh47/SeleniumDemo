package com.tutorialsninja.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Test {
   public static WebDriver driver;


   //@Parameters("browser")
    @BeforeTest
    public void setUp(){



           driver=new ChromeDriver();
       }




    @AfterTest
    public void tearDown()
    {
        driver.close();
    }


//
//    @Test(retryAnalyzer = Retry.class)
//    public void test()
//    {
//        driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.14.0");
//        String str=driver.getTitle();
//        Assert.assertEquals(str,"Just ");
//
//    }
}
