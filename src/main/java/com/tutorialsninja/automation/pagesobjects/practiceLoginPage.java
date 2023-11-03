package com.tutorialsninja.automation.pagesobjects;

import com.tutorialsninja.automation.actiondriver.Action;
import com.tutorialsninja.automation.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class practiceLoginPage extends BaseClass {

    static Action action = new Action();
    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    public static WebElement btnSignIn;
    @FindBy(id = "email")
    static
    WebElement email;
    @FindBy(id = "passwd")
    static
    WebElement password;
    @FindBy(id = "SubmitLogin")
    static
    WebElement btnClickOnsignIn;
    public practiceLoginPage() {
        PageFactory.initElements(driver, this);
    }
    public static void loginTest(String txt, String pass) throws InterruptedException {

        action.click(driver, btnSignIn);
        action.type(email, txt);
        action.type(password, pass);
        Thread.sleep(50);
        action.click(driver, btnClickOnsignIn);

    }
}
