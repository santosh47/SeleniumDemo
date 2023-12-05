package com.tutorialsninja.automation.stepdef;

import com.project.selenium.base.BaseClass;
import com.project.selenium.pages.IndexPage;
import com.project.selenium.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchResultPageTest extends BaseClass {
    IndexPage indexPage;

    SearchResultPage searchResultPage;
    @Parameters("browser")
    @Test
    public void ProductAvailabilityTest() {
        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct("t-shirt");
        boolean result = searchResultPage.isProductvailable();
        Assert.assertTrue(result);
    }
}
