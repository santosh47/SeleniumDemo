package com.project.selenium.selenium;

import org.openqa.selenium.JavascriptExecutor;

import static com.project.selenium.base.Base.driver;

public class Selenium {


    public void javascript() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        JavascriptExecutor in Selenium to click a button

        js.executeScript("document.getElementByID(‘element id ’).click();");


//        JavascriptExecutor in Selenium to send text

        js.executeScript("document.getElementByID(‘element id ’).value = ‘xyz’;");

//        JavascriptExecutor in Selenium to interact with checkbox


        js.executeScript("document.getElementByID(‘element id ’).checked=false;");

//        JavascriptExecutor in Selenium to refresh the browser window
        js.executeScript("location.reload()");

    }


}
