package pages;

import base.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waits;

import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage()
    {
        super();
    }
    @Getter
    @FindBy(xpath="//div[@class='product-image-wrapper']")
    private List<WebElement> productTiles;

    @FindBy(xpath="//p[normalize-space()='Your product has been added to cart.']")
    private WebElement productAddedToCart;

    @FindBy(xpath="//u[normalize-space()='View Cart']")
    WebElement viewCart;

    @FindBy(xpath="//h2[normalize-space()='All Products']")
    WebElement allProductsText;

    public boolean verifyProductsPage()
    {
        Waits.waitForVisibilityOfElement(allProductsText);
        if(allProductsText.isDisplayed())
        {
            return true;
        } else {
            return false;
            }
    }
    public void addProductToCartByName(String productName)
    {
        List<WebElement> productCards = getProductTiles();
        for(WebElement productCard : productCards)
        {
            scrollToTheElement(productCard);
            hoverOnTheElement(productCard);
            WebElement overlay = productCard.findElement(By.xpath(".//div[@class='overlay-content']"));
            String name = overlay.findElement(By.tagName("p")).getText().trim();
            if(name.equalsIgnoreCase(productName))
           {
               WebElement addToCart = overlay.findElement(By.xpath(".//a[contains(text(),'Add to cart')]"));
               clickElement(addToCart);
               return;
           }
        }
        throw new RuntimeException("Product Not Found:  " + productName);
    }

    public boolean isProductAddedToCart()
    {
        Waits.waitForVisibilityOfElement(productAddedToCart);
        if(productAddedToCart.getText().contains("added to cart"))
        {
            return true;
        } else
        {
            return false;
        }
    }

    public CartPage clickViewCart()
    {
        Waits.waitForVisibilityOfElement(viewCart);
        clickElement(viewCart);
        return new CartPage();
    }

    public ProductDetailsPage clickViewProduct(String productName)
    {
        List<WebElement> productCards = getProductTiles();
        for(WebElement productCard : productCards)
        {
            scrollToTheElement(productCard);
           // hoverOnTheElement(productCard);
          //  WebElement overlay = productCard.findElement(By.xpath(".//div[@class='overlay-content']"));
            String name = productCard.findElement(By.tagName("p")).getText().trim();
            if(name.equalsIgnoreCase(productName))
            {
                WebElement viewDetailsButton = productCard.findElement(By.xpath(".//a[contains(text(),'View Product')]"));
                clickElement(viewDetailsButton);
                return new ProductDetailsPage();
            }
        }
        throw new RuntimeException("Product Not Found:  " + productName);

    }

}
