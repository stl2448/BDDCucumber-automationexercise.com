package steps;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountCreatedPage;
import pages.AccountDeletedPage;
import pages.HomePage;
import pages.SignUpAndSignInPage;
import pages.SignUpPage;

public class SignUpSteps {

	SignUpPage signUp = new SignUpPage();
	AccountCreatedPage accPage = new AccountCreatedPage();
	HomePage home = new  HomePage();
	SignUpAndSignInPage signUpAndSignInPage = new SignUpAndSignInPage();
	AccountDeletedPage accDel = new AccountDeletedPage();
	
	@When("^user enter (.+) and (.+) in signUp section$")
	public void user_enter_name_and_email_address_in_sign_up_section(String name, String email_address) {
		signUpAndSignInPage.enterSignUpName(name);
		signUpAndSignInPage.enterSignUpEmail(email_address);
	}
	@When("user clicked on signUp button")
	public void user_clicked_on_sign_up_button() {
		signUpAndSignInPage.clickSignUpSubmit();
	}
	
	@Then("signUp Page is displayed")
	public void sign_up_page_is_displayed() {
		String title = signUp.getTitle();
		Assert.assertEquals(title, "Automation Exercise - Signup");
	}
	@When("user enter all necessary details")
	public void user_enter_all_necessary_details(io.cucumber.datatable.DataTable dataTable) {
	    
		List<Map<String, String>> signUpData = dataTable.asMaps();
		signUp.selectTitle(signUpData.get(0).get("title"));
		signUp.enterPassword(signUpData.get(0).get("password"));
		signUp.selectDay(Integer.parseInt(signUpData.get(0).get("day")));
		//signUp.selectMonth(signUpData.get(0).get("month"));
		signUp.selectYear(Integer.parseInt(signUpData.get(0).get("year")));
		signUp.enterFirstName(signUpData.get(0).get("firstName"));
		signUp.enterLastName(signUpData.get(0).get("lastName"));
		signUp.enterCompany(signUpData.get(0).get("company"));
		signUp.enterAddress(signUpData.get(0).get("address"));
		signUp.selectCountry(signUpData.get(0).get("country"));
		signUp.enterState(signUpData.get(0).get("state"));
		signUp.enterCity(signUpData.get(0).get("city"));
		signUp.enterZipcode(signUpData.get(0).get("zipcode"));
		signUp.enterMobileNumber(Integer.parseInt(signUpData.get(0).get("mobile")));
	}
	@When("opted for newsletter and special offers checkboxes")
	public void opted_for_newsletter_and_special_offers_checkboxes() {
	   signUp.checkInNewsletter();
	   signUp.checkInSpecialOffers();
	}
	@When("clicked on CreateAccount button")
	public void clicked_on_create_account_button() {
	    signUp.clickCreateAccount();
	}
	@Then("Account created message is displayed")
	public void account_created_message_is_displayed() {
	    accPage.isAccountCreatedMessageElementDisplayed();
	}
	@When("user clicked on continue button")
	public void user_clicked_on_continue_button() {
	    accPage.clickContinueButton();
	}
	@Then("Home page is displayed with logout button")
	public void home_page_is_displayed_with_logout_button() {
	    Assert.assertTrue(home.isLogoutButtonDisplayed());
	    
	}
	
	@When("clicked on signUp Button")
	public void clicked_on_sign_up_button() {
		signUpAndSignInPage.clickSignUpSubmit();
	}
	@Then("user clicked on delete account button")
	public void user_clicked_on_delete_account_button() {
	    home.clickDeleteButton();
	}
	@Then("account deleted message is displayed")
	public void account_deleted_message_is_displayed() {
	   Assert.assertTrue(accDel.isAccountDeletedMessageDisplayed());
	}
}
