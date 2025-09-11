package com.vtiger.runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/Login2.feature",     // Path to all your .feature files
        glue = "com.vtiger.Step2definition",
        dryRun = false,// Package with step definitions
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml"
        },
        monochrome = true,                            // Cleaner console output
        tags = "@Login",                              // Optional: run only tagged scenarios
        publish = true                                // Publishes report to cucumber.io
)
public class Test2Runner
{
}
