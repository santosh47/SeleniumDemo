package com.tutorialsninja.automation.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Test {



@org.junit.jupiter.api.Test
    public void test()
{
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        List<WebElement> list=driver.findElements(By.xpath("//div[@id='nav-xshop']//span"));

        for(WebElement element:list)
        {
            String ele=element.getText();
            System.out.println(ele);
    }

}
}
