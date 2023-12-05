package com.project.selenium.pages;

import com.project.selenium.actiondriver.Action;
import com.project.selenium.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayementPge extends BaseClass {

    @FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
    WebElement clickOnBankWireMethod;

    @FindBy(xpath = "//a[contains(text(),'Pay by check')]")
    WebElement getClickOnBankCheckMethod;

    public OrderSummaryPage clickOnPaymentMethod(){
        Action.click(driver,getClickOnBankCheckMethod);
        return new OrderSummaryPage();
    }

}
