package com.tutorialsninja.automation.pages;

import com.tutorialsninja.automation.framework.Elements;
import io.cucumber.datatable.DataTable;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tutorialsninja.automation.base.Base;

import java.util.Map;

public class RegisterPage {


    public RegisterPage() {

        PageFactory.initElements(Base.driver,this);

    }

    @FindBy(xpath = "//span[text()='My Account']")
    public static WebElement myAccountLink;

    @FindBy(linkText = "Register")
    public static WebElement register;
    @FindBy(id="input-firstname")
    public static WebElement firstName;

    @FindBy(id="input-lastname")
    public static WebElement lastName;

    @FindBy(id="input-email")
    public static WebElement email;

    @FindBy(id="input-telephone")
    public static WebElement telephone;

    @FindBy(id="input-password")
    public static WebElement password;

    @FindBy(id="input-confirm")
    public static WebElement confirmPassword;



    @FindBy(xpath = "//input[@value='Continue']")
    public static WebElement ClickONContinue;

    @FindBy(xpath = "//input[@name='agree']")
    public static WebElement privacyPolicy;


@FindBy(xpath = "//ul[@class='breadcrumb']//a[normalize-space()='Register']")
public static WebElement registerLink;
    @FindBy(xpath = "//a[normalize-space()='Success']")
   public static WebElement successLink;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	public static WebElement warningMessages;

    @FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
    public static WebElement emaailWarning;
    public void enterAllRegistrationDetails(DataTable dataTable,String details) {

        Map<String,String> map = dataTable.asMap(String.class,String.class);
        Elements.TypeText(RegisterPage.firstName,map.get("FirstName"));
        Elements.TypeText(RegisterPage.lastName,map.get("LastName"));
        Elements.TypeText(RegisterPage.telephone,map.get("Telephone"));
        Elements.TypeText(RegisterPage.password,map.get("Password"));
        Elements.TypeText(RegisterPage.confirmPassword,map.get("Password"));

        if (details.equalsIgnoreCase("duplicate"))
        {
            Elements.TypeText(RegisterPage.email,map.get("Email"));
        }
        else
        {
            Elements.TypeText(RegisterPage.email,System.currentTimeMillis()+map.get("Email"));
        }


    }

}
