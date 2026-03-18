package stepdefinitions;

import base.BasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ContactUsPage;
import pages.HomePage;

import java.util.List;
import java.util.Map;


public class ContactUsSteps {
    HomePage homePage = new HomePage();
    ContactUsPage contactUsPage = new ContactUsPage();
    BasePage basePage = new BasePage();

    @When("user click on Contact us button")
    public void userClickOnContactUsButton() {
       homePage.clickContactUs();
    }

    @Then("Contact Us page is displayed")
    public void contactUsPageIsDisplayed() {
        contactUsPage.verifyContactUsPage();
    }

    @When("user fill contact us data")
    public void userFillContactUsData(DataTable contactUs) throws InterruptedException {
        List<Map<String,String>> contactUsData = contactUs.asMaps();
        contactUsPage.enterName(contactUsData.get(0).get("name"));
        contactUsPage.enterEmail(contactUsData.get(0).get("email"));
        contactUsPage.enterSubject(contactUsData.get(0).get("subject"));
        contactUsPage.enterMessage(contactUsData.get(0).get("message"));
        contactUsPage.uploadFile(contactUsData.get(0).get("filePath"));
    }
    @And("clicked on submit")
    public void clickedOnSubmit() {

        contactUsPage.clickSubmit();
        basePage.acceptAlert();

    }
    @Then("contact us form submitted successfully")
    public void contactUsFormSubmittedSuccessfully() {
        Assert.assertTrue(contactUsPage.isSuccessMessageDisplayed());
    }
}
