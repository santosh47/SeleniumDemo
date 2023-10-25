package com.tutorialsninja.automation.stepdef;

import com.tutorialsninja.automation.base.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

import static com.tutorialsninja.automation.Project1.Form.getRandomElement;

public class Bdd {


  public Bdd(){

  PageFactory.initElements(Base.driver, this);
}








@Given("Enter random numbers bddtes")
    public void bddtest(Map<String, String> map)
  {
    ////driver=new ChromeDriver();
    Base.driver.get("https://www.facebook.com/");

    WebElement firstName= Base.driver.findElement(By.xpath("//input[@id='email']"));
   // Map<String,String> map=table.asMap(String.class,String.class);
    String[] firstNames = {
            "Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Henry", "Ivy", "Jack"
    };

    String userFirstName=getRandomElement(firstNames);


    //firstName.sendKeys(userFirstName);
    firstName.clear();
    firstName.sendKeys(map.get("number"));
    //driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(map.get());
  //  driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]")).sendKeys();


  }


  @Given("Enter random number {string} bdd test")
  public void enterRandomNumberBddTest(String arg) {

    //driver=new ChromeDriver();
    Base.driver.get("https://www.facebook.com/");

    WebElement firstName= Base.driver.findElement(By.xpath("//input[@id='email']"));
    String[] firstNames = {
            "Alice", "Bob", "Charlie", "David", "Eva", "Frank", "Grace", "Henry", "Ivy", "Jack"
    };

    String userFirstName=getRandomElement(firstNames);


    // firstName.sendKeys(userFirstName);
    firstName.sendKeys(arg);

  }

  @Given("user enter username and password")
  public void enterUsernameAndPassword(Map<String, String> dataTable) throws InterruptedException {

    Base.driver.get("https://www.facebook.com/");



    try {
      for (Map.Entry<String, String> entry : dataTable.entrySet()) {
        String username = entry.getKey();
        String password = entry.getValue();

        // Skip entering keys if values are null or empty
        if (username != null && !username.isEmpty()) {
          WebElement firstName= Base.driver.findElement(By.xpath("//input[@id='email']"));
          firstName.sendKeys(username);
          firstName.clear();
          Thread.sleep(200);
        }

      }
    } finally {
      Base.driver.quit();
    }
  }
}















