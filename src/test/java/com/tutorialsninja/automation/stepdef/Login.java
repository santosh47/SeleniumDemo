package com.tutorialsninja.automation.stepdef;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.framework.Waits;
import com.tutorialsninja.automation.pages.LoginPage;
import com.tutorialsninja.automation.pages.RegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

import java.time.Duration;

public class Login {

    LoginPage loginPage=new LoginPage();


    @And("I naviage to Account Login page")

    public void iNaviageToAccountLoginPage() throws InterruptedException {

        Waits.waitUntilElementLocated(Duration.ofDays(10),RegisterPage.myAccountLink);

        Elements.click(RegisterPage.myAccountLink);
        Elements.click(LoginPage.loginLink);
        Thread.sleep(4000);
    }

    @When("I login to the application using Username {string} and Password {string}")
    public void iLoginToTheApplicationUsingUsernameAndPassword(String email, String password) throws InterruptedException {
        loginPage.login(email,password);
        Elements.click(LoginPage.loginButton);

    }

    @Then("I should see that the User is able to successfully login")
    public void iShouldSeeThatTheUserIsAbleToSuccessfullyLogin() {
    Assert.assertTrue(Elements.isDisplayed(LoginPage.myAffiliateAccountLink));
    }


    @Then("Should display error message  No match for E-Mail Address Password.")
    public void shouldDisplayErrorMessageNoMatchForEMailAddressAndOrPassword() {
        String errorMessage=Elements.getText(RegisterPage.warningMessages);
        Assert.assertFalse(Elements.VerifyTextEquals(RegisterPage.warningMessages,"Warning: No match for E-Mail Address and/or Password."));

    }

    @When("I login to the application using Username and Password")
    public void iLoginToTheApplicationUsingUsernameAndPassword(io.cucumber.datatable.DataTable dataTable) throws InterruptedException{

        loginPage.loginresuse(dataTable,"valid");
    }

}
