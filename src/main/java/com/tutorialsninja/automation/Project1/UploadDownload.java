package com.tutorialsninja.automation.Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UploadDownload

{
    WebDriver driver;

    @Test
    public void uploadDownload() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        WebElement element = driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][1]"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        Thread.sleep(1000);
        WebElement upload = driver.findElement(By.xpath("//span[text()='Upload and Download']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", upload);
        upload.click();
        Thread.sleep(1000);

        WebElement download=driver.findElement(By.xpath("//a[@id='downloadButton']"));
        download.click();
        WebElement fileInput = driver.findElement(By.xpath("//input[@id='uploadFile']"));
        String filePath = "C:\\Users\\chava\\Downloads\\sampleFile (1).jpeg";
        fileInput.sendKeys(filePath);


    }
}
