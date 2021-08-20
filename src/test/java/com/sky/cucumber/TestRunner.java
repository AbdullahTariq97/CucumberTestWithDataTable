package com.sky.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:build/reports/html"},
        glue = "com/sky/cucumber",
        features = "src/test/resources/features")
public class TestRunner {
}
