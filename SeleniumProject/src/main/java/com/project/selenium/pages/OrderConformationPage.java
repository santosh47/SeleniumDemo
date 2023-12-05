package com.project.selenium.pages;

import com.project.selenium.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConformationPage extends BaseClass {
    OrderConformationPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[contains(text(),'Your order on My Shop is complete.')]")
    WebElement confirmMessage;

    public String validateConfirmMessage(){
        String confirmMsg=confirmMessage.getText();
        return confirmMsg;
    }

}
