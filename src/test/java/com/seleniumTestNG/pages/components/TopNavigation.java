package com.seleniumTestNG.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopNavigation {
	@FindBy(id = "ca-nstab-main")
	@CacheLookup
	public WebElement articleTab;
	
	@FindBy(id = "ca-talk")
	@CacheLookup
	public WebElement talkTab;
	
	@FindBy(id = "ca-history")
	@CacheLookup
	public WebElement historyTab;
	
	public TopNavigation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
