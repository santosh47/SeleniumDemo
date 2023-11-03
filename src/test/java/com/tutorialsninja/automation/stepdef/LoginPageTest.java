package com.tutorialsninja.automation.stepdef;

import com.tutorialsninja.automation.base.BaseClass;
import com.tutorialsninja.automation.pagesobjects.practiceLoginPage;
import com.tutorialsninja.automation.test.datadriven.Datadriven;
import com.tutorialsninja.automation.test.dataprovider.DataProviders;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

    practiceLoginPage loginPage;
    @Parameters("browser")
    @Test(dataProvider = "credentials",dataProviderClass = DataProviders.class)
    public void loginTest(String username,String password) throws InterruptedException {
       loginPage=new practiceLoginPage();
      loginPage.loginTest(username, password);
    }
}
