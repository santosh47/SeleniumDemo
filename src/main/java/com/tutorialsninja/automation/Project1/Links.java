package com.tutorialsninja.automation.Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.List;

public class Links {

    WebDriver driver;

    @Test
    public void link() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        WebElement element = driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][1]"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        Thread.sleep(1000);
        WebElement Links = driver.findElement(By.xpath("//span[text()='Links']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", Links);
        Links.click();
        Thread.sleep(1000);


        WebElement linkElement = driver.findElement(By.id("no-content"));

        // Get the href attribute of the link
        String linkHref = linkElement.getAttribute("href");

        // Verify the response of the link
        verifyLinkResponse(linkHref);


        WebElement notFound = driver.findElement(By.xpath("//a[@id='invalid-url']"));

        // Get the href attribute of the link
        String linkHrefnotfound = linkElement.getAttribute("href");

        // Verify the response of the link
        verifyLinkResponse(linkHrefnotfound);

        List<WebElement> linkElements = driver.findElements(By.tagName("a"));

        // Iterate through the links and verify their responses
        for (WebElement linkElementall : linkElements) {
            String linkHrefall = linkElement.getAttribute("href");
            verifyLinkResponse(linkHrefall);
        }


    }

    private static void verifyLinkResponse(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000); // Set timeout for the connection

            // Get the response code
            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Link is working fine. Response code: " + responseCode);
            } else {
                System.out.println("Link is broken. Response code: " + responseCode);
            }

        } catch (IOException e) {
            System.out.println("Exception occurred while verifying link: " + e.getMessage());
        }
    }
}


