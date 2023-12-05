package com.project.selenium.Test;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Practice {

    WebDriver driver;

    @Test(priority = 1)
    public void Test() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
        List<WebElement> radioButton = driver.findElements(By.tagName("input"));
        for (WebElement radio : radioButton) {
            System.out.println(radio.getText());
            if (radio.getAttribute("value").equalsIgnoreCase("bmw")) {
                radio.click();
                Thread.sleep(6000);
                break;
            }
        }
    }


    @Test
    public void Test1() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
        driver.findElement(By.xpath("//button[@id='openwindow']")).click();
        driver.findElement(By.xpath("//button[@id='openwindow']")).click();
        driver.findElement(By.xpath("//button[@id='openwindow']")).click();
        driver.findElement(By.xpath("//button[@id='openwindow']")).click();
        String pid = driver.getWindowHandle();
        Set<String> id = driver.getWindowHandles();
        List<String> wid = new ArrayList<>(id);
        driver.switchTo().window(wid.get(3));

//        Actions action = new Actions(driver); action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform(); //opening the URL saved.
//        driver.get(urlToClick);
    }


    @Test
    public void Test3() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement element = null;
        Actions actions = new Actions(driver);
        actions.moveToElement(element,10,20);
        actions.clickAndHold();
        actions.contextClick();
        actions.sendKeys();
        actions.pause(2000);
        actions.moveByOffset(10,20);
        actions.moveToLocation(100,200);
        driver.switchTo().frame("2");
        driver.switchTo().defaultContent();
        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofMinutes(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));
        wait.until(ExpectedConditions.alertIsPresent());
        FluentWait wait1=new FluentWait<>(driver);
        wait1.withTimeout(Duration.ZERO);
        wait1.pollingEvery(Duration.ofSeconds(20));
        wait1.ignoring(NoSuchElementException.class);


    }
}