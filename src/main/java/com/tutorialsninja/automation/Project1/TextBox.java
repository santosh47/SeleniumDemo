package com.tutorialsninja.automation.Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Random;

public class TextBox {
    WebDriver driver;

    @Test
    public void textBox() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        WebElement element = driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][1]"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        Thread.sleep(1000);
        WebElement textbox = driver.findElement(By.xpath("//span[text()='Text Box']"));
        textbox.click();
        Thread.sleep(1000);
        WebElement fullName = driver.findElement(By.id("userName"));
        String fulName = "santosh chavan";
        javascriptExecutor.executeScript("arguments[0].value=arguments[1];", fullName, fulName);
        WebElement email = driver.findElement(By.id("userEmail"));
        Random random = new Random();
        int intemail = random.nextInt(1000);
        javascriptExecutor.executeScript("arguments[0].value=arguments[1];", email, "username" + intemail + "@gmail.com");

        String text = getAlphaNumericString(60);
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        javascriptExecutor.executeScript("arguments[0].value=arguments[1];", currentAddress, text);

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        javascriptExecutor.executeScript("arguments[0].value=arguments[1];", permanentAddress, text);

        WebElement submit = driver.findElement(By.xpath("//button[@type='button' and text()='Submit']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", submit);
        submit.click();


    }

    static String getAlphaNumericString(int n) {

        // choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
    private static String generateRandomAddress() {
        String[] streets = {"123 Main St", "456 Elm St", "789 Oak Ave", "987 Pine Rd"};
        String[] cities = {"New York", "Los Angeles", "Chicago", "Houston"};
        String[] states = {"CA", "NY", "IL", "TX"};
        String[] zips = {"12345", "67890", "54321", "98765"};

        Random random = new Random();

        String street = streets[random.nextInt(streets.length)];
        String city = cities[random.nextInt(cities.length)];
        String state = states[random.nextInt(states.length)];
        String zip = zips[random.nextInt(zips.length)];

        return street + ", " + city + ", " + state + " " + zip;
    }

}








