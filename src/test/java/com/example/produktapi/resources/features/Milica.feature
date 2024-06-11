Feature: Search Functionality on Webshop (Milica)

  Scenario: Searching for a specific product type
    Given User is on the product page
    When After user writes "Mens Casual Premium Slim" in search bar
    Then "Mens Casual Premium Slim" should be displayed

