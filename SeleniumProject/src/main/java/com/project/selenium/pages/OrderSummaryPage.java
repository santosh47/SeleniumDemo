package com.project.selenium.pages;

import com.project.selenium.actiondriver.Action;
import com.project.selenium.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage extends BaseClass {

    @FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
    WebElement confirmOrder;

    OrderSummaryPage(){
        PageFactory.initElements(driver,this);
    }

    public OrderConformationPage confirmOrder(){
        Action.click(driver,confirmOrder);
        return new OrderConformationPage();
    }
}
