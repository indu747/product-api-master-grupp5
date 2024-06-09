package com.example.produktapi.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/example/produktapi/resources/features",
        glue = {"com.example.produktapi.stepDefinitions", "com.example.produktapi.hooks"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true)
public class RunCucumberTest {

}