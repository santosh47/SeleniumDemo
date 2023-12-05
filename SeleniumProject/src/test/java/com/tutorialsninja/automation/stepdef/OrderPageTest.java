package com.tutorialsninja.automation.stepdef;

import com.project.selenium.base.BaseClass;
import com.project.selenium.dataprovider.DataProviders;
import com.project.selenium.pages.AddToCartPage;
import com.project.selenium.pages.IndexPage;
import com.project.selenium.pages.OrderPage;
import com.project.selenium.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseClass {

    IndexPage indexPage;
    OrderPage orderPage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;
    @Parameters("browser")
    @Test(dataProvider = "searchProduct",dataProviderClass = DataProviders.class,groups = {"smoke","sanity","regression"})
    public void VerifyProductPrice(String searhProd,String qnt,String size) throws Throwable {
        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct(searhProd);
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity(qnt);
        addToCartPage.selectsize(size);
        addToCartPage.clickOnAddToCart();
        orderPage = addToCartPage.checkout();
        Double unitPrice = orderPage.getunitPrice();
        Double totalPrice = orderPage.getTotalPrice();
        Double totaExpectedPrice=(unitPrice*2)+0;
        Assert.assertEquals(totalPrice,totaExpectedPrice);

    }
}
