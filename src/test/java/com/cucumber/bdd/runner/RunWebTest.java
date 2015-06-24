package com.cucumber.bdd.runner;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
				features = "classpath:cucumber/web/web.feature", 
				format = {"pretty", "html: cucumber-html-reports",
							"json: cucumber-html-reports/web.json" },
				glue = "com.cucumber.bdd.steps")
@ContextConfiguration
public class RunWebTest {
	

}
