package com.tutorialsninja.automation.stepdef;

import com.project.selenium.base.BaseClass;
import com.project.selenium.pages.HomePage;
import com.project.selenium.pages.IndexPage;
import com.project.selenium.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;


    @Test(groups = {"smoke","sanity","regression"})
    public void orderHistoryDetailsTest() throws Throwable {
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignIn();
        homePage = loginPage.UserLogin(prop.getProperty("username"), prop.getProperty("password"));
        boolean result = homePage.ValidateMyAccount();
        Assert.assertTrue(result);
    }
}
