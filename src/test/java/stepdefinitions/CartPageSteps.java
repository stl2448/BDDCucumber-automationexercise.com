package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import pages.ProductDetailsPage;

public class CartPageSteps {

    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    @Then("product is displayed in cart page with exact quantity")
    public void productIsDisplayedInCartPageWithExactQuantity() {
        productDetailsPage.clickViewCart();
    }
}
