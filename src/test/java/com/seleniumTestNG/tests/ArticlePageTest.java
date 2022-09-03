package com.seleniumTestNG.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.seleniumTestNG.core.WebDriverFactory;
import com.seleniumTestNG.pages.ArticlePage;
import com.seleniumTestNG.pages.HomePage;

public class ArticlePageTest {
	HomePage homePage;
	ArticlePage articlePage;

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

	@Test(dataProvider = "articles")
	public void verifyUserAbleToSearchArticle(String article) {
		homePage = new HomePage(WebDriverFactory.getDriver());
		String header = homePage.searchArticle(article);
		articlePage = new ArticlePage(WebDriverFactory.getDriver());
		articlePage.verifyHeading(header);
	}

	@Test(dataProvider = "articles")
	public void verifyViewHistoryHeader(String article) {
		homePage = new HomePage(WebDriverFactory.getDriver());
		String header = homePage.searchArticle(article);
		articlePage = new ArticlePage(WebDriverFactory.getDriver());
		articlePage.verifyViewHistoryHeader(header);
	}

	@Test(dataProvider = "articles")
	public void verifyTalkHeader(String article) {
		homePage = new HomePage(WebDriverFactory.getDriver());
		String header = homePage.searchArticle(article);
		articlePage = new ArticlePage(WebDriverFactory.getDriver());
		articlePage.verifyTalkHeader(header);
	}

	@DataProvider(name = "articles")
	public Object[][] articles() {
		return new Object[][] { { "google" }, { "yahoo" } };
	}
}
