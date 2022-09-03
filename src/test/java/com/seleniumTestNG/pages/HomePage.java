package com.seleniumTestNG.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page {

	@FindBy(id = "searchInput")
	@CacheLookup
	private WebElement searchInput;
	
	@FindBy(xpath = "//div[@class='suggestions-dropdown']//h3[@class='suggestion-title']")
	//@CacheLookup not used since its dynamic
	private List<WebElement> suggestionTitle;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String searchArticle(String article) {
		baseFunctions.enterText(searchInput, article);
		suggestionTitle = baseFunctions.waitUntilDropDownPopulated(suggestionTitle);
		String title = baseFunctions.getText(suggestionTitle.get(0));
		baseFunctions.click(suggestionTitle.get(0));
		return title;
	}
}
