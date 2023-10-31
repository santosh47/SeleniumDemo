package com.tutorialsninja.automation.test.Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.tutorialsninja.automation.framework.Elements.scrollDownByPixel;


public class LoginDemoQa {
    WebDriver driver;

    @Test(priority = 1)
    public void elements() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");

        WebElement element = driver.findElement(By.xpath("//div[@class='card mt-4 top-card'][1]"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        Thread.sleep(4000);

    }


    @Test(priority = 5)
    public void checkbox() throws InterruptedException {

        int time = 40;
        Duration duration = Duration.ofSeconds(time);

        driver.findElement(By.xpath("//span[text()='Check Box']")).click();
        WebElement elements1 = driver.findElement(By.xpath(" (//button[@type='button' and @class='rct-collapse rct-collapse-btn'])[1]"));
        elements1.click();
        Thread.sleep(2000);
        WebElement elements6 = driver.findElement(By.xpath("//li[3]//span[1]//button[1]//*[name()='svg']"));
        Thread.sleep(2000);
        elements6.click();
        Thread.sleep(2000);
        WebElement downloads = driver.findElement(By.xpath("//label[@for='tree-node-downloads']//span[@class='rct-checkbox']//*[name()='svg']"));
        downloads.click();


        // WebElement elements1 = driver.findElement(By.xpath(" (//button[@type='button' and @class='rct-collapse rct-collapse-btn'])[1]"));
        // elements1.click();
        Thread.sleep(2000);

        List<WebElement> homeCheckBox = driver.findElements(By.xpath("//span[@class='rct-text']//input[@type='checkbox']"));
        WebDriverWait wait = new WebDriverWait(driver, duration);
        WebElement homeCheckBox1 = driver.findElement(By.xpath("(//span[@class='rct-text']//input[@type='checkbox'])[1]"));
        // wait.until(ExpectedConditions.visibilityOf(homeCheckBox1));
        WebElement svgElement = driver.findElement(By.xpath("//label[@for='tree-node-desktop']//span[@class='rct-checkbox']//*[name()='svg']"));
        svgElement.click();


        WebElement elements2 = driver.findElement(By.xpath(" (//button[@type='button' and @class='rct-collapse rct-collapse-btn'])[2]"));
        elements2.click();
        Thread.sleep(2000);

        WebElement document = driver.findElement(By.xpath("//label[@for='tree-node-documents']//span[@class='rct-checkbox']//*[name()='svg']"));
        document.click();
        Thread.sleep(2000);


        WebElement elements3 = driver.findElement(By.xpath(" (//button[@type='button' and @class='rct-collapse rct-collapse-btn'])[3]"));

        elements3.click();
        Thread.sleep(2000);


        WebElement elements5 = driver.findElement(By.xpath(" (//button[@type='button' and @class='rct-collapse rct-collapse-btn'])[5]"));
        Thread.sleep(2000);
        elements5.click();


    }

    @Test(priority = 6)
    public void webtable() throws InterruptedException {
        int time = 40;
        Duration duration = Duration.ofSeconds(time);
        WebElement element = driver.findElement(By.xpath("//span[text()='Web Tables']"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

        Thread.sleep(5000);


        // Assuming targetRow and targetColumn are 2 (1-based index)
        int targetRow = 2;
        int targetColumn = 2;


// Find the target cell using provided XPath
        WebElement table = driver.findElement(By.xpath("//div[@class='rt-tbody']"));

        WebElement table1 = driver.findElement(By.xpath(".//div[@class='rt-tr-group'][2]//div[@class='rt-td'][2]"));


        WebElement targetCell = driver.findElement(By.xpath(".//div[@class='rt-tr-group'][" + targetRow + "]//div[@class='rt-td'][" + targetColumn + "]"));

// Get the content of the target cell
        String cellText = targetCell.getText();
        System.out.println("Content of Row " + targetRow + ", Column " + targetColumn + ": " + cellText);


    }

    @Test(priority = 3)
    public void sort() throws InterruptedException {


                try {

                    WebElement element=driver.findElement(By.xpath("//div[normalize-space()='Interactions']"));


                    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                    javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
                    element.click();

                    Thread.sleep(4000);

                    driver.findElement(By.xpath("//span[normalize-space()='Sortable']")).click();


                    List<WebElement> listItems = driver.findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));



                    // Create an instance of Actions class
                    Actions actions = new Actions(driver);

                    // Drag and drop elements to sort
                    actions.clickAndHold(listItems.get(0))
                            .moveToElement(listItems.get(3))
                            .release()
                            .perform();

                    Thread.sleep(5000);

                    // Get the sorted list of text
                    List<String> sortedText = listItems.stream()
                            .map(WebElement::getText)
                            .collect(Collectors.toList());

                    // Print the sorted text
                    System.out.println("Sorted Elements:");
                    for (String text : sortedText) {
                        System.out.println(text);
                    }
                } finally {
                    Thread.sleep(5000);
                    driver.quit();
                }
            }


            @Test(priority = 3)
            public void gridsort() throws InterruptedException {



                            WebElement element=driver.findElement(By.xpath("//div[normalize-space()='Interactions']"));


                            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                            javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
                            element.click();

                            Thread.sleep(4000);

                            driver.findElement(By.xpath("//span[normalize-space()='Sortable']")).click();

                            WebElement gridTab = driver.findElement(By.id("demo-tab-grid"));
                            gridTab.click();

                            // Find all grid items
                            List<WebElement> gridItems = driver.findElements(By.xpath("//div[@id='demo-tabpane-grid']//div[@class='list-group-item list-group-item-action']"));

                            // Create an instance of Actions
                            Actions actions = new Actions(driver);

                            // Perform drag-and-drop to sort the grid items
                            actions.clickAndHold(gridItems.get(1))
                                    .moveToElement(gridItems.get(3))  // Change the target element as needed
                                    .release()
                                    .perform();
                Thread.sleep(4000);

                            // Verify if the items are sorted
                            boolean isSorted = isGridSorted(driver);
                            if (isSorted) {
                                System.out.println("Sorting successful.");
                            } else {
                                System.out.println("Sorting not successful.");
                            }
                        }


                    // Function to check if the grid is sorted
                    private static boolean isGridSorted(WebDriver driver) {
                        List<WebElement> gridItems = driver.findElements(By.cssSelector(".grid-item"));
                        for (int i = 0; i < gridItems.size() - 1; i++) {
                            String text1 = gridItems.get(i).getText();
                            String text2 = gridItems.get(i + 1).getText();
                            if (text1.compareTo(text2) > 0) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
