package com.tutorialsninja.automation.test.datadriven;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

public class Datadriven {

    @Test(dataProvider ="getdata" )
    public void datadriven(String email,String pass)
    {
        int timeoutInSeconds = 20;  // Set your desired timeout in seconds
        Duration timeoutDuration = Duration.ofSeconds(timeoutInSeconds);

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");;
        driver.manage().window().maximize();
       driver.findElement(By.xpath("//a[@title='My Account']")).click();
      driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.xpath(" //ul[@class='breadcrumb']//li[3]/a[text()='Login']")).click();
        WebDriverWait wait = new WebDriverWait(driver,timeoutDuration);
        driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(pass);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();


        }




@DataProvider
    public Object[][] getdata () throws IOException {

        String loginData[][] = {
                {"Admin", "admin123"},
                {"Admin", "admin123"}

        };
        return loginData;
    }
}

