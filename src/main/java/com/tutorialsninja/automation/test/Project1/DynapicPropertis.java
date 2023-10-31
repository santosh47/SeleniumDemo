package com.tutorialsninja.automation.test.Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynapicPropertis {
    WebDriver driver;

    @Test
    public void dynamicProperties() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        WebElement element = driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][1]"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        Thread.sleep(1000);
        WebElement dynamic = driver.findElement(By.xpath("//span[text()='Dynamic Properties']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", dynamic);
        dynamic.click();
        Thread.sleep(1000);
        WebElement linkElement = driver.findElement(By.xpath("//button[@id='enableAfter']"));
        linkElement.click();
        int time = 10;
        Duration duration = Duration.ofSeconds(time);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.elementToBeClickable(linkElement));
        linkElement.click();
        Thread.sleep(4000);
        WebElement button = driver.findElement(By.id("colorChange")); /* Click the button to change its color *//* button.click();// Wait for the color change to occur (assuming color change is asynchronous) You might need to use some other */
        String script = "arguments[0].style.color = 'yellow';"; /* Change 'red' to the desired color */
        javascriptExecutor.executeScript(script, button);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String initialColor = button.getCssValue("color"); /* Execute JavaScript to periodically check for color change */
        for (int i = 0; i < 10; i++) {
            String currentColor = (String) javascriptExecutor.executeScript(script, button);
            if (!initialColor.equals(currentColor)) {
                System.out.println("Color has changed!");
                break;
            }
            try {
                Thread.sleep(1000); /* Wait for 1 second before checking again */
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        WebElement visible = driver.findElement(By.xpath("//button[@id='visibleAfter']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='visibleAfter']")));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", visible);
        visible.click();
    }
}
