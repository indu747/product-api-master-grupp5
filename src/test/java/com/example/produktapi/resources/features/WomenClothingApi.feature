Feature: Women's Clothing Category API Tests

  Scenario: Verify response and content for Women's Clothing category
    When I request the "women's clothing" category
    Then the response status should be 200
    And the response should contain "Women's 3-in-1 Snowboard Jacket Winter Coats"
