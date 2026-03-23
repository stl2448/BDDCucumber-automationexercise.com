package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsPage;
import testutils.ExtentLogger;

public class ProductsPageSteps {
    HomePage homePage = new HomePage();
    ProductsPage  productsPage = new ProductsPage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();

    @When("user click on Products button")
    public void userClickOnProductsButton() {
        ExtentLogger.logStep();
        homePage.clickOnProducts();
        ExtentLogger.logPass();
    }

    @Then("Products page is displayed")
    public void productsPageIsDisplayed() {
        ExtentLogger.logStep();
    Assert.assertTrue(productsPage.verifyProductsPage());
    ExtentLogger.logPass();

    }

    @When("^user clicked on add to cart button for the product using (.+)$")
    public void userClickedOnAddToCartButtonForTheProductUsingProductName(String productName) {
        ExtentLogger.logStep();
        productsPage.addProductToCartByName(productName);
        ExtentLogger.logPass();
    }

    @Then("product added to the cart successfully")
    public void productAddedToTheCartSuccessfully() {

        ExtentLogger.logStep();
        Assert.assertTrue(productsPage.isProductAddedToCart());
        ExtentLogger.logPass();
    }

    @When("^user clicked on View Product button for the product using (.+)$")
    public void userClickedOnViewProductButtonForTheProductUsingProductName(String productName) {
        ExtentLogger.logStep();
        productsPage.clickViewProduct(productName);
        ExtentLogger.logPass();
    }

    @Then("product details page is displayed")
    public void productDetailsPageIsDisplayed() {
        ExtentLogger.logStep();
        productDetailsPage.verifyProductDetailsPage();
        productDetailsPage.verifyProductByName("");
        ExtentLogger.logPass();
    }
}
