package com.tutorialsninja.automation.stepdef;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.pagesobjects.AddressBookPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddressBook {

    AddressBookPage addressBook;

    @And("User clicks on AddressBook")
    public void User_clicks_on_AddressBook(){
    addressBook=new AddressBookPage();
    addressBook.addAddressBook();
    }

    @And("User enters the address details")
    public void userEntersTheAddressDetails(DataTable table) {

        addressBook.addAdressBookDetails(table,"valid");
        Duration waitDuration = Duration.ofSeconds(40);
        WebDriverWait wait =new WebDriverWait(Base.driver,waitDuration);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AddressBookPage.message));
        Assert.assertTrue(AddressBookPage.message.isDisplayed());
    }

    @And("User enters the address invalid details")
    public void userEntersTheAddressInvalidDetails(DataTable table) {


        addressBook.addAdressBookDetails(table,"invalid");
        Duration waitDuration = Duration.ofSeconds(40);
        WebDriverWait wait =new WebDriverWait(Base.driver,waitDuration);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AddressBookPage.message));
        Assert.assertTrue(AddressBookPage.message.isDisplayed());
    }

    @And("User enters the address empty details")
    public void userEntersTheAddressEmptyDetails(DataTable table) {
        addressBook.addAdressBookDetails(table,"empty");
        Duration waitDuration = Duration.ofSeconds(40);
        WebDriverWait wait =new WebDriverWait(Base.driver,waitDuration);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(AddressBookPage.message));
        Assert.assertTrue(AddressBookPage.message.isDisplayed());
    }
}
