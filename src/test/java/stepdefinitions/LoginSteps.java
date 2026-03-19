package stepdefinitions;

import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SignUpAndSignInPage;
import utils.ConfigReader;
import testutils.ExtentLogger;

public class LoginSteps {

	private HomePage home = new HomePage();
	private SignUpAndSignInPage signUpAndSignInPage = new SignUpAndSignInPage();
	
	@Given("user launch application")
	public void user_launch_application() {
		ExtentLogger.logStep();
	    DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
	   Assert.assertTrue(home.verifyHomePage());
	   ExtentLogger.logPass();
	}
	@When("user click on signUpAndSignIn button")
	public void user_click_on_sign_up_and_sign_in_button() {
		ExtentLogger.logStep();
	    home.clickOnSignInSignUp();
		ExtentLogger.logPass();
	}
	@Then("signUpAndSignIn page is displayed")
	public void sign_up_and_sign_in_page_is_displayed() {
		ExtentLogger.logStep();
		signUpAndSignInPage.verifySignUpAndSignInPage();
		ExtentLogger.logPass();
	}
	@When("^user enters (.+) and (.+)$")
	public void user_enters_email_Id_and_password(String emailId, String password) {
		ExtentLogger.logStep();
		signUpAndSignInPage.enterLoginEmail(emailId);
		signUpAndSignInPage.enterLoginPassword(password);
		ExtentLogger.logPass();
		
	}
	@When("clicked on login")
	public void clicked_on_login() {
		ExtentLogger.logStep();
		signUpAndSignInPage.clickLoginButton();
		ExtentLogger.logPass();
	}
	@Then("user logged in successfully")
	public void user_logged_in_successfully() {
		ExtentLogger.logStep();
	   Assert.assertTrue(home.isLogoutButtonDisplayed());
	   ExtentLogger.logPass();
	}
}
