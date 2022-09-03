package com.seleniumTestNG.core;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseFunctions {
	public WebDriver driver;
	Duration elementTimeout = Duration.ofSeconds(10);

	public BaseFunctions() {

	}

	public BaseFunctions(WebDriver driver) {
		this.driver = driver;
	}

	public void click(WebElement element) {
		waitForElement(element).click();
	}

	public void enterText(WebElement element, String input) {
		waitForElement(element).sendKeys(input);
	}

	public String getText(WebElement element) {
		return waitForElement(element).getText();
	}

	public WebElement waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, elementTimeout.toMillis());
		wait.ignoring(NoSuchElementException.class);
		try {
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch (StaleElementReferenceException e) {
			WebElement cachedElement = ((WrapsElement) element).getWrappedElement();
			return wait.until(ExpectedConditions.visibilityOf(cachedElement));
		}
	}

	public List<WebElement> waitUntilDropDownPopulated(List<WebElement> elements) {
		WebDriverWait wait = new WebDriverWait(driver, elementTimeout.toMillis());
		wait.ignoring(NoSuchElementException.class);
		try {
			return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		}catch(StaleElementReferenceException e) {
			//TODO : handle stale exception for List<Webelement>
			String[] locator = elements.get(0).toString().replaceAll(".$", "").split("->");
			String path = locator[1].trim();
			switch (locator[0].trim()) {
			case "xpath":
				return driver.findElements(By.xpath(path));
			case "id":
				return driver.findElements(By.id(path));
			case "css":
				return driver.findElements(By.cssSelector(path));
			}
			return null;
		}
	}

}
