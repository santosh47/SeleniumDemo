package Project.automationdemo;

import com.project.selenium.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegistorFormTest extends BaseClass {

    RegisterFormPage registerFormPage;

    @Parameters("browser")
    @Test(groups = {"smoke","sanity","regression"},invocationCount = 2,threadPoolSize = 2)
    public void username() throws InterruptedException {
        driver.get("https://demo.automationtesting.in/Register.html");
        registerFormPage = new RegisterFormPage();
        registerFormPage.enterFirstName("sntosh", "chavan", "203 colony", "sntos@gmail", "123456");
        Thread.sleep(3000);
    }
    @Test(groups = {"smoke","sanity","regression"},priority = 2)
    public void getgender() {
        registerFormPage.selectgender();
    }
    @Test(groups = {"smoke","sanity","regression"},priority = 4)
    public void setPassword() throws InterruptedException {
        registerFormPage.setPssword("test", "test");
        Thread.sleep(6000);

    }
    @Test(groups = {"smoke","sanity","regression"},priority = 3)
    public void gethobi() {
        registerFormPage.selectHobbbies();
        // registerFormPage.selectLanguage();
        WebElement submit = driver.findElement(By.xpath("//button[@id='submitbtn']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
        submit.click();
    }


    }
