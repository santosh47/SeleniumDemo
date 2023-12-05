package com.project.selenium.pages;

import com.project.selenium.actiondriver.Action;
import com.project.selenium.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends BaseClass {

    @FindBy(xpath = "//h1[text()='Create an account']")
    private WebElement txtCreateAcount;

    AccountCreationPage(){
        PageFactory.initElements(driver,this);
    }
    public boolean ValidateAccountCreatePage() throws Throwable{
         return Action.isDisplayed(driver,txtCreateAcount);
    }
}
