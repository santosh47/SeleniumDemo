package com.tutorialsninja.automation.pagesobjects;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Elements;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class AddressBookPage {

    public AddressBookPage() {
        PageFactory.initElements(Base.driver, this);
    }

    @FindBy(linkText = "Address Book")
    public static WebElement addressBook;

    @FindBy(linkText ="New Address" )
    private WebElement newAddressBook;

    @FindBy(xpath = "//input[@name=\'firstname\']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@name='company']")
    private WebElement company;

    @FindBy(xpath = "//input[@name='address_1']")
    private WebElement addressone;

    @FindBy(xpath = "//input[@name='address_2']")
    private WebElement addresstwo;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement city;

    @FindBy(xpath = "//input[@name='postcode']")
    private WebElement postCode;

    @FindBy(xpath = "//div/select[@id='input-country']")
    private WebElement country;

    @FindBy(id = "input-zone")
    private WebElement regionState;

    @FindBy(xpath = "//div/select[@id='input-zone']")
    private WebElement defaultAddress;

    @FindBy(xpath = "//input[@type='submit']")
    public static WebElement continueButton;


    @FindBy(xpath = "//div[text()='Your address has been successfully added']")
    public static WebElement message;





    public void addAddressBook() {

        Elements.click(addressBook);
        Elements.click(newAddressBook);

    }

    public void addAdressBookDetails(DataTable table,String value){

        Map<String,String> map = table.asMap(String.class,String.class);

        if(value.equals("valid"))
        {
            Elements.TypeText(firstName,map.get("FirstName"));
        }
        else if (value.equals("invalid"))
        {

        }
        else {
            Elements.TypeText(firstName,System.currentTimeMillis()+map.get("FirstName"));
        }

        Elements.TypeText(lastName,map.get("LastName"));
        Elements.TypeText(company,map.get("Company"));
        Elements.TypeText(addressone,map.get("Addressone"));
        Elements.TypeText(addresstwo,map.get("Adrresstwo"));
        Elements.TypeText(city,map.get("City"));
        Elements.TypeText(postCode,map.get("Postcode"));

        Duration waitDuration = Duration.ofSeconds(40);
        WebDriverWait wait =new WebDriverWait(Base.driver,waitDuration);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(regionState));
        Elements.selectByText(regionState,map.get("Region"));

        Elements.click(continueButton);

        // Elements.TypeText(defaultAddress,map.get("Default"))
    }
}