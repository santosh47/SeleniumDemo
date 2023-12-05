package com.project.selenium.base;

import com.project.selenium.util.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class BaseClass {
    public static Properties prop;
    public static WebDriver driver;
    public String browserName;


    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("Chrome") String browserName) throws IOException {
        this.browserName = browserName;
        ExtentManager.setExtent();
        DOMConfigurator.configure("log4j.xml");

        prop = new Properties();
        FileInputStream ip = new FileInputStream(
                System.getProperty("user.dir") + "\\Configuration\\config.properties");
        prop.load(ip);

        // Your other setup code remains the same.
        if (this.browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (this.browserName.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (this.browserName.equalsIgnoreCase("IE")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    @AfterClass
    public void afterSuite() {
        ExtentManager.endReport();
        driver.quit();
    }
}
