package com.project.selenium.base;

import com.project.selenium.config.ConfigurationReader;
import com.project.selenium.config.PropertyFileReader;
import com.project.selenium.framework.Browser;
import com.project.selenium.util.PathHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;

public class Base {
	
	public static Logger log=Logger.getLogger(Base.class);
	
	public static WebDriver driver;
	public static ConfigurationReader reader;

	public String browserName;


@Parameters("browser")
	@Before
	public void setUp(Scenario scenario){
			this.browserName = browserName;
		log.info("Scenario Started: "+scenario.getName());
		PropertyConfigurator.configure(PathHelper.getResourcePath("/src/main/resources/ConfigurationFile/log4j.properties"));
		reader=new PropertyFileReader();
		Browser.startBrowser();
		Browser.maximize();

	}
	
	@After
	public void closeBrowser(Scenario scenario){
		if(scenario.isFailed()){
			//scenario.embed(Browser.takeScreenshot(), "image/png");
		}
		log.info("Scenario Completed: "+scenario.getName());
		log.info("Scenario Status is: "+scenario.getStatus());
		Base.driver.quit();
		}
	}


