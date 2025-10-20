package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class AccountDeletedPage extends BasePage {

	public AccountDeletedPage() 
	{
		super();
	}
	
	@FindBy(xpath="//b[text()='Account Deleted!']")
	WebElement deletedAccountMessageElement;
	
	public boolean isAccountDeletedMessageDisplayed() 
	{
		if(deletedAccountMessageElement.isDisplayed()) 
		{
			return true;
		} else 
		{
			return false;
		}
	}
}
