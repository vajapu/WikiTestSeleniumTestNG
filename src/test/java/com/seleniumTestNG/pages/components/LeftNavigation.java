package com.seleniumTestNG.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNavigation {
	
	@FindBy(id = "n-mainpage-description")
	@CacheLookup
	public WebElement mainPage;
	
	@FindBy(id = "n-contactpage")
	@CacheLookup
	public WebElement contactUs;
	
	public LeftNavigation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
