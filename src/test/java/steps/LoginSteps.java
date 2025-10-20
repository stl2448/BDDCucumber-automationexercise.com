package steps;

import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SignUpAndSignInPage;
import utils.ConfigReader;

public class LoginSteps {

	private HomePage home = new HomePage();
	private SignUpAndSignInPage signUpAndSignInPage = new SignUpAndSignInPage();
	
	@Given("user launch application")
	public void user_launch_application() {
	    DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
	   Assert.assertTrue(home.verifyHomePage());
	}
	@When("user click on signUpAndSignIn button")
	public void user_click_on_sign_up_and_sign_in_button() {
	    home.clickOnSignInSignUp();
	}
	@Then("signUpAndSignIn page is displayed")
	public void sign_up_and_sign_in_page_is_displayed() {
		signUpAndSignInPage.verifySignUpAndSignInPage();
	}
	@When("^user enters (.+) and (.+)$")
	public void user_enters_email_Id_and_password(String emailId, String password) {
		signUpAndSignInPage.enterLoginEmail(emailId);
		signUpAndSignInPage.enterLoginPassword(password);
		
	}
	@When("clicked on login")
	public void clicked_on_login() {
		signUpAndSignInPage.clickLoginButton();
	}
	@Then("user logged in successfully")
	public void user_logged_in_successfully() {
	   Assert.assertTrue(home.isLogoutButtonDisplayed());
	}
}
