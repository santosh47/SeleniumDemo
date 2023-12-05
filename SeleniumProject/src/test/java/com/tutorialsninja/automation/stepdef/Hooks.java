package com.tutorialsninja.automation.stepdef;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.project.selenium.base.Base;
import  com.project.selenium.config.PropertyFileReader;
import  com.project.selenium.framework.Browser;
import  com.project.selenium.util.PathHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
public class Hooks {
	private static Logger log = Logger.getLogger(Hooks.class);
	
	@Before
	public void setUp(Scenario scenario){
	PropertyConfigurator.configure(PathHelper.getResourcePath("/src/main/resources/ConfigurationFile/log4j.properties"));
	log.info("Scenario Started: "+scenario.getName());
	Base.reader=new PropertyFileReader();
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
