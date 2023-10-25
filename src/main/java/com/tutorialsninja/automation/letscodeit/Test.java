package com.tutorialsninja.automation.letscodeit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class Test {

    WebDriver driver;
    static ExtentTest test;
    static ExtentReports report;

  @org.testng.annotations.Test
    public void SetUP() {
        ExtentReports reports=new ExtentReports();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.co.in");


        reports.createTest("test").log(Status.PASS,"test");
        reports.flush();

    }
    @org.testng.annotations.Test(priority = 2)
    public void radiobutton() {
        List<WebElement> radioButton = driver.findElements(By.xpath("//input[@type='radio']"));
        for (WebElement radio : radioButton) {

            String value = radio.getAttribute("value");
            System.out.println(value);
            if (radio.getAttribute("value").equalsIgnoreCase("BMW")) {
                radio.click();
            }
        }
    }


    @org.testng.annotations.Test(priority = 3)
    public void Checkbox() {
        List<WebElement> radioButton = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement radio : radioButton) {

            String value = radio.getAttribute("value");
            System.out.println(value);
            if (radio.getAttribute("value").equalsIgnoreCase("BMW")) {
                radio.click();
            }
        }
    }


    @org.testng.annotations.Test(priority = 4)
    public void windowhandle() {
        driver.findElement(By.xpath("//button[@id='openwindow']")).click();
        Set<String> id = driver.getWindowHandles();
        List<String> window = new ArrayList<>(id);
        String one= window.get(0);
        driver.switchTo().window(one);
int time=30;
Duration d= Duration.ofSeconds(time);
        WebDriverWait wait=new WebDriverWait(driver,d);

        }


    @org.testng.annotations.Test(priority = 5)
    public void select() {

        WebElement car = driver.findElement(By.xpath("//select[@id='carselect']"));
        Select sel = new Select(car);
        sel.selectByIndex(1);
       // sel.selectByValue("Honda");
    }

    @org.testng.annotations.Test(priority = 6)
    public void multi()
    {
        WebElement car = driver.findElement(By.xpath("//select[@id='multiple-select-example']"));
        Select sel = new Select(car);
        sel.selectByValue("apple");
        sel.selectByIndex(1);
        sel.isMultiple();
        sel.deselectByIndex(1);
        sel.getAllSelectedOptions();
        sel.deselectAll();
        for (WebElement option : sel.getOptions()   ) {
            sel.selectByValue(option.getAttribute("value"));
        }
    }

    @org.testng.annotations.Test(priority =7 )
    public void enabledisable()
    {
       WebElement enabled=driver.findElement(By.xpath("//input[@id='enabled-button']"));
       boolean enable=enabled.isEnabled();
       driver.findElement(By.xpath("//input[@id='enabled-example-input']")).sendKeys("hello");

        WebElement disab=driver.findElement(By.xpath("//input[@id='disabled-button']"));
        boolean dis=!disab.isEnabled();

    }

    @org.testng.annotations.Test(priority = 8)
    public void Hide()
    {
List<WebElement> ele=driver.findElements(By.xpath("//input[@type='submit']"));
for(WebElement webElement:ele)
{
    if(webElement.getAttribute("type").equalsIgnoreCase("hide"))
    {
        webElement.click();
    }

    if(webElement.getAttribute("type").equalsIgnoreCase("show"))
    {
                    webElement.click();
                    driver.findElement(By.xpath("//input[@id='displayed-text']")).sendKeys("hello");

    }

}


    }
@org.testng.annotations.Test(priority = 1)
    public void alert()
    {

      //  driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys("hello");
        //Javascript command
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('name').value='test';");

        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
       Alert alert=driver.switchTo().alert();
       alert.accept();

        driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
        alert.getText();
        alert.dismiss();


        }

        @org.testng.annotations.Test(priority = 2)

        public void autosugetion() throws InterruptedException {
            driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("aut");
            Thread.sleep(4000);

          List<WebElement> auto=driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
          for(WebElement ele:auto)
          {
              if(ele.getText().equalsIgnoreCase("WebDriverIO Automation"));

              {
                  int time=30;
                  Duration duration=Duration.ofSeconds(time);
                  //WebDriverWait wait=new WebDriverWait(driver,duration);
                //  wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//li[@class='ui-menu-item']/a")));
                  ele.click();
                  break;
              }
          }
        }


        @org.testng.annotations.Test(priority =1)
        public void mousehoer() throws InterruptedException {
            WebElement element = driver.findElement(By.xpath("//button[@id='mousehover']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[text()='Top']")).click();
            Thread.sleep(2000);
            actions.moveToElement(element).build().perform();
            driver.findElement(By.xpath(" //a[text()='Reload']")).click();


        }

        @org.testng.annotations.Test(priority = 1)
        public void datatable()
        {

          WebElement table=  driver.findElement(By.id("product"));
           WebElement tbody= driver.findElement(By.tagName("tbody"));


            int targetRow = 4; // Row 2 (0-based index)
            int targetColumn = 3; // Column 3 (0-based index)

            // Locate the cell in the target row and column
            WebElement targetCell = tbody.findElement(By.xpath(".//tr[" + targetRow + "]/td[" + targetColumn + "]"));

            // Get the price from the target cell
            String price = targetCell.getText();
            System.out.println("Price in Row 2, Column 3: " + price);




        }






@org.testng.annotations.Test(priority = 20)
    public void close()
    {
        driver.quit();
    }
}
