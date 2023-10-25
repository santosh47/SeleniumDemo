package com.tutorialsninja.automation.stepdef;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.tutorialsninja.automation.base.Base;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.stream.BaseStream;

public class Letskodit {

WebDriver driver;
    @Test
    public void radio() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();

      Base.driver.get("https://www.letskodeit.com/practice");
      //  driver.get("");
        List<WebElement> radio = Base.driver.findElements(By.xpath("//*[@type=\"radio\"]"));


        int Size = radio.size();                // finding the number of Radio buttons

        for (int i = 0; i < Size; i++)                      // starts the loop from first Radio button to the last one
        {
            String val = radio.get(i).getAttribute("value");
            // Radio button name stored to the string variable, using 'Value' attribute

            if (val.equalsIgnoreCase("BMW"))   // equalsIgnoreCase is ignore case(upper/lower)
            {                 // selecting the Radio button if its value is same as that we are looking for
                radio.get(i).click();
                //  break;
            }

            if (radio.get(i).isSelected()) {
                System.out.println("Radio button 1 is selected");
            } else {
                System.out.println("Radio button 1 is not selected");
            }

            // select another radio button by clicking on it
            radio.get(i).isSelected();

            // check if the first radio button is no longer selected
            if (!radio.get(i).isSelected()) {
                System.out.println("Radio button 1 is not selected");
            }


            // check if the third radio button is selected
            if (radio.get(i).isSelected()) {
                System.out.println("Radio button 3 is selected");
            }


        }
    }


    @Test
    public void dropdown() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
        //Selecting an option by visible text:
// locate the dropdown element
        WebElement dropdown = driver.findElement(By.id("carselect"));

// create a Select object
        Select select = new Select(dropdown);

// select an option by visible text
        select.selectByVisibleText("Benz");

        // select an option by value attribute
        // select.selectByValue("value1");

// select an option by index (starting from 0)
        select.selectByIndex(2);
        WebElement selectedOption = select.getFirstSelectedOption();
        String text = selectedOption.getText();
        System.out.println(text);
// get all options
        List<WebElement> options = select.getOptions();

// iterate over the options and print their text
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        boolean isMultiple = select.isMultiple();
        System.out.println(isMultiple);

    }


    @Test
    public void multiselect() {
//Multi slect

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");

        WebElement dropdownmulti = driver.findElement(By.id("multiple-select-example"));

// create a Select object
        Select select = new Select(dropdownmulti);
        if (select.isMultiple()) {

            // select multiple options by visible text
            //select.selectByVisibleText("Apple");
            //select.selectByVisibleText("Orange");

            // or select multiple options by value attribute
            // select.selectByValue("Apple");
            //select.selectByValue("Orange");

            // or select multiple options by index
            //  select.selectByIndex(3);
            //select.selectByIndex(4);


            // get all selected options
            List<WebElement> selectedOptions = select.getAllSelectedOptions();

            // iterate over the selected options and print their text
            for (WebElement option : selectedOptions) {
                System.out.println(option.getText());
            }

            // deselect all options
            select.deselectAll();

        } else {
            System.out.println("This dropdown does not support multiple selections.");
        }
    }


    @Test
    public void datatable() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");


        // locate the data table element
        WebElement dataTable = driver.findElement(By.id("table-example-div"));

// get the number of rows in the table
        List<WebElement> rows = dataTable.findElements(By.tagName("tr"));
        int numRows = rows.size();

// get the number of columns in the table
        List<WebElement> columns = rows.get(0).findElements(By.tagName("td"));
        int numColumns = columns.size();
        for (WebElement row : rows) {
            // get the columns in the current row
            List<WebElement> columns1 = row.findElements(By.tagName("td"));
            // iterate over the columns in the current row
            for (WebElement column : columns) {
                // do something with the column data
                System.out.println(column.getText());
            }
        }
        // locate the link or button element in the desired row
        WebElement link = driver.findElement(By.xpath("//tr[2]/td[2]"));
        System.out.println(link);


    }

    @Test
    public void enabledisable() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
        // locate the button element
        WebElement button = driver.findElement(By.id("enabled-button"));

// check if the button is disabled
        if (!button.isEnabled()) {
            // enable the button
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].removeAttribute('disabled')", button);
        }


// check if the button is enabled
        if (button.isEnabled()) {
            // disable the button
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].setAttribute('disabled', 'disabled')", button);
        }


    }

    @Test

    public void mousehover() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
        // locate the web element to hover over


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        WebElement element = driver.findElement(By.id("mousehover"));

// create an instance of the Actions class
        Actions actions = new Actions(driver);

// hover over the element
        actions.moveToElement(element).perform();

        Thread.sleep(5000);


        // locate the menu item to hover over
        WebElement menu = driver.findElement(By.xpath("//a[normalize-space()='Reload']"));
        actions.moveToElement(menu).click().perform();

    }

    @Test
    public void windowhandle() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");

        // Store the ID of the original window
        String originalWindow = driver.getWindowHandle();

// Perform an action that opens a new window
        driver.findElement(By.xpath("//button[@id='openwindow']")).click();

// Wait for the new window or tab to open
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

// Loop through the window handles and switch to the new window
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

// Perform actions on the new window
// ...

// Switch back to the original window
        driver.switchTo().window(originalWindow);

    }


    @Test
    public void autosugetion() {

// Navigate to the web page
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");
// Locate the input field and enter the search term
        WebElement inputField = driver.findElement(By.xpath("//input[@id='autosuggest']"));
        inputField.sendKeys("test");

// Wait for the auto-suggestion dropdown menu to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("suggestions")));

// Retrieve the list of suggestions and extract the text of each suggestion
        List<WebElement> suggestionList = dropdownMenu.findElements(By.tagName("li"));
        for (WebElement suggestion : suggestionList) {
            System.out.println(suggestion.getText());
        }

    }

}
