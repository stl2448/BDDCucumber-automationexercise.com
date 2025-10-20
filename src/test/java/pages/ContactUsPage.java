package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utils.Waits;

public class ContactUsPage extends BasePage {

	public ContactUsPage() {
		super();
	}

	@FindBy(xpath = "//h2[text()='Get In Touch']")
	WebElement getInTouchTextElement;

	public boolean verifyContactUsPage() {
		Waits.waitForVisibilityOfElement(getInTouchTextElement);
		if (getInTouchTextElement.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	@FindBy(xpath = "//input[@name='name']")
	WebElement nameTextBox;

	public void enterName(String name) {
		Waits.waitForElementToBeClickable(nameTextBox);
		type(nameTextBox, name);
	}

	@FindBy(xpath = "//input[@name='email']")
	WebElement emailTextBox;

	public void enterEmail(String emailId) {
		Waits.waitForElementToBeClickable(emailTextBox);
		type(emailTextBox, emailId);
	}

	@FindBy(xpath = "//input[@name='subject']")
	WebElement subjectTextBox;

	public void enterSubject(String subject) {
		Waits.waitForElementToBeClickable(subjectTextBox);
		type(subjectTextBox, subject);
	}

	@FindBy(xpath = "//textarea[@id='message']")
	WebElement messageBoxElement;

	public void enterMessage(String message) {
		Waits.waitForElementToBeClickable(messageBoxElement);
		type(messageBoxElement, message);
	}

	@FindBy(xpath = "//input[@name='upload_file']")
	WebElement uploadFileElement;

	public void uploadFile(String fileName) {
		Waits.waitForElementToBeClickable(uploadFileElement);
		//type(uploadFileElement, fileName);
		clickElement(uploadFileElement);
		pasteContentFromClipBoard(fileName);
	}

	@FindBy(xpath = "//input[@name='submit']")
	WebElement submitButtonElement;

	public void clickSubmit() {
		Waits.waitForElementToBeClickable(submitButtonElement);
		clickElement(submitButtonElement);
	}

	public void clickOkOnAlert() {
		acceptAlert();
	}

	@FindBy(xpath = "//div[@class='status alert alert-success' and contains(text(),'successfully')]")
	WebElement successMessageElement;

	public boolean isSuccessMessageDisplayed() {
		Waits.waitForElementToBeClickable(successMessageElement);
		if (successMessageElement.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
}
