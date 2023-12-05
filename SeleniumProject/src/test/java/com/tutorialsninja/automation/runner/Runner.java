package com.tutorialsninja.automation.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(  tags = "",features = {"src/test/resources/FeatureFiles"}, glue = {"com.tutorialsninja.automation.stepdef"},
        plugin = { "pretty", "html:target/cucumber-reports" }, dryRun = false,monochrome = true)



public class Runner extends AbstractTestNGCucumberTests {

}



