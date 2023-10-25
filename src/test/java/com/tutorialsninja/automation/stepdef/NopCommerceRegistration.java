package com.tutorialsninja.automation.stepdef;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.NopCommerce.NopCommerceRegisterPge;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.stream.BaseStream;

public class NopCommerceRegistration {
    NopCommerceRegisterPge nopCommerceRegisterPge=new NopCommerceRegisterPge();
    @When("User Registration")
    public void userRegistration() {

     nopCommerceRegisterPge.userRegistraion();

    }

    @And("User enters personal details")
    public void userEntersPersonalDetails(DataTable table) {
        nopCommerceRegisterPge.userPersonalDetails(table);
    }

    @And("User enters pssword confirmation")
    public void userEntersPsswordConfirmation(DataTable table) {
        nopCommerceRegisterPge.enterPssword(table);
    }

    @And("user enters  Account Details  <My company primaril> <My main activity in the company is> <Does your company have an existing online store> < What is your business model> <What is your business model> <How many people work for your company> <My company’s website>")
    public void userEntersAccountDetailsMyCompanyPrimarilMyMainActivityInTheCompanyIsDoesYourCompanyHaveAnExistingOnlineStoreWhatIsYourBusinessModelWhatIsYourBusinessModelHowManyPeopleWorkForYourCompanyMyCompanySWebsite(DataTable table) {


    }


    @And("user enters  compny primary Account Details  {string} {string} {string}  {string} {string}{string}")
    public void userEntersCompnyPrimaryAccountDetails(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
        nopCommerceRegisterPge.yourAccountDetails(arg0,arg1,arg3,arg4,arg5);
    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() {
        Elements.click(NopCommerceRegisterPge.myAccountLink);
        Elements.click(NopCommerceRegisterPge.login);
    }

    @And("user enters {string} and {string}")
    public void userEntersAnd(String arg0, String arg1) throws InterruptedException {
        nopCommerceRegisterPge.userlogin(arg0,arg1);

    }

    @And("user cliks on login button")
    public void userCliksOnLoginButton() {

        Elements.click(NopCommerceRegisterPge.loginButton);

    }

    @And("User clicks on register button")
    public void userClicksOnRegisterButton() throws InterruptedException {
        Elements.click(NopCommerceRegisterPge.registerButton);
        Thread.sleep(60000);
    }
}
