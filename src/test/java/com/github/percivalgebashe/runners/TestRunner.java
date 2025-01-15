package com.github.percivalgebashe.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = ".\\src\\test\\resources\\features",
        glue = {"com.github.percivalgebashe.stepDefinitions"},
        plugin = {"pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
