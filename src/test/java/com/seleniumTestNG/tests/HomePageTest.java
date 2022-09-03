package com.seleniumTestNG.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seleniumTestNG.core.WebDriverFactory;
import com.seleniumTestNG.pages.HomePage;

public class HomePageTest {
	
	@BeforeMethod
	public void setUp() {
		WebDriverFactory.setDriver();
		WebDriverFactory.getDriver().get("https://www.wikipedia.org");
	}

	@AfterMethod
	public void close() {
		if (WebDriverFactory.getDriver() != null) {
			WebDriverFactory.getDriver().quit();
		}
	}
	
	@Test
	public void verifyHomePageisDisplayed() {
		HomePage homePage = new HomePage(WebDriverFactory.getDriver());
		homePage.verifyPageTitle("Wikipedia");
	}
	
}
