package com.tutorialsninja.automation.test.Project1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Login {


    int time = 40;
    Duration duration = Duration.ofSeconds(time);

    WebDriver driver;
    //
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
    Random randomGenerator = new Random();

    @Test(priority = 1)
    public void login() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        //  Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Your Store"));


    }


    @Test(priority = 2)
    public void register() {
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Account']")));
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.xpath("//a[text()='Register']")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("santosh");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("document.getElementById('input-lastname').value='Chavan';");
        int randomInt = randomGenerator.nextInt(1000);
        driver.findElement(By.id("input-email")).sendKeys("Usernames" + randomInt + "@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("7411344278");
        driver.findElement(By.id("input-password")).sendKeys("Appzui@123");
        driver.findElement(By.id("input-confirm")).sendKeys("Appzui@123");

        List<WebElement> elementList = driver.findElements(By.xpath("//input[@type='radio']"));
        for (WebElement radio : elementList) {

            if (radio.getAttribute("value").equalsIgnoreCase("1")) {
                if (!radio.isSelected()) {
                    radio.click();
                }
            }
        }


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));

        driver.findElement(By.xpath("//input[@name='agree']")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();


        String actual = driver.findElement(By.xpath("//p[text()='Congratulations! Your new account has been successfully created!']")).getText();
        String expected = "Congratulations! Your new account has been successfully created!";
        Assert.assertEquals(expected, actual);


    }

    @Test(priority = -1)
    public void search() {

        driver.findElement(By.name("search")).sendKeys("C" + Keys.ENTER);
        WebElement webElement = driver.findElement(By.xpath("//select[@name='category_id']"));

        Select select = new Select(webElement);

        select.selectByValue("26");

        List<WebElement> webElement1 = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement element : webElement1) {
            if ((element.getAttribute("name")).equalsIgnoreCase("description")) {
                element.click();
            }
        }

        driver.findElement(By.id("button-search")).click();


    }

    @Test(priority = 3)

    public void component() throws InterruptedException {

        WebElement element = driver.findElement(By.xpath("//a[text()='Components']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();

        Thread.sleep(2000);

        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='list-unstyled']//li//a"));
        for (WebElement element1 : list) {
            if (element1.getText().equalsIgnoreCase("Monitors (2)")) {
                element1.click();
                break;
            }
        }

        Thread.sleep(5000);
        boolean displayed = driver.findElement(By.xpath("//h2[text()='Monitors']")).isDisplayed();

    }

    @Test(priority = 7)

    public void addToCart() throws InterruptedException {

        driver.findElement(By.name("search")).sendKeys("C" + Keys.ENTER);
        WebElement webElement = driver.findElement(By.xpath("//select[@name='category_id']"));

        Select select = new Select(webElement);

        select.selectByValue("26");

        driver.findElement(By.xpath("//img[@title='Apple Cinema 30\"']")).click();

        Thread.sleep(4000);


        List<WebElement> list = driver.findElements(By.xpath("//div[@class='radio']//label//input[@type='radio']"));
        System.out.println(list);
        for (WebElement element : list) {

            if (element.getAttribute("value").equalsIgnoreCase("5")) {

                element.click();
                break;
            }
        }

        WebElement txt = driver.findElement(By.id("input-option208"));
        txt.clear();
        txt.sendKeys("tesing");

        List<WebElement> chek = driver.findElements(By.xpath("//div[@class='checkbox']//label//input[@type='checkbox']"));

        for (int i = 0; i < chek.size(); i++) {
            {
                if (i > 1) {
                    {
                        chek.get(i).click();
                        break;
                    }

                }

            }

        }

        WebElement sel = driver.findElement(By.xpath("//select[@id='input-option217']"));
        Select select1 = new Select(sel);
        select1.selectByValue("1");
        driver.findElement(By.id("input-option209")).sendKeys("dbcdhhd");
        //  driver.findElement(By.id("button-upload222")).click();
        driver.findElement(By.id("button-upload222")).sendKeys("C:\\Users\\chava\\Downloads\\Data+Driven+Framework+Made+Easy+(Creating+and+Using)+-+Selenium+Java+POI+API.pdf");

    }

    @Test(priority = 8)
    public void calender() throws InterruptedException {
        LocalDate currentdate = LocalDate.now();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime time1 = LocalDateTime.now();

        System.out.println("Current date: " + currentdate);
        //Getting the current day
        int currentDay = currentdate.getDayOfMonth();
        System.out.println("Current day: " + currentDay);
        //Getting the current month
        Month currentMonth = currentdate.getMonth();
        System.out.println("Current month: " + currentMonth);
        //getting the current year
        int currentYear = currentdate.getYear();
        System.out.println("Current month: " + currentYear);

        LocalDate now = LocalDate.now();
        driver.findElement(By.xpath("//div[@class='input-group date']//button[@type='button']")).click();
        while (true) {
            String monthyear = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='picker-switch']")).getText();
            String arr[] = monthyear.split(" ");
            String mon = arr[0];
            String year = arr[1];
            if (mon.equalsIgnoreCase(String.valueOf(currentMonth)) && year.equalsIgnoreCase(String.valueOf(currentYear))) {
                break;
            } else
                driver.findElement(By.xpath("(//th[@class='next'][contains(text(),'›')])[1]")).click();
        }

        List<WebElement> date = driver.findElements(By.xpath("//table[@class='table-condensed']//tbody//tr//td"));
        for (WebElement element : date) {
            if (element.getText().equalsIgnoreCase(String.valueOf(currentDay))) {
                element.click();
                break;
            }
        }
        Thread.sleep(4000);
        Date currentDate = new Date();

        // Create a SimpleDateFormat object to format the time
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

        // Format the current date to get the time in "hh:mm" format
        String currentTime = dateFormat.format(currentDate);
       WebElement element= driver.findElement(By.name("option[221]"));
       element.clear();
        element.sendKeys(""+currentTime);
        Thread.sleep(4000);

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String currentTimeanddate = inputFormat.format(currentDate);
        WebElement element1 = driver.findElement(By.name("option[220]"));
        element.clear();
        element1.sendKeys(""+currentTimeanddate);
        WebElement element3 = driver.findElement(By.name("quantity"));
        element3.clear();
        element3.sendKeys("8");

        WebElement element4 = driver.findElement(By.id("button-cart"));
       element4.click();


    }

}

