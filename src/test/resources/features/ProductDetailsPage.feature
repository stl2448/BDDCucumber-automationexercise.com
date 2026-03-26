Feature: Verify Product Details Page

  @productDetails
  Scenario Outline: Verify product details page
    Given user launch application
    When user click on Products button
    Then Products page is displayed
    When user clicked on View Product button for the product using <productName>
    Then product details page is displayed

    Examples:
      | productName |
      |Winter Top|

  Scenario Outline: Update product quantity and click Add to cart
    Given user launch application
    When user click on Products button
    Then Products page is displayed
    When user clicked on View Product button for the product using <productName>
    Then product details page is displayed
    When user updated the product quantity <productQuantity>
    And clicked on Add to cart button
    Then product <productName> is added to the cart

    Examples:
      | productName | productQuantity |
      |Winter Top| 5          |
