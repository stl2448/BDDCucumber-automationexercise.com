package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utils.Waits;

public class HomePage extends BasePage{

	public HomePage() 
	{
		super();
	}
	
	@FindBy(xpath = "//a[@href='/products']")
	WebElement products;

	@FindBy(xpath = "//a[@href='/login']")
	WebElement signInAndUpButton;

	@FindBy(xpath = "//button[@type='submit' and text()='Create Account']")
	WebElement createAccountFinalSubmit;

	public boolean validatePageTitle(String expTitle) {
		String pageTitle = driver.getTitle();
		if (pageTitle.equalsIgnoreCase(expTitle)) {
			return true;
		} else {
			return false;
		}
	}

	public void clickOnProducts() {
		clickElement(products);
	}

	public boolean verifySignUpPage() {
		Waits.waitForVisibilityOfElement(createAccountFinalSubmit);
		if (createAccountFinalSubmit.isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

	@FindBy(xpath = "//div[@id='slider-carousel']")
	WebElement bannerCarousel;

	public boolean verifyHomePage() {
		Waits.waitForVisibilityOfElement(bannerCarousel);
		if (bannerCarousel.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSignUpButtonDisplayed() {
		Waits.waitForVisibilityOfElement(signInAndUpButton);
		if (signInAndUpButton.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public SignUpAndSignInPage clickOnSignInSignUp() {
		Waits.waitForVisibilityOfElement(signInAndUpButton);
		clickElement(signInAndUpButton);
		SignUpAndSignInPage signUpSignInPage = new SignUpAndSignInPage();
		return signUpSignInPage;

	}

	@FindBy(xpath = "//a[@href='/logout']")
	WebElement logoutElement;

	public boolean logOutIsDisplayed() {
		System.out.println(logoutElement.isDisplayed());
		return logoutElement.isDisplayed();
	}

	public ProductsPage goToProductsPage() {
		Waits.waitForElementToBeClickable(products);
		clickElement(products);
		ProductsPage productsPage = new ProductsPage();
		return productsPage;
	}

	@FindBy(xpath = "//a[@href='/logout']")
	WebElement logoutButtonElement;

	public boolean isLogoutButtonDisplayed() {
		Waits.waitForElementToBeClickable(logoutButtonElement);
		if (logoutButtonElement.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public SignUpAndSignInPage clickLogOutButton() 
	{
		Waits.waitForElementToBeClickable(logoutButtonElement);
		clickElement(logoutButtonElement);
		SignUpAndSignInPage signUpAndSignInPage = new SignUpAndSignInPage();
		return signUpAndSignInPage;
	}
	
	@FindBy(xpath="//a[@href='/contact_us' and text()=' Contact us']")
	WebElement contactUsButtonElement;
	
	public ContactUsPage clickContactUs() 
	{
		Waits.waitForElementToBeClickable(contactUsButtonElement);
		clickElement(contactUsButtonElement);
		ContactUsPage contactUsPage = new ContactUsPage();
		return contactUsPage;
	}

	@FindBy(xpath="//a[@href='/delete_account']")
	WebElement deleteButtonElement;
	public void clickDeleteButton() {
		
		clickElement(deleteButtonElement);
	}
	
	
}
