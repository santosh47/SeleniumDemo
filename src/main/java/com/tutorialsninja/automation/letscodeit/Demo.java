package com.tutorialsninja.automation.letscodeit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Demo {
    WebDriver driver;

    @Test()
    public void setUp() {
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seleniumbase.io/demo_page");

    }

    @Test(priority = 25)
    public void close() {
        driver.quit();
    }

    @Test(priority = 1)
    public void textBox() {
        WebElement element = driver.findElement(By.id("myTextInput"));
        element.sendKeys("text");
        element.clear();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.getElementById('myTextInput').value='santosh';");

        driver.findElement(By.id("myTextInput2")).clear();
        executor.executeScript("document.getElementById('myTextInput2').value='santos';");

        try {
            Thread.sleep(5000); // Pause for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.executeScript("document.getElementById('textareaName').value='myTextInput2myTextInput2myTextInput2myTextInput2';");

        // Pause for debugging purposes (in milliseconds)
        try {
            Thread.sleep(5000); // Pause for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.executeScript("document.getElementById('textareaName').value='myTextInput2myTextInput2myTextInput2myTextInput2';");

        try {
            Thread.sleep(5000); // Pause for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.executeScript("document.getElementById('placeholderText').value='myTextInput2myTextInput2myTextInput2myTextInput2';");

        try {
            Thread.sleep(5000); // Pause for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(driver.findElement(By.id("readOnlyText")).getAttribute("value"));

    }

    @Test(priority = 3)
    public void slidercontroler() {
        WebElement element = driver.findElement(By.id("mySlider"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).moveByOffset(50, 0).release().perform();
    }

    @Test(priority = 4)
    public void progressbar() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("document.getElementById('progressBar').value=70;");
        try {
            Thread.sleep(3000); // Pause for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5)
    public void voiddrop() throws InterruptedException {
        WebElement element = driver.findElement(By.id("mySelect"));
        Select select = new Select(element);
        select.selectByIndex(1);
        select.selectByValue("25%");

        Thread.sleep(5000);

        List<WebElement> elements = driver.findElements(By.xpath("//input[@type='radio']"));
        for (WebElement element1 : elements) {
            if (element1.getAttribute("name").equalsIgnoreCase("radioGroup1")) {
                if (!element1.isSelected()) {
                    element1.click();
                    break;


                }
            }


        }

    }


    @Test(priority = 7)
    public void checkbox() {


        WebElement element = driver.findElement(By.id("checkBox5"));

        if (!element.isSelected()) {
            element.click();

        }

        element.click();
    }


    @Test(priority = 8)
    public void multicheckbox() throws InterruptedException {


        List<WebElement> element = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement element1 : element) {

            element1.click();

Thread.sleep(900);
        }
    }
}