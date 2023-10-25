package com.tutorialsninja.automation.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;



@CucumberOptions(tags = "",features = {"src/test/resources/FeatureFiles/Login.feature"}, glue = {"com.tutorialsninja.automation.stepdef"},
        plugin = { "pretty",
                "html:target/cucumber-reports"}, dryRun = false, monochrome = true)



public class Parallel extends AbstractTestNGCucumberTests{

        @Override
        @DataProvider(parallel = false)
        public Object[][] scenarios() {
            return super.scenarios();
        }

        //cross browser false

}
