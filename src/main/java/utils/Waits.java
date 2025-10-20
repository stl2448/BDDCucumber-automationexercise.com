package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;

public class Waits {

	private static WebDriverWait wait;
	private static WebDriver driver = DriverFactory.getDriver();

	public static void waitForElementToBeClickable(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForVisibilityOfElement(WebElement element) 
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
