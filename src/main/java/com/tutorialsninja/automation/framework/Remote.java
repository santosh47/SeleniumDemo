package com.tutorialsninja.automation.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Remote {


    @Test
    public void runRemote() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome"); // Use "firefox" for Firefox
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.43.128:54321"),capabilities);
        driver.get("http://www.google.com");
        driver.quit();
    }
}
