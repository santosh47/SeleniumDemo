package com.tutorialsninja.automation.stepdef;

import com.project.selenium.base.BaseClass;
import com.project.selenium.pages.IndexPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IndexPageTest extends BaseClass {
    IndexPage indexPage;

    @Parameters("browser")
    @Test(groups = {"smoke", "sanity"})
    public void verifyLogo() {

        indexPage = new IndexPage();
        boolean result = indexPage.validateLogo();
        Assert.assertTrue(result);
    }

    @Test
    public void verifyTitle() {
        String title = indexPage.getMyStoreTitle();
        Assert.assertEquals(title, "My Shop");
    }
}



