package com.cucumber.bdd.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

@ContextConfiguration("classpath:cucumber.xml")
public class Hooks {

	@Autowired
	private WebDriver driver; 
	
	@Before
	public void beforeScenario() {
		System.out.println("Before executed");
	}

	@After
	public void afterScenario(Scenario scenario) {
	    if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); 
	    }
	    driver.close();
	}
}

