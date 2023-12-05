package com.tutorialsninja.automation.stepdef;

import com.project.selenium.base.BaseClass;
import com.project.selenium.pages.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.project.selenium.base.BaseClass.prop;

public class EndToEndTest extends BaseClass {
    IndexPage indexPage;
    OrderPage orderPage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;
    LoginPage loginPage;
    AddressPge addressPge;
    ShippingPage shippingPage;
    PayementPge payementPge;
    OrderSummaryPage orderSummaryPage;
    OrderConformationPage orderConformationPage;
    @Parameters("browser")
    @Test
    public void endToEndTest() throws Throwable {
        indexPage = new IndexPage();
        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct("t-shirt");
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity("2");
        addToCartPage.selectsize("M");
        addToCartPage.clickOnAddToCart();
        orderPage=addToCartPage.checkout();
        loginPage = orderPage.clickOnCheckout();
        addressPge = loginPage.UserLogin1(prop.getProperty("username"), prop.getProperty("password"));
        shippingPage = addressPge.clickOnCheckout();
        shippingPage.clickOnTerms();
        payementPge = shippingPage.ClickOnProceedToContinue();
        orderSummaryPage=payementPge.clickOnPaymentMethod();
        orderConformationPage = orderSummaryPage.confirmOrder();
        String actualMessage = orderConformationPage.validateConfirmMessage();
        String expectedMessge = "";
        Assert.assertEquals(actualMessage, expectedMessge);


    }
}
