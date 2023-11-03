package com.tutorialsninja.automation.base;

import com.tutorialsninja.automation.util.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author Santosh: BaseClass is used to load the config file and Initialize
 * WebDriver
 */
public class BaseClass {
    public static Properties prop;

    // Declare ThreadLocal Driver
    //public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static WebDriver driver;
    //loadConfig method is to load the configuration
    // @BeforeSuite(groups = {"Smoke", "Sanity", "Regression"})
    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("Chrome") String browserName) throws IOException {

        ExtentManager.setExtent();
        DOMConfigurator.configure("log4j.xml");

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "\\Configuration\\config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new EdgeDriver();
        }
        //Maximize the screen
        driver.manage().window().maximize();
        //Delete all the cookies
        driver.manage().deleteAllCookies();
        //Implicit TimeOuts
        driver.manage().timeouts().implicitlyWait
                (Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
        //PageLoad TimeOuts
        driver.manage().timeouts().pageLoadTimeout
                (Integer.parseInt(prop.getProperty("pageLoadTimeOut")), TimeUnit.SECONDS);
        //Launching the URL
        driver.get(prop.getProperty("url"));
    }

    // @AfterSuite(groups = {"Smoke", "Regression", "Sanity"})
    @AfterClass
    public void afterSuite() {
        ExtentManager.endReport();
        driver.quit();
    }
}
