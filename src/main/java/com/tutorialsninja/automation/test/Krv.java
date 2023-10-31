package com.tutorialsninja.automation.test;
import io.cucumber.java.en.Given;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.tutorialsninja.automation.base.Base;
import java.time.Duration;
import java.util.List;

public class Krv {
    @Given("url")
    public void url() throws InterruptedException {
        Base.driver.get("https://kerv.com/careers-at-kerv/");
        Thread.sleep(4000);


        JavascriptExecutor js = (JavascriptExecutor) Base.driver;

        Thread.sleep(4000);

        Base.driver.findElement(By.xpath("//*[@id=\"BorlabsCookieBox\"]/div/div/div/div[1]/div/div/div/p[2]/a")).click();

        Thread.sleep(4000);
        try {

            WebElement elementToHover = Base.driver.findElement(By.xpath("(//div[@class='navbar__link navbar__link--root navbar__link--has-children'])[6]"));


            Actions actions = new Actions(Base.driver);


            actions.moveToElement(elementToHover).build().perform();


        } catch (NoSuchElementException e) {

            System.out.println("Element not found.");
        }


        Base.driver.findElement(By.xpath("//div[@class='navbar__sub-big-list']//a[normalize-space()='Job Opportunities']")).click();
        Thread.sleep(400);

        WebElement element = Base.driver.findElement(By.xpath("//div[normalize-space()='Filter your search:']"));


        JavascriptExecutor js1 = (JavascriptExecutor) Base.driver;


        js1.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});", element);

        Thread.sleep(4000);
        int time = 10;
        Duration duration = Duration.ofSeconds(time);

        Base.driver.findElement(By.xpath("//button[normalize-space()='Location']")).click();
        String desiredText = "United Kingdom"; // Replace with the text you want to find and click
        WebDriverWait wait = new WebDriverWait(Base.driver, duration); // Maximum wait time in seconds
        // Wait for a list of elements matching the specified criteria (e.g., XPath)
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='search-filters']//ul//li//button")));

        WebElement selectedElement = elements.get(2);
        System.out.println(selectedElement);




        Thread.sleep(4000);





       selectedElement.click();

        Thread.sleep(4000);

        Base.driver.findElement(By.xpath("//button[normalize-space()='Type']")).click();
        List<WebElement> tyep = Base.driver.findElements(By.xpath("//ul[@class='search-filters__group-items']//li//button"));



        WebElement selecttype = elements.get(0);



        selectedElement.click();

        Thread.sleep(4000);

        Base.driver.findElement(By.xpath("//div[@class='search-filters__group-heading']//button[@type='button'][normalize-space()='Remote']")).click();
        List<WebElement> Remot = Base.driver.findElements(By.xpath("//ul[@class='search-filters__group-items']//li//button"));



        WebElement selectRemot = elements.get(0);



        selectedElement.click();

        Thread.sleep(4000);


        WebElement search=Base.driver.findElement(By.xpath("//input[@placeholder='Search vacancies here']"));
        search.sendKeys("Senior Test Engineer’");
        search.sendKeys(Keys.ENTER);
        String expectedReasult="Test Engineer (Manual)";
        WebElement searchReasult=Base.driver.findElement(By.xpath("(//div[@class='search-results__title'])[1]"));
        searchReasult.getText();
        if (searchReasult.equals(expectedReasult))
        {
            System.out.println("searfound");
        }
    }
}

