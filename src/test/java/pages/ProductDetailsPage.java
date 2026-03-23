package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waits;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage() {
        super();
    }

    @FindBy(xpath="//div[@class='product-information']/h2")
    private WebElement productName;

    @FindBy(xpath="//input[@id='quantity']")
    private WebElement productQuantity;

    @FindBy(xpath="//button[normalize-space()='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(xpath="//div[@class='modal-body']//p[contains(text(),'product has been added to cart')]")
    private WebElement addedToCartText;

    @FindBy(xpath="//u[normalize-space()='View Cart']")
    private WebElement viewCartButton;

    public boolean verifyProductDetailsPage()
    {
      String pageTitle = getPageTitle();
      if (pageTitle.contains("Product Details"))
      {
          return true;
      }else
      {
          return false;
      }
    }

    public boolean verifyProductByName(String Name)
    {
        Waits.waitForVisibilityOfElement(productName);
        if(productName.getText().equalsIgnoreCase(Name))
        {
            return true;
        } else {
            return false;
        }
    }

    public void updateProductQuantity(int quantity)
    {
        Waits.waitForVisibilityOfElement(productQuantity);
        productQuantity.clear();
        productQuantity.sendKeys(String.valueOf(quantity));
    }

    public void clickAddToCart()
    {
        Waits.waitForElementToBeClickable(addToCartButton);
        clickElement(addToCartButton);
    }

    public boolean isProductAddedToCart()
    {
        Waits.waitForVisibilityOfElement(addedToCartText);
        if(addedToCartText.getText().contains("product has been added to cart"))
        {
            return true;
        } else
        {
            return false;
        }
    }

    public CartPage clickViewCart()
    {
        Waits.waitForVisibilityOfElement(viewCartButton);
        clickElement(viewCartButton);
        return new CartPage();
    }
}
