Feature: Add Product to Cart

  @addToCart
  Scenario Outline: Verify product added to Cart
    Given user launch application
    When user click on Products button
    Then Products page is displayed
    When user clicked on add to cart button for the product using <productName>
    Then product added to the cart successfully
    Examples:
      | productName |
      |Fancy Green Top|


