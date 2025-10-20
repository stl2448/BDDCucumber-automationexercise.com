package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.Waits;

public class BasePage {

	protected WebDriver driver;
	
	public BasePage() 
	{
		this.driver=DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void type(WebElement element, String input) 
	{
		Waits.waitForVisibilityOfElement(element);
		element.clear();
		element.sendKeys(input);
	}
	
	public void clickElement(WebElement element) 
	{
		Waits.waitForElementToBeClickable(element);
		element.click();
	}
	
	public void selectOptionByName(WebElement element, String option) 
	{
		Waits.waitForElementToBeClickable(element);
		clickElement(element);
		Select sel = new Select(element);
		sel.selectByValue(option);
	}
	
	public void acceptAlert() 
	{
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert() 
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void pasteContentFromClipBoard(String text) 
	{
		StringSelection sel = new StringSelection(text);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		try {
			Robot rob = new Robot();
			rob.keyPress(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_V);
			rob.keyRelease(KeyEvent.VK_V);
			rob.keyRelease(KeyEvent.VK_CONTROL);
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void scrollToTheElement(WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void switchToParentFrame() 
	{
		driver.switchTo().parentFrame();
	}
	
	public void rightClickOnTheElement(WebElement element) 
	{
		Actions act = new Actions(driver);
		act.contextClick(element);
	}
	public void doubleClick(WebElement element) 
	{
		Actions act = new Actions(driver);
		act.doubleClick(element);
	}
	
	public void selectCheckBox(WebElement element) 
	{
		if(!element.isSelected()) 
		{
			clickElement(element);
		}
	}
	
	public void selectRadioButton(WebElement element) 
	{
		if(!element.isSelected()) 
		{
			clickElement(element);
		}
	}
	
	public String getPageTitle() 
	{
		return driver.getTitle();
	}
}
