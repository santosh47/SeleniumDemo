package com.tutorialsninja.automation.Project1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Form {

    WebDriver driver;

    @Test
    public void form() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.clear();
        String userFirstName = getRandomElement(firstNames);
        firstName.sendKeys(userFirstName);


        WebElement lastName = driver.findElement(By.id("lastName"));

        lastName.clear();
        String userLastName = getRandomElement(lastNames);
        lastName.sendKeys(userLastName);

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        Random random = new Random();int intemail = random.nextInt(1000);
        javascriptExecutor.executeScript("arguments[0].value=arguments[1];", userEmail, "username" + intemail + "@gmail.com");

        WebElement userNumber = driver.findElement(By.id("userNumber"));

        userNumber.clear();

        String phoneNumber = generatePhoneNumber();
        userNumber.sendKeys(phoneNumber);

        List<WebElement> gender = driver.findElements(By.xpath("//label[@class='custom-control-label']"));
        Thread.sleep(4000);
        int time = 10;
        Duration duration = Duration.ofSeconds(time);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        //wait.until(ExpectedConditions.visibilityOf((WebElement) gender));

        System.out.println(gender);
        for (WebElement ele : gender) {
            if (ele.getText().equalsIgnoreCase("Female")) ;
            {

                // JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                // jsExecutor.executeScript("arguments[0].click();", ele);


                ele.click();
                break;
            }
        }

        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", dob);

        dob.sendKeys(Keys.ENTER);
        dob.click();
        WebElement month = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", month);
        Select select = new Select(month);
        select.selectByVisibleText("August");
        Thread.sleep(2000);
        dob.click();
        Thread.sleep(2000);
        dob.click();
        WebElement year = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", year);
        Select select1 = new Select(year);
        select1.selectByValue("1990");

        List<WebElement> date = driver.findElements(By.xpath("//*[@class='react-datepicker__week']//*"));

        LocalDate currentdate = LocalDate.now();
        int currentDay = currentdate.getDayOfMonth();
        System.out.println("Current day: " + currentDay);

        System.out.println("date:" + date);
        for (WebElement elements : date) {
            if (elements.getText().equalsIgnoreCase(String.valueOf(currentDay))) {
                elements.click();
                break;
            }

        }
        List<WebElement> elements = driver.findElements(By.xpath("//label[contains(@for,'hobbies-checkbox')]"));
        for (WebElement checkbox : elements) {
            String txt = checkbox.getText();
            System.out.println("checkbox:" + txt);
            if (checkbox.getText().equalsIgnoreCase("Music")) {
                checkbox.click();
                break;



            }
        }
        String path = "C:\\Users\\chava\\Downloads\\sampleFile (4).jpeg";
        driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys(path);

        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("textarea");


        driver.findElement(By.xpath("//input[@id='subjectsInput']")).sendKeys("s");

        List<WebElement> auto = driver.findElements(By.xpath("//div[@class='subjects-auto-complete__menu-list subjects-auto-complete__menu-list--is-multi css-11unzgr']//div"));

        for (WebElement autocmp : auto) {
            String txt = autocmp.getText();
            System.out.println("autocmp:" + txt);
            if (autocmp.getText().equalsIgnoreCase("Physics")) {
                autocmp.click();
                break;
            }

        }
    }

    public static String getRandomElement(String[] array) {
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }

    public static String generatePhoneNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // The first digit should not be 0 or 1 to ensure it's a valid area code
        sb.append(random.nextInt(8) + 2);

        // Generate the remaining 9 digits
        for (int i = 0; i < 9; i++) {
            sb.append(random.nextInt(10)); // Generates a random digit (0-9)
        }

        return sb.toString();
    }
}


