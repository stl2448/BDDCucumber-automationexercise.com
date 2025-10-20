package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utils.Waits;

public class SignUpAndSignInPage extends BasePage {

	public SignUpAndSignInPage() {
		super();
	}

	@FindBy(xpath = "//input[@name='name']")
	WebElement nameTextBox;

	public void enterSignUpName(String name) {
		Waits.waitForVisibilityOfElement(nameTextBox);
		type(nameTextBox, name);
	}

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	WebElement emailIdToRegister;

	public void enterSignUpEmail(String emailId) {
		Waits.waitForVisibilityOfElement(emailIdToRegister);
		type(emailIdToRegister, emailId);
	}

	@FindBy(xpath = "//button[@type='submit' and text()='Signup']")
	WebElement submitNewUserDataButton;

	public SignUpPage clickSignUpSubmit() {
		Waits.waitForVisibilityOfElement(submitNewUserDataButton);
		clickElement(submitNewUserDataButton);
		SignUpPage signUpPage = new SignUpPage();
		return signUpPage;
	}

	@FindBy(xpath = "//input[@data-qa='login-email']")
	WebElement signInEmailTextBox;

	public void enterLoginEmail(String signInEmail) {
		Waits.waitForElementToBeClickable(signInEmailTextBox);
		type(signInEmailTextBox, signInEmail);
	}

	@FindBy(xpath = "//input[@data-qa='login-password']")
	WebElement loginPasswordTextBox;

	public void enterLoginPassword(String password) {
		Waits.waitForElementToBeClickable(loginPasswordTextBox);
		type(loginPasswordTextBox, password);
	}

	@FindBy(xpath = "//button[@data-qa='login-button']")
	WebElement loginButton;

	public HomePage clickLoginButton() {
		Waits.waitForElementToBeClickable(loginButton);
		clickElement(loginButton);
		HomePage homePage = new HomePage();
		return homePage;
	}

	@FindBy(xpath = "//p[contains(text(),'incorrect!')]")
	WebElement loginErrorMessageElement;

	public boolean isLoginErrorMessageDisplayed() {
		Waits.waitForVisibilityOfElement(loginErrorMessageElement);
		System.out.println(loginErrorMessageElement.getText());
		if (loginErrorMessageElement.isDisplayed()
				&& loginErrorMessageElement.getText().equalsIgnoreCase("Your email or password is incorrect!")) {
			return true;
		} else {
			return false;
		}
	}

	@FindBy(xpath = "//h2[text()='Login to your account']")
	WebElement loginLabel;

	@FindBy(xpath = "//h2[text()='New User Signup!']")
	WebElement signUpLabel;

	public boolean verifySignUpAndSignInPage() {
		Waits.waitForVisibilityOfElement(loginLabel);
		Waits.waitForVisibilityOfElement(signUpLabel);
		if (loginLabel.isDisplayed() && signUpLabel.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	@FindBy(xpath="//p[text()='Email Address already exist!']")
	WebElement emailAlreadyExistErrorMessage; 
	
	public boolean isemailAlreadyExistErrorMessageDisplayed(String expErrorMessage) 
	{
		Waits.waitForVisibilityOfElement(emailAlreadyExistErrorMessage);
		if(emailAlreadyExistErrorMessage.isDisplayed() && emailAlreadyExistErrorMessage.getText().
				equalsIgnoreCase(expErrorMessage)) 
		{
			return true;
		} else 
		{
			return false;
		}
	}
}
