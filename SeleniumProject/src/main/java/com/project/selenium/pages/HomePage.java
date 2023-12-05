package com.project.selenium.pages;

import com.project.selenium.actiondriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.project.selenium.base.BaseClass.driver;

public class HomePage {


    @FindBy(xpath = " //span[text()='Order history and details']")
    private WebElement orderHistory;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    public boolean ValidateMyAccount(){
        return Action.isDisplayed(driver,orderHistory);
    }
   public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
