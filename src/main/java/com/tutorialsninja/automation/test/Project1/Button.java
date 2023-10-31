package com.tutorialsninja.automation.test.Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Button {

    WebDriver driver;
    @Test

    public void button() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        WebElement element = driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][1]"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        Thread.sleep(1000);
        WebElement buttons = driver.findElement(By.xpath("//span[text()='Buttons']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", buttons);
        buttons.click();
        Thread.sleep(1000);
        WebElement dobleClick = driver.findElement(By.id("doubleClickBtn"));
        Actions actions=new Actions(driver);
        actions.doubleClick(dobleClick).perform();

        Thread.sleep(1000);
        WebElement rightClick = driver.findElement(By.id("doubleClickBtn"));
        actions.contextClick(rightClick).perform();

          WebElement click = driver.findElement(By.xpath("//button[text()='Click Me']"));
          click.click();


    }
}
