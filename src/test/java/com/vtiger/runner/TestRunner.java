package com.vtiger.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/Features",   // used for mention path of Feature file
        glue = "com.vtiger.stepdefinition",   // need to mention path of stepdefinition file and checking step and mapping of Feature file.If mapped not there throw error.
       // glue = "com.vtiger.stepdefinition.login",
        dryRun = false,            // By default is true
        plugin = {
                "pretty",                         // Console output
                "html:target/cucumber-reports.html", // HTML report
                "json:target/cucumber.json",         // JSON report
                "junit:target/cucumber.xml"          // JUnit XML report
        },
       tags = "@CreateLead"  // for run specific TC
       // monochrome = false   // By default is false


)
public class  TestRunner
{
}


