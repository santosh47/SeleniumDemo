package com.tutorialsninja.automation.stepdef;

import com.project.selenium.base.BaseClass;
import com.project.selenium.pages.AccountCreationPage;
import com.project.selenium.pages.IndexPage;
import com.project.selenium.pages.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AccountCretionPageTest extends BaseClass {
    IndexPage indexPage;
    LoginPage loginPage;
    AccountCreationPage accountCreationPage;

    @Parameters("browser")
    @Test(groups = {"smoke","sanity"})
    public void accountCreationTest() throws Throwable {
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignIn();
        accountCreationPage = loginPage.CreatNewAccount("test157@xyz.com");
        accountCreationPage.ValidateAccountCreatePage();

    }
}
