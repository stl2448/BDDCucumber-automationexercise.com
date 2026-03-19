package pages;

import base.BasePage;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage() {
        super();
    }

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
}
