package com.tutorialsninja.automation.test.Project1;


import com.tutorialsninja.automation.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Pagination {

    WebDriver driver;

    @Test
    public void paginationTable() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://datatables.net/examples/basic_init/zero_configuration.html");
        List<WebElement> list = driver.findElements(By.xpath(".//div//table//tr/td[1]"));
        List<String> text = list.stream().map(s -> s.getText()).collect(Collectors.toList());
        System.out.println(text);
        List<String> sorted = text.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted);
       // Assert.assertEquals(text, sorted);
        List<String> price=list.stream().filter(s->s.getText().contains("Cedric Kelly")).map(s->getprice(s)).collect(Collectors.toList());
        price.forEach(s->System.out.println(s));




    }

    public static String getprice(WebElement s) {

        String pricevalue = s.findElement(By.xpath("./following-sibling::td[1]")).getText();
        System.out.println(pricevalue);
        return pricevalue;

    }
}
