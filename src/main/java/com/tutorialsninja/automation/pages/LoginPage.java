package com.tutorialsninja.automation.pages;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Base.driver, this);


    }

    @FindBy(xpath = "//a[normalize-space()='Login']")
    public static WebElement loginLink;

    @FindBy(xpath = "//input[@id='input-email']")
    public static WebElement userNameTextField;

    @FindBy(xpath = "//input[@id='input-password']")
    public static WebElement userPasswordTextField;

    @FindBy(xpath = "//input[@value='Login']")
    public static WebElement loginButton;
    @FindBy(xpath = "//a[normalize-space()='Register for an affiliate account']")
    public static WebElement myAffiliateAccountLink;

    public void login(String email, String password) throws InterruptedException {

        Elements.click(RegisterPage.myAccountLink);
        Elements.click(LoginPage.loginLink);
        Thread.sleep(4000);
        Elements.TypeText(LoginPage.userNameTextField, email);
        Elements.TypeText(LoginPage.userPasswordTextField, password);

    }


    public void loginresuse(DataTable dataTable, String cred) throws InterruptedException {

        Map<String,String> map = dataTable.asMap(String.class,String.class);
        Elements.TypeText(LoginPage.userPasswordTextField,map.get("Validusername"));
        Elements.TypeText(LoginPage.userPasswordTextField,map.get("LastName"));
    }
}