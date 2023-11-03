package com.tutorialsninja.automation.pagesobjects.ekart;

import com.tutorialsninja.automation.actiondriver.Action;
import com.tutorialsninja.automation.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass {

    @FindBy(id="email")
    WebElement email;

    @FindBy(id="passwd")
    WebElement password;

    @FindBy(xpath = "//span//i[@class='icon-lock left']")
    WebElement btncliclOnSignIn;

    public HomePage loginTest(String useremail, String userPassword){
        Action.type(email,useremail);
        Action.type(password,userPassword);
        Action.click(driver,btncliclOnSignIn);
        return new HomePage();
    }
}
