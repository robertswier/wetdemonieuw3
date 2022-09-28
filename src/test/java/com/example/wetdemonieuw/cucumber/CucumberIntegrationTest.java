package com.example.wetdemonieuw.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//Run deze class om de features te runnen !
//zie D:\spring\tutorials-master\spring-cucumber\src\test\java\com\baeldung\CucumberIntegrationTest.java
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = {"pretty",
        "json:target/cucumber-report.json"})
public class CucumberIntegrationTest {
}