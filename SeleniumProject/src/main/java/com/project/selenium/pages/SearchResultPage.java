package com.project.selenium.pages;

import com.project.selenium.actiondriver.Action;
import com.project.selenium.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BaseClass {
    @FindBy(xpath = "//*[@id=\"center_column\"]//img")
    private WebElement selectProduct;

    SearchResultPage(){
        PageFactory.initElements(driver,this);
    }
    public boolean isProductvailable(){
        return Action.isDisplayed(driver,selectProduct);
    }

    public AddToCartPage clickOnProduct(){
         Action.click(driver,selectProduct);
         return new AddToCartPage();
    }

}
