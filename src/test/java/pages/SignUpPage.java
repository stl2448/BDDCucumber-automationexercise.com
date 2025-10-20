package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class SignUpPage extends BasePage {

	public SignUpPage() {
		super();
	}

	@FindBy(xpath = "//input[@id='id_gender1']")
	WebElement mr;

	@FindBy(xpath = "//input[@id='id_gender2']")
	WebElement mrs;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordElement;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstNameElement;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lastNameElement;

	@FindBy(xpath = "//input[@id='company']")
	WebElement companyElement;

	@FindBy(xpath = "//input[@id='address1']")
	WebElement addressElement;

	@FindBy(xpath = "//select[@id='country']")
	WebElement countryElement;

	@FindBy(xpath = "//input[@id='state']")
	WebElement stateElement;

	@FindBy(xpath = "//input[@id='city']")
	WebElement cityElement;

	@FindBy(xpath = "//input[@id='zipcode']")
	WebElement zipcodeElement;

	@FindBy(xpath = "//input[@id='mobile_number']")
	WebElement mobileNumberElement;

	@FindBy(xpath = "//label[@for='newsletter']")
	WebElement forNewsLetterCheckBoxElement;

	@FindBy(xpath = "//label[@for='optin']")
	WebElement specialOffersOptinElement;

	@FindBy(xpath = "//select[@id='days']")
	WebElement dateInDOB;

	@FindBy(xpath = "//select[@id='months']")
	WebElement monthInDOB;

	@FindBy(xpath = "//select[@id='years']")
	WebElement yearInDOB;

	
	public void selectTitle(String gender) 
	{
		if (gender.equalsIgnoreCase("male")) 
		{
			selectRadioButton(mr);
		} else 
		{
			selectRadioButton(mrs);
		}
	}
	
	public void enterPassword(String password) 
	{
		type(passwordElement, password);
	}
	
	public void selectDay(int day) 
	{
		selectOptionByName(dateInDOB, Integer.toString(day));
	}
	
	public void selectMonth(String month) 
	{
		selectOptionByName(monthInDOB, month);
	}
	
	public void selectYear(int year) 
	{
		selectOptionByName(yearInDOB, Integer.toString(year));
	}
	public void enterFirstName(String firstName) 
	{
		type(firstNameElement, firstName);
	}
	
	public void enterLastName(String lastName) 
	{
		type(lastNameElement, lastName);
	}
	
	public void enterCompany(String company) 
	{
		type(companyElement, company);
	}
	
	public void enterAddress(String address) 
	{
		type(addressElement, address);
	}
	
	public void selectCountry(String country) 
	{
		selectOptionByName(countryElement, country);
	}
	
	public void enterState(String state) 
	{
		type(stateElement, state);
	}
	
	public void enterCity(String city) 
	{
		type(cityElement, city);
	}
	
	public void enterZipcode(String zipcode) 
	{
		type(zipcodeElement, zipcode);
	}
	
	public void enterMobileNumber(long mobileNumber) 
	{
		type(mobileNumberElement, Long.toString(mobileNumber));
	}
	
	public void checkInNewsletter() 
	{
		selectCheckBox(forNewsLetterCheckBoxElement);
	}
	
	public void checkInSpecialOffers() 
	{
		selectCheckBox(specialOffersOptinElement);
	}
	
	@FindBy(xpath="//button[@type='submit' and @data-qa='create-account']")
	WebElement createAccountElement;
	
	public AccountCreatedPage clickCreateAccount() 
	{
		clickElement(createAccountElement);
		AccountCreatedPage accountCreatedPage = new AccountCreatedPage();
		return accountCreatedPage;
	}
	
	public String getTitle() 
	{
		String pageTitle = getPageTitle();
		return pageTitle;
	}
}
