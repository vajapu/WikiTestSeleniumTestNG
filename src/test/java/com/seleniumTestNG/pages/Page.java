package com.seleniumTestNG.pages;

import org.openqa.selenium.WebDriver;

import com.seleniumTestNG.core.BaseFunctions;

import junit.framework.Assert;

public class Page {
	BaseFunctions baseFunctions;

	public Page(WebDriver driver) {
		baseFunctions = new BaseFunctions(driver);
	}

	public void verifyPageTitle(String title) {
		Assert.assertEquals(title, baseFunctions.driver.getTitle());
	}
}
