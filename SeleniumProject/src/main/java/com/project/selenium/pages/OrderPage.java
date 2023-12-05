package com.project.selenium.pages;

import com.project.selenium.actiondriver.Action;
import com.project.selenium.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BaseClass {

    @FindBy(xpath = "//td[@class='cart_unit']//ul//li")
    WebElement unitPrize;
    @FindBy(xpath = "//td[@id='total_price_container']//span[@id='total_price']")
    WebElement totalPrize;

    @FindBy(xpath = "//span[text()='Proceed to checkout']")
    WebElement checkOut;

    OrderPage() {
        PageFactory.initElements(driver, this);
    }

    public double getunitPrice() {
        Action.fluentWait(unitPrize, 10);
        String unitprice1 = unitPrize.getText();
        String unit = unitprice1.replace("[^\\d.]", "");
        try {
            double finalUnitPrice = Double.parseDouble(unit);
            return finalUnitPrice / 100;
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public double getTotalPrice() {
        String Totalprice1 = totalPrize.getText();
        String total = Totalprice1.replace("[^\\d.]", "");
        try {
            double finaltotalPrice = Double.parseDouble(total);
            return finaltotalPrice / 100;
        }catch (NumberFormatException e){
            return 0.0;
        }
    }

    public LoginPage clickOnCheckout() {
        Action.click(driver, checkOut);
        return new LoginPage();

    }
}
