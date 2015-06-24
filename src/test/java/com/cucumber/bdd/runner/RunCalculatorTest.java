package com.cucumber.bdd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:cucumber/calculator/calculator.feature", 
		format = {"pretty", "html: cucumber-html-reports",
					"json: cucumber-html-reports/cucumber.json" },
		glue = "com.cucumber.bdd.steps"
		)

@ContextConfiguration
public class RunCalculatorTest {
}
