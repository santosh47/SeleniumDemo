package com.tutorialsninja.automation.stepdef;

import com.project.selenium.base.BaseClass;
import com.project.selenium.pages.AccountCreationPage;
import com.project.selenium.pages.AddToCartPage;
import com.project.selenium.pages.IndexPage;
import com.project.selenium.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddToCartPageTest extends BaseClass {
    IndexPage indexPage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;
    @Parameters("browser")
    @Test
    public void addToCartPageTest() throws Throwable {
        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct("t-shirt");
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity("2");
        addToCartPage.selectsize("M");
        addToCartPage.clickOnAddToCart();
        boolean result = addToCartPage.validateAddtoCart();
        Assert.assertTrue(result);
    }
}
