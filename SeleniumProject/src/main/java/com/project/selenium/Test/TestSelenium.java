package com.project.selenium.Test;

import com.project.selenium.actiondriver.Action;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestSelenium {

    WebDriver driver;

    @org.testng.annotations.Test()

    public void test() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
        driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//form[@name='loginform']//input[@id='email']"))).click()
                .sendKeys("test", Keys.TAB).sendKeys("tes", Keys.ENTER).build().perform();
        Thread.sleep(6000);
        driver.quit();

    }
}