package com.project.selenium.pages;

import com.project.selenium.actiondriver.Action;
import com.project.selenium.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    @FindBy(id="email")
    private WebElement txtUserEmail;
    @FindBy(id="passwd")
    private WebElement txtUserPassword;
    @FindBy (id="SubmitLogin")
    private WebElement btnClickSignIn;
    @FindBy(id="email_create")
    private WebElement txtUserNewEmail;
    @FindBy(id="SubmitCreate")
    private WebElement btnSubmitCreate;
    LoginPage(){
        PageFactory.initElements(driver,this);
    }
    public HomePage UserLogin(String userEmail, String userPassword){
        Action.type(txtUserEmail,userEmail);
        Action.type(txtUserPassword,userPassword);
        Action.click(driver,btnClickSignIn);
        return new HomePage();
    }
    public AddressPge UserLogin1(String userEmail, String userPassword){
        Action.type(txtUserEmail,userEmail);
        Action.type(txtUserPassword,userPassword);
        Action.click(driver,btnClickSignIn);
        return new AddressPge();
    }
    public AccountCreationPage CreatNewAccount(String UserNewEmail){
        Action.type(txtUserNewEmail,UserNewEmail);
        Action.click(driver,btnSubmitCreate);
        return new AccountCreationPage();
    }
}
