Feature: Verify Cart page functionalities

  @wip
Scenario Outline: Verify Product quantity in Cart
  Given user launch application
  When user click on Products button
  Then Products page is displayed
  When user clicked on View Product button for the product using <productName>
  Then product details page is displayed
  When user updated the product quantity <productQuantity>
  And clicked on Add to cart button
  Then product is displayed in cart page with exact quantity

Examples:
| productName | productQuantity |
|Winter Top| 5          |