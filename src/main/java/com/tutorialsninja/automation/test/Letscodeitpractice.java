package com.tutorialsninja.automation.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Letscodeitpractice {

    WebDriver driver;
    @Test
    public void setDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();

    }

    @Test
   public void letscodeit_radiobutton()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();

    List<WebElement> radio=driver.findElements(By.xpath("//*[@type=\"radio\"]"));
    int size=radio.size();
    for(int i=0;i<size;i++)
{
   String value= radio.get(i).getAttribute("value");
   if(value.equalsIgnoreCase("BMW"))
   {
       radio.get(i).click();
       break;
   }

}


    }

    @Test
    public void checkbox()
    {


        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();

        List<WebElement> radio=driver.findElements(By.xpath("//*[@type=\"checkbox\"]"));
        int size=radio.size();
        for(int i=0;i<size;i++)
        {
            String value= radio.get(i).getAttribute("value");
            if(value.equalsIgnoreCase("BMW"))
            {
                radio.get(i).click();
                break;
            }

        }

    }


}