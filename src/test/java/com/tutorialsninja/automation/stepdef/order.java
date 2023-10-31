package com.tutorialsninja.automation.stepdef;

import com.tutorialsninja.automation.pagesobjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class order {
LoginPage loginPage=new LoginPage();
    @Given("login to application")
    public void login_to_application() throws InterruptedException {

    }

    @When("I add any product to Bag and checkout")
    public void iAddAnyProductToBagAndCheckout() {

    }

    @And("I place an order")
    public void iPlaceAnOrder() {

    }

    @Then("I should see that the order is placed successfully")
    public void iShouldSeeThatTheOrderIsPlacedSuccessfully() {
    }
}
