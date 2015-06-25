package com.cucumber.bdd.core;

import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class TestContext {

	private WebDriver driver;
	private ApplicationContext applicationContext;
	private static final TestContext INSTANCE = new TestContext();
	
	private TestContext() {
		applicationContext = new ClassPathXmlApplicationContext("spring-webdriver.xml");
		driver = (WebDriver) applicationContext.getBean("browser");
	}

	public static TestContext getInstance() {
		return INSTANCE;
	}

	public WebDriver getDriver() {
		return driver;
	}

}
