Feature: Search functionality on web shop

  Scenario: Searching for a specific product type
    Given User is on the product page
    When After user writes "Mens Casual Premium Slim" in search bar
    Then "Mens Casual Premium Slim" should be displayed

  Scenario: Verify the number of products in Women's clothing category
    Given I am on the product page
    When I select "Women's clothing" from navigation
    Then I should see exactly 6 products listed