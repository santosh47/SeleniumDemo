package com.tutorialsninja.automation.pagesobjects.ekart;

import com.tutorialsninja.automation.actiondriver.Action;
import com.tutorialsninja.automation.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class IndexPage extends BaseClass {

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement btnSignIn;

    public IndexPage(){
        PageFactory.initElements(driver, this);
    }
    public LoginPage validateSignInButton(){
       Action.click(driver, btnSignIn);
       return new LoginPage();
    }
}
