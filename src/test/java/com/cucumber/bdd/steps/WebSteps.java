package com.cucumber.bdd.steps;

import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.bdd.core.TestContext;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WebSteps {

	private WebDriver browser = TestContext.getInstance().getDriver();

	@Given("^I visit google search page$")
	public void i_visit_google_search_page() throws Throwable {
		browser.navigate().to(new URL("http://www.google.co.uk"));
	}

	@When("^I type (.*) as a search string$")
	public void i_search_string(String search) throws Throwable {
		WebElement element = browser.findElement(By.name("q"));
		element.sendKeys(search);
		WebElement btnElement = browser.findElement(By.name("btnG"));
		btnElement.click();
	}

	@Then("^see the results$")
	public void see_results() throws InterruptedException {
		WebElement element = new WebDriverWait(browser, 20).pollingEvery(1,
				TimeUnit.SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		
		String textContent = browser.getPageSource();
		boolean textValuePresent = textContent.contains("cucumber");
		assertTrue(textValuePresent);
	}
	
	
}