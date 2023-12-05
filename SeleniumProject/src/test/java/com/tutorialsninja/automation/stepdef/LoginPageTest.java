package com.tutorialsninja.automation.stepdef;


import com.project.selenium.base.BaseClass;
import com.project.selenium.dataprovider.DataProviders;
import com.project.selenium.pages.HomePage;
import com.project.selenium.pages.IndexPage;
import com.project.selenium.pages.LoginPage;
import com.project.selenium.util.Log;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;
    @Parameters("browser")
    @Test(dataProvider = "credentials",dataProviderClass = DataProviders.class)
    public void loginTest(String userName,String password) throws Throwable{
        Log.startTestCase("Start Test");
        indexPage = new IndexPage();
        Log.info("userClicksonsignisbutton");
        loginPage = indexPage.clickOnSignIn();
        homePage = loginPage.UserLogin(userName,password);
        String acualurl = homePage.getCurrentUrl();
        String expctedurl = "http://www.automationpractice.pl/index.php?controller=my-account";
        Assert.assertEquals(acualurl, expctedurl);

    }
}
