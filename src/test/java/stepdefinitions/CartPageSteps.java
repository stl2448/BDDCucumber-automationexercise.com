package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.CartPage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class CartPageSteps {

    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    ProductsPage productsPage = new ProductsPage();
    CartPage  cartPage = new CartPage();

    @Then("^product is displayed in cart page with exact quantity (.+)$")
    public void productIsDisplayedInCartPageWithExactQuantity(int productQuantity) {
        productDetailsPage.clickViewCart();
        Assert.assertTrue(cartPage.checkProductQuantity(productQuantity));
    }

    @And("^product with (.+) is available in the cart$")
    public void productIsAvailableInTheCart(String  productName) {
        productsPage.clickViewCart();
        Assert.assertTrue(cartPage.checkProductByName(productName));
    }
}
