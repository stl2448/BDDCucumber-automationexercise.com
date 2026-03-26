package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.ProductDetailsPage;

public class ProductDetailsPageSteps {

    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    CartPage cartPage = new CartPage();

    @When("^user updated the product quantity (.+)$")
    public void userUpdatedTheProductQuantity(int productQuantity) {
        productDetailsPage.updateProductQuantity(productQuantity);
    }

    @And("clicked on Add to cart button")
    public void clickedOnAddToCartButton() {
        productDetailsPage.clickAddToCart();

    }

    @Then("^product (.+) is added to the cart$")
    public void productIsAddedToTheCart(String productName) {
        Assert.assertTrue(productDetailsPage.isProductAddedToCart());
        productDetailsPage.clickViewCart();
        Assert.assertTrue(cartPage.checkProductByName(productName));
    }
}
