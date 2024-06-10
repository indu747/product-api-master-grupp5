Feature: Product listing verification

  Scenario: Verify the number of products in Women's clothing category
    Given I am on the product page
    When I select "Women's clothing" from navigation
    Then I should see exactly 6 products listed