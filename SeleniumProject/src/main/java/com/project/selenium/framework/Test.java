package com.project.selenium.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Test {
	

	public static void main(String[] args) {
	WebDriver driver;
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
	driver.manage().window().maximize();
	driver.get("http://toolsqa.com/automation-practice-form/");
	
	JavascriptExecutor exe=((JavascriptExecutor) driver);
	//exe.executeScript("arguments[0].value=\"Hello\"", driver.findElement(By.xpath("//input[@name='q']")));
	exe.executeScript("document.body.style.zoom='100%'");
	
	
	

	}

}
