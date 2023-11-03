package com.tutorialsninja.automation.stepdef.ekartcomerce;

import com.tutorialsninja.automation.pagesobjects.ekart.HomePage;
import com.tutorialsninja.automation.pagesobjects.ekart.IndexPage;
import com.tutorialsninja.automation.pagesobjects.ekart.LoginPage;
import com.tutorialsninja.automation.test.dataprovider.DataProviders;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IndexPageTest {
    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;
    @Parameters("browser")
    @Test(dataProvider = "credentials",dataProviderClass = DataProviders.class)
    public void loginTest(String username, String password) {
        indexPage = new IndexPage();
        loginPage = indexPage.validateSignInButton();
        loginPage.loginTest(username, password);
    }
}
