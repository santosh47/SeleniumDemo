package com.project.selenium.pages;

import com.project.selenium.actiondriver.Action;
import com.project.selenium.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BaseClass {
    @FindBy(id = "quantity_wanted")
    WebElement quantity;
    @FindBy(id = "group_1")
    WebElement size;

    @FindBy(xpath = "//button//span[text()='Add to cart']")
    WebElement addToCartbtn;

    @FindBy(xpath = "//*[@id='layer_cart']//h2//i")
    WebElement addTocartMessage;

    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    WebElement checkout;

    AddToCartPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterQuantity(String quantity1) {
        Action.type(quantity, quantity1);
    }

    public void selectsize(String size1) throws Throwable {
        Action.selectByVisibleText(size1, size);
    }

    public void clickOnAddToCart() throws Throwable {
        Action.click(driver, addToCartbtn);
    }

    public boolean validateAddtoCart() throws Throwable {
        Action.fluentWait(addTocartMessage, 10);
        return Action.isDisplayed(driver, addTocartMessage);

    }

    public OrderPage checkout() throws Throwable {
        Action.fluentWait(addTocartMessage, 20);
        Action.JSClick(driver, checkout);
        Action.fluentWait(checkout, 10);
        return new OrderPage();
    }
}
