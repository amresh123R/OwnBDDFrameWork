package com.test.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags = "@Smoke or @Regression",
	    features = "src/test/resources/features",
	    glue = "com.test.stepdefs",
	    plugin = {
	        "pretty",
	        "json:target/Cucumber.json",
	        "html:target/Cucumber-reports.html"
	        //"com.test.utility.ExtentReportListener"
	    },
	    monochrome = true
	)
public class TestRunner extends AbstractTestNGCucumberTests{

}
