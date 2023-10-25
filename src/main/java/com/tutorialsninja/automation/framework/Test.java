package com.tutorialsninja.automation.framework;
import com.github.javafaker.Faker;
import com.mongodb.client.model.Collation;
import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.base.BaseTestNg;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test
{


	@org.testng.annotations.Test
	public void test()
	{


		List<Integer> list= Arrays.asList(1, 5, 2);
		Collections.sort(list);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);


	}

}
