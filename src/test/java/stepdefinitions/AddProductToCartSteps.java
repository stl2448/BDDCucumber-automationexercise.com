package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductsPage;

public class AddProductToCartSteps {
    HomePage homePage = new HomePage();
    ProductsPage  productsPage = new ProductsPage();

    @When("user click on Products button")
    public void userClickOnProductsButton() {
        homePage.clickOnProducts();
    }

    @Then("Products page is displayed")
    public void productsPageIsDisplayed() {
    Assert.assertTrue(productsPage.verifyProductsPage());

    }

    @When("^user clicked on add to cart button for the product using (.+)$")
    public void userClickedOnAddToCartButtonForTheProductUsingProductName(String productName) {
        productsPage.addProductToCartByName(productName);
    }

    @Then("product added to the cart successfully")
    public void productAddedToTheCartSuccessfully() {

        Assert.assertTrue(productsPage.isProductAddedToCart());
    }
}
