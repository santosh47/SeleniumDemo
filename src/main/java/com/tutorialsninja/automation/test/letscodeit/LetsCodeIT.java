package com.tutorialsninja.automation.test.letscodeit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.Set;

import java.util.List;

public class LetsCodeIT {


    @Test
   public void radioButton()
   {

            // Set the path to the ChromeDriver executable
            //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            WebDriverManager.chromedriver().setup();

            // Create a WebDriver instance (assuming Chrome)
            WebDriver driver = new ChromeDriver();

            // Navigate to the webpage containing the radio buttons
            String url = "https://www.letskodeit.com/practice";
            driver.get(url);

            // Locate the div element with class "left-align" and id "radio-btn-example"
            WebElement radioDiv = driver.findElement(By.id("radio-btn-example"));


            // Find all radio buttons inside the div
            List<WebElement> radioButtons = radioDiv.findElements(By.tagName("input"));

            // Choose a specific radio button (e.g., "BMW") by value
            String targetRadioValue = "bmw";
            for (WebElement radio : radioButtons) {
                if (radio.getAttribute("value").equals(targetRadioValue)) {
                    radio.click();
                    break;
                }
            }

            // Alternatively, you can choose a specific radio button by its ID
            // String targetRadioId = "bmwradio";
            // driver.findElement(By.id(targetRadioId)).click();

            // Check if the selected radio button is now selected
            WebElement selectedRadio = driver.findElement(By.cssSelector("input[name='cars']:checked"));
            System.out.println("Selected Radio Button Value: " + selectedRadio.getAttribute("value"));

            // Close the browser window
            driver.quit();
        }


        @Test
        public void checkbox()
        {


                    WebDriverManager.chromedriver().setup();

                    // Create a WebDriver instance (assuming Chrome)
                    WebDriver driver = new ChromeDriver();

                    // Navigate to the webpage containing the checkboxes
                    String url = "https://www.letskodeit.com/practice";
                    driver.get(url);

                    // Locate the div element with class "cen-align" and id "checkbox-example-div"
                    WebElement checkboxDiv = driver.findElement(By.id("checkbox-example-div"));

                    // Find all checkboxes inside the div
                    List<WebElement> checkboxes = checkboxDiv.findElements(By.tagName("input"));

                    // Check a specific checkbox (e.g., "BMW") by value
                    String targetCheckboxValue = "bmw";
                    for (WebElement checkbox : checkboxes) {
                        if (checkbox.getAttribute("value").equals(targetCheckboxValue)) {
                            checkbox.click();
                            break;
                        }
                    }

                    // Alternatively, you can check a specific checkbox by its ID
                    // String targetCheckboxId = "bmwcheck";
                    // driver.findElement(By.id(targetCheckboxId)).click();

                    // Check if the selected checkbox is now checked
                    WebElement selectedCheckbox = driver.findElement(By.cssSelector("input[value='" + targetCheckboxValue + "']"));
                    if (selectedCheckbox.isSelected()) {
                        System.out.println(selectedCheckbox.getAttribute("value") + " checkbox is checked.");
                    } else {
                        System.out.println(selectedCheckbox.getAttribute("value") + " checkbox is not checked.");
                    }

                    // Close the browser window
                    driver.quit();
                }


                @Test
                public void windowHandle()
                {

                    WebDriverManager.chromedriver().setup();

                    // Create a WebDriver instance (assuming Chrome)
                    WebDriver driver = new ChromeDriver();

                    // Navigate to the webpage containing the checkboxes
                    String url = "https://www.letskodeit.com/practice";
                    driver.get(url);

                            // Locate the button inside the div
                            WebElement openWindowButton = driver.findElement(By.id("openwindow"));

                            // Click the "Open Window" button
                            openWindowButton.click();

                            // Get the current window handle (parent window)
                            String parentWindowHandle = driver.getWindowHandle();

                            // Get all window handles (parent and child windows)
                            Set<String> windowHandles = driver.getWindowHandles();

                            // Switch to the new window (child window)
                            for (String windowHandle : windowHandles) {
                                if (!windowHandle.equals(parentWindowHandle)) {
                                    driver.switchTo().window(windowHandle);
                                    break;
                                }
                            }

                            // Now you are in the child window. You can perform actions in this window.
                            // For example, you can get the current URL of the child window:
                            String childWindowURL = driver.getCurrentUrl();
                            System.out.println("Child Window URL: " + childWindowURL);

                            // Close the child window
                            driver.close();

                            // Switch back to the parent window
                            driver.switchTo().window(parentWindowHandle);

                            // You are back in the parent window now.

                            // Close the browser window
                            driver.quit();
                        }


