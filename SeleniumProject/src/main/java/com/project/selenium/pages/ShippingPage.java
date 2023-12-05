package com.project.selenium.pages;

import com.project.selenium.actiondriver.Action;
import com.project.selenium.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BaseClass {
    @FindBy(xpath = "//input[@id=\"cgv\"]")
    WebElement termService;
    @FindBy(xpath = "//button/span[contains(text(),'Proceed to checkout')]")
    WebElement proceedToCheckOut;

    ShippingPage(){
        PageFactory.initElements(driver,this);
    }
    public void clickOnTerms(){
        Action.click(driver,proceedToCheckOut);
    }
    public PayementPge ClickOnProceedToContinue() throws Throwable{
        Action.click(driver,termService);
        Action.click(driver,proceedToCheckOut);
        return new PayementPge();
    }
}

