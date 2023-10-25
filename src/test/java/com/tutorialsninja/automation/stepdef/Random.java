package com.tutorialsninja.automation.stepdef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static com.tutorialsninja.automation.Project1.Form.getRandomElement;

public class Random {
    WebDriver driver;
    @Given("Enter random number {string}")
    public void enterRandomNumber(String arg0) throws InterruptedException {
        driver=new ChromeDriver();
        driver.get("https://demoqa.com/");
        WebElement element = driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][2]"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        Thread.sleep(1000);
        WebElement form = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", form);
        form.click();
        Thread.sleep(1000);

        String[] firstNames = {
                "Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Henry", "Ivy", "Jack"
        };

        String[] lastNames = {
                "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"
        };

        WebElement firstName=driver.findElement(By.id("firstName"));
        firstName.clear();
        String userFirstName=getRandomElement(firstNames);
        firstName.sendKeys(userFirstName);

    }

    @Given("Enter random numbers")
    public void enterRandomNumberNumber(DataTable table) throws InterruptedException {
        driver=new ChromeDriver();
        driver.get("https://demoqa.com/");
        WebElement element = driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][2]"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        Thread.sleep(1000);
        WebElement form = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", form);
        form.click();
        Thread.sleep(1000);

        String[] firstNames = {
                "Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Henry", "Ivy", "Jack"
        };

        String[] lastNames = {
                "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"
        };

        WebElement firstName=driver.findElement(By.id("firstName"));
        firstName.clear();
        String userFirstName=getRandomElement(firstNames);
        firstName.sendKeys(userFirstName);


    }
}
