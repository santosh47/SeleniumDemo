package com.tutorialsninja.automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(tags = "", features = {"src/test/resources/FeatureFiles/Login.feature"}, glue = {"com.tutorialsninja.automation.stepdef"},
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, dryRun = false, monochrome = true)
//features = {"src/test/resources/FeatureFiles"} run all feature files
//src/test/resources/FeatureFiles/Login.feature","src/test/resources/FeatureFiles/letscode.feature

//  "pretty", "html:target/output/cucumber-reports.html",
//        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

public class Extent extends AbstractTestNGCucumberTests {

}
