package com.project.selenium.pages;

import com.project.selenium.actiondriver.Action;
import com.project.selenium.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BaseClass {

    @FindBy(xpath = "//a[@class='login']")
    private WebElement btnSignInLogin;
    @FindBy(xpath = "//img[@class='logo img-responsive']")
    private WebElement logoMyStore;

    @FindBy(id = "search_query_top")
    private  WebElement btnSeacrh;
    @FindBy(name = "submit_search")
    private WebElement searchBtnClick;

    public IndexPage(){
        PageFactory.initElements(driver,this);
    }
    public LoginPage clickOnSignIn() {
            Action.click(driver,btnSignInLogin);
            return new LoginPage();
    }
    public boolean validateLogo(){
        return Action.isDisplayed(driver,logoMyStore);
    }
    public String getMyStoreTitle(){
       return driver.getTitle();
    }
    public SearchResultPage searchProduct(String ProductName){
        Action.type(btnSeacrh,ProductName);
        Action.click(driver,searchBtnClick);
        return new SearchResultPage();
    }


}