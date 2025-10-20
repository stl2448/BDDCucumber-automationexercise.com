package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utils.Waits;

public class AccountCreatedPage extends BasePage{
	
	public AccountCreatedPage() 
	{
		super();
	}

	@FindBy(xpath="//a[@data-qa='continue-button']")
	WebElement continueButton;
	
	@FindBy(xpath="//b[text()='Account Created!']")
	WebElement accountCreatedMessageElement;
	
	public boolean isAccountCreatedMessageElementDisplayed() 
	{
		if(accountCreatedMessageElement.isDisplayed()) 
		{
			return true;
		}else 
		{
			return false;
		}
	}
	
	public void clickContinueButton() 
	{
		Waits.waitForElementToBeClickable(continueButton);
		clickElement(continueButton);
	}
}
