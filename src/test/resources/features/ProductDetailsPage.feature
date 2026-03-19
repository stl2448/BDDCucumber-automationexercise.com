Feature: Verify Product Details Page

  @productDetails @wip
  Scenario Outline: Verify product details page
    Given user launch application
    When user click on Products button
    Then Products page is displayed
    When user clicked on View Product button for the product using <productName>
    Then product details page is displayed

    Examples:
      | productName |
      |Winter Top|


