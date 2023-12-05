package Project.automationdemo;

import com.project.selenium.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RegisterFormPage extends BaseClass {
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
    Actions actions = new Actions(driver);
    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='radiooptions']")
    private List<WebElement> gender;

    @FindBy(xpath = "//input[@id='firstpassword']")
    WebElement password;


    public RegisterFormPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstName, String lname, String address, String mailAddress, String phoneNumber) {

        actions.moveToElement(firstNameInput).click().sendKeys(firstName).keyDown(Keys.TAB).sendKeys(lname).keyDown(Keys.TAB).sendKeys(address).keyDown(Keys.TAB).sendKeys(mailAddress).keyDown(Keys.TAB).sendKeys(phoneNumber)
                .build().perform();

    }

    public void selectgender() {

        List<WebElement> gender = driver.findElements(By.xpath("//div[@class='col-md-4 col-xs-4 col-sm-4']//label"));
        wait.until(ExpectedConditions.visibilityOfAllElements(gender));
        for (WebElement genlist : gender) {
            System.out.println(genlist.getText());
            if (genlist.getText().equalsIgnoreCase("Male")) {
                genlist.click();
                break;

            }
        }

    }

    public static void selectLanguage() {
        driver.findElement(By.xpath("//div[@id='msdd']")).click();
        List<WebElement> language = driver.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']//li"));
        wait.until(ExpectedConditions.visibilityOfAllElements(language));
        String[] valuesToSelect = {"Persian", "Polish"};


        // Iterate through the values and select the desired ones
        for (WebElement value : language) {
            String text = value.getText().trim();
            for (String valueToSelect : valuesToSelect) {
                if (text.equals(valueToSelect)) {
                    value.click();
                    break;
                }
            }
        }

    }

    public void setPssword(String passwor, String resetPassword) {
        actions.moveToElement(password).click().sendKeys(resetPassword).keyDown(Keys.TAB).sendKeys(passwor).build().perform();
    }

    public void selectHobbbies() {


        List<WebElement> hobbies = driver.findElements(By.xpath("//div[@class='col-md-4 col-xs-4 col-sm-4']//div[1]"));
        wait.until(ExpectedConditions.visibilityOfAllElements(hobbies));

        WebElement hobb = driver.findElement(By.xpath("//div[@class='col-md-4 col-xs-4 col-sm-4']//div[1]"));
        actions.moveToElement(hobb).click().build().perform();
        for (WebElement selechobbies : hobbies) {
            System.out.println(selechobbies.getText());
            if (selechobbies.getText().equalsIgnoreCase("Cricket")) {
                selechobbies.click();
                break;
            }
        }
    }

}
