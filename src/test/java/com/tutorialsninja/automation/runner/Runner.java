package com.tutorialsninja.automation.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "",features = {"src/test/resources/FeatureFiles/Bdd.feature"}, glue = {"com.tutorialsninja.automation.stepdef"},
        plugin = { "pretty",
                "html:target/output/cucumber-reports.html","rerun:target/failedrerun.txt"}, dryRun = false, monochrome = true)
//features = {"src/test/resources/FeatureFiles"} run all feature files
//src/test/resources/FeatureFiles/Login.feature","src/test/resources/FeatureFiles/letscode.feature

public class Runner extends AbstractTestNGCucumberTests {


}