                        @Test
                        public void tab()
                        {


                            WebDriverManager.chromedriver().setup();

                            // Create a WebDriver instance (assuming Chrome)
                            WebDriver driver = new ChromeDriver();

                            // Navigate to the webpage containing the checkboxes
                            String url = "https://www.letskodeit.com/practice";
                            driver.get(url);


                                    // Locate the anchor (link) inside the div
                                    WebElement openTabLink = driver.findElement(By.id("opentab"));

                                    // Get the URL of the link
                                    String linkURL = openTabLink.getAttribute("href");

                                    // Get the current window handle (parent window)
                                    String parentWindowHandle = driver.getWindowHandle();

                                    // Open the link in a new tab
                                    openTabLink.click();

                                    // Get all window handles (parent and child windows)
                                    Set<String> windowHandles = driver.getWindowHandles();

                                    // Switch to the new tab (child tab)
                                    for (String windowHandle : windowHandles) {
                                        if (!windowHandle.equals(parentWindowHandle)) {
                                            driver.switchTo().window(windowHandle);
                                            break;
                                        }
                                    }

                                    // Now you are in the child tab. You can perform actions in this tab.
                                    // For example, you can get the current URL of the child tab:
                                    String childTabURL = driver.getCurrentUrl();
                                    System.out.println("Child Tab URL: " + childTabURL);

                                    // Close the child tab
                                    driver.close();

                                    // Switch back to the parent window
                                    driver.switchTo().window(parentWindowHandle);

                                    // You are back in the parent window now.

                                    // Close the browser window
                                    driver.quit();
                                }



                                @Test
                                public void enableDisable()
                                {


                                    WebDriverManager.chromedriver().setup();

                                    // Create a WebDriver instance (assuming Chrome)
                                    WebDriver driver = new ChromeDriver();

                                    // Navigate to the webpage containing the checkboxes
                                    String url = "https://www.letskodeit.com/practice";
                                    driver.get(url);
driver.manage().window().maximize();
                                            // Locate the elements with the appropriate locators
                                            WebElement enabledElement = driver.findElement(By.id("enabled-element"));
                                            WebElement disabledElement = driver.findElement(By.id("disabled-element"));

                                            // Check if the elements are enabled or disabled
                                            boolean isEnabled = enabledElement.isEnabled();
                                            boolean isDisabled = !disabledElement.isEnabled();

                                            // Output the results
                                            System.out.println("Is Enabled Element Enabled? " + isEnabled);
                                            System.out.println("Is Disabled Element Disabled? " + isDisabled);

                                            // Close the browser window
                                            driver.quit();
                                        }
@Test
                                        public void dataTable()
    {

        WebDriverManager.chromedriver().setup();

        // Create a WebDriver instance (assuming Chrome)
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage containing the checkboxes
        String url = "https://www.letskodeit.com/practice";
        driver.get(url);
                // Locate the table element with ID "product"
                WebElement table = driver.findElement(By.id("product"));

                // Find the rows and columns in the table
                WebElement tbody = table.findElement(By.tagName("tbody"));
                // Assuming all rows have the same number of columns (td elements)
                int targetRow = 2; // Row 2 (0-based index)
                int targetColumn = 2; // Column 3 (0-based index)

                // Locate the cell in the target row and column
                WebElement targetCell = tbody.findElement(By.xpath(".//tr[" + targetRow + "]/td[" + targetColumn + "]"));

                // Get the price from the target cell
                String price = targetCell.getText();
                System.out.println("Price in Row 2, Column 3: " + price);

                // Close the browser window
                driver.quit();
            }


            @Test
            public void enableDisableTest() throws InterruptedException {
                WebDriverManager.chromedriver().setup();

                // Create a WebDriver instance (assuming Chrome)
                WebDriver driver = new ChromeDriver();

                // Navigate to the webpage containing the checkboxes
                String url = "https://www.letskodeit.com/practice";
                driver.get(url);
                driver.manage().window().maximize();
                        // Find the disabled input element with ID "enabled-example-input"
                        WebElement inputElement = driver.findElement(By.id("enabled-example-input"));

                        // Use JavaScript Executor to enable the input field
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("arguments[0].removeAttribute('disabled');", inputElement);

                        // Now the input field is enabled, you can type text into it
                        inputElement.sendKeys("This is the typed text.");

                        Thread.sleep(4000);
                        // Close the browser window
                        driver.quit();
                    }
                }
