package com.tutorialsninja.automation.stepdef;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.RegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.testng.Assert;

import java.util.Map;

public class Registration {

RegisterPage registerPage=new RegisterPage();
    @Given("I launch the application")
    public void i_launch_the_application() {
        Base.driver.get(Base.reader.getUrl());

    }

    @Given("I navigate to Account Registration page")
    public void i_navigate_to_account_registration_page() throws InterruptedException {
        Elements.click(RegisterPage.myAccountLink);
        Elements.click(RegisterPage.register);
        Thread.sleep(4000);
    }

    @When("I provide all the below valid details")
    public void i_provide_all_the_below_valid_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

        registerPage.enterAllRegistrationDetails(dataTable,"uniq");


    }

    @When("I select the Privacy Policy")
    public void i_select_the_privacy_policy() {

Elements.click(RegisterPage.privacyPolicy);
    }

    @When("I click on Continue button")
    public void i_click_on_continue_button() {
        Elements.click(RegisterPage.ClickONContinue);
    }

    @Then("I should see that the User Account has successfully created")
    public void i_should_see_that_the_user_account_has_successfully_created() {

        Assert.assertTrue(Elements.isDisplayed(RegisterPage.successLink));

    }

    @Then("I should see that the User Account is not created")
    public void iShouldSeeThatTheUserAccountIsNotCreated() {
     Assert.assertTrue(Elements.isDisplayed(RegisterPage.registerLink));

    }

    @And("I should see the error messages informing the user to fill the mandatory fields")
    public void iShouldSeeTheErrorMessagesInformingTheUserToFillTheMandatoryFields() {
        Assert.assertTrue(Elements.isDisplayed(RegisterPage.emaailWarning));
    }

    @Then("I should see the warning message stating that the user is already created")
    public void iShouldSeeTheWarningMessageStatingThatTheUserIsAlreadyCreated() {
      //Assert.assertFalse(Elements.VerifyTextEquals(RegisterPage.warningMessages,"Warning: E-Mail Address is already registered!"));
    }

    @When("I provide the below duplicate details into the fields")
    public void iProvideTheBelowDuplicateDetailsIntoTheFields(DataTable dataTable) {
        registerPage.enterAllRegistrationDetails(dataTable,"duplicate");

    }
}
