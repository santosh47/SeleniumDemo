package com.tutorialsninja.automation.pages.NopCommerce;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.framework.Waits;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Map;

public class NopCommerceRegisterPge {

    public NopCommerceRegisterPge() {

        PageFactory.initElements(Base.driver, this);
    }

    @FindBy(xpath = "//span[@class='user-actions-ico']//*[name()='svg']")
    public static WebElement myAccountLink;

    @FindBy(xpath = "//span[normalize-space()='Register']")
    public static WebElement register;

    @FindBy(xpath = "//span[normalize-space()='Log in']")
    public static WebElement login;

    @FindBy(id = "FirstName")
    public static WebElement firstName;

    @FindBy(id = "LastName")
    public static WebElement lastName;

    @FindBy(id = "Email")
    public static WebElement email;

    @FindBy(id = "ConfirmEmail")
    public static WebElement confirmEmail;

    @FindBy(id = "Username")
    public static WebElement userName;

    @FindBy(id = "check-availability-button")
    public static WebElement checkAvailability;

    @FindBy(id = "Password")
    public  static  WebElement password;

    @FindBy(id = "ConfirmPassword")
    public static WebElement confirmPassword;

    @FindBy(xpath  ="//select[@id='Details_CompanyIndustryId']")
    public static WebElement accounrDetails;


    @FindBy(id = "Username")
   public static WebElement userLoginName;

    @FindBy(id = "Password")
    public static WebElement userLoginPassword;

    @FindBy(xpath = "//input[@type='submit']")
    public static WebElement loginButton;

    @FindBy(xpath ="//input[@id='register-button']")
    public static WebElement registerButton;
    public void userRegistraion() {


        Elements.click(myAccountLink);
        Waits.waitUntilElementLocated(Duration.ofDays(10), login);
        Elements.click(register);


    }

    public void userPersonalDetails(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        Elements.TypeText(firstName, map.get("Firstname"));
        Elements.TypeText(lastName, map.get("Lastname"));
        Elements.TypeText(email, map.get("Email"));
        Elements.TypeText(confirmEmail, map.get("Confirmemail"));
        Elements.TypeText(userName, map.get("Username"));
        Elements.click(checkAvailability);
    }

    public void enterPssword(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        Elements.TypeText(password, map.get("pssword"));
        Elements.TypeText(confirmPassword, map.get("confirmpassword"));
    }
    public void yourAccountDetails(String s,String s2,String s3,String s4,String s5)
    {
      //  Map<String, String> map = dataTable.asMap(String.class, String.class);

        Elements.selectByIndex(accounrDetails,1);
        Elements.selectByIndex(accounrDetails,1);
        Elements.selectByIndex(accounrDetails,1);
        Elements.selectByIndex(accounrDetails,1);
        Elements.selectByIndex(accounrDetails,1);
        Elements.selectByIndex(accounrDetails,1);

    }

    public void userlogin(String uname,String password) throws InterruptedException {

        Elements.TypeText(userLoginName,uname);
        Elements.TypeText(userLoginPassword,password);

    }
}