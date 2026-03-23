package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waits;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage()
    {
        super();
    }
    @FindBy(xpath="//td[@class='cart_description']//a")
    WebElement productName;

    @FindBy(xpath="//td[@class='cart_quantity']/button")
    WebElement productQuantity;

    @FindBy(xpath="//tbody")
    WebElement cartBody;

    public boolean checkProductByName(String productName)
    {
        Waits.waitForVisibilityOfElement(cartBody);
        List<WebElement> productRows = cartBody.findElements(By.tagName("tr"));
        for(WebElement row : productRows)
        {
            WebElement cartDescription = row.findElement(By.xpath(".//td[@class='cart_description']"));
           String name = cartDescription.findElement(By.xpath(".//h4/a")).getText();
           if(name.equals(productName))
           {
               return true;
           }
        }
        return false;
    }

    public boolean checkProductQuantity(int productQuantity)
    {
        Waits.waitForVisibilityOfElement(cartBody);
        List<WebElement> productRows = cartBody.findElements(By.tagName("tr"));
        for(WebElement row : productRows)
        {
            WebElement cartQuantity = row.findElement(By.xpath(".//td[@class='cart_quantity']"));
            int quantity = Integer.parseInt(cartQuantity.findElement(By.xpath(".//button")).getText());
            if(quantity == productQuantity)
            {
                return true;
            }
        }
        return false;
    }
}
