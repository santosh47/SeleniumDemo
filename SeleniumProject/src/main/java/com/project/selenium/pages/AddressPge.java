package com.project.selenium.pages;

import com.project.selenium.actiondriver.Action;
import com.project.selenium.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPge extends BaseClass {

    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    WebElement proceedToCheckOut;

    AddressPge(){
        PageFactory.initElements(driver,this);
    }
    public ShippingPage clickOnCheckout(){
        Action.click(driver,proceedToCheckOut);
        return new ShippingPage();
    }
}
