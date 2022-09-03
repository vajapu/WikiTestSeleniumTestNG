package com.seleniumTestNG.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumTestNG.pages.components.LeftNavigation;
import com.seleniumTestNG.pages.components.TopNavigation;

import junit.framework.Assert;

public class ArticlePage extends Page {
	TopNavigation topNavigation;
	LeftNavigation leftNavigation;

	@FindBy(id = "firstHeading")
	@CacheLookup
	private WebElement firstHeading;

	public ArticlePage(WebDriver driver) {
		super(driver);
		topNavigation = new TopNavigation(driver);
		leftNavigation = new LeftNavigation(driver);
		PageFactory.initElements(driver, this);
	}

	public void verifyHeading(String header) {
		Assert.assertEquals(header, baseFunctions.getText(firstHeading));
	}

	public void verifyViewHistoryHeader(String header) {
		baseFunctions.click(topNavigation.historyTab);
		Assert.assertEquals(header + ": Revision history", baseFunctions.getText(firstHeading));
	}

	public void verifyTalkHeader(String header) {
		baseFunctions.click(topNavigation.talkTab);
		Assert.assertEquals("Talk:" + header, baseFunctions.getText(firstHeading));
	}

}
