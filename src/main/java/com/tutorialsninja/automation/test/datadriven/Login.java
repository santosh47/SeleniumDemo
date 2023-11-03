package com.tutorialsninja.automation.test.datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class Login {
	
	WebDriver driver;
	MyXLSReader excelReader;
	
	@Test(dataProvider="dataSupplier")
	public void testLogin(HashMap<String,String> hMap) throws IOException {
		
		if(!DataUtil.isRunnable(excelReader, "LoginTest", "Testcases") || hMap.get("Runmode").equals("N")) {
			
			throw new SkipException("Skipping the test as the runmode is set to N");
			
		}

		WebDriver webDriver=new ChromeDriver();
		webDriver.get("https://www.letskodeit.com/practice");
		webDriver.findElement(By.xpath("//div[@id='alert-example-div']//input[@id='name']")).sendKeys(hMap.get("Username"));
	}
	
	@DataProvider
	public Object[][] dataSupplier() {
		
		Object[][] obj = null;
		
		try {
			
			excelReader = new MyXLSReader("src\\main\\resources\\ConfigurationFile\\TutorialsNinja.xlsx");


			obj = DataUtil.getTestData(excelReader, "LoginTest", "Data");
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return obj;
		
	}

}
