package com.tutorialsninja.automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



        @CucumberOptions(tags = "",features = {"@target/failedrerun.txt"}, glue = {"com.tutorialsninja.automation.stepdef"},
                plugin = { "pretty",
                        "html:target/output/cucumber-reports.html"}, dryRun = false, monochrome = true)


        public class rerun extends AbstractTestNGCucumberTests{


}
