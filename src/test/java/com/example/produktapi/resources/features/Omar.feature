Feature: The shop

    # Omar
  Scenario: Electronics should show and works correctly
    Given user visits webshop-agil-testautomatiserare.netlify.app/products
    When user click on Electronics
    Then have a category-text "WD 2TB Elements Portable External Hard Drive - USB 3.0"

    # Omar
  Scenario: Checkout, the items added and works correctly
    Given user visits webshop-agil-testautomatiserare.netlify.app/products
    When user click on Electronics
    And user click a SanDisk SSD product for add to cart
    Then shows one product on checkout "1"
    When user click on checkout button
    Then user get on checkout page have text "Checkout form"
    And the product name is "SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s"
    And the product price is "$109"
    And the product Total (USD) is "Total (USD)"
    And the product total price is "$109.00"

    # Omar
  Scenario: Add a product and delete it from checkout and works correctly
    Given user visits webshop-agil-testautomatiserare.netlify.app/products
    When user click on Electronics
    And user click a SanDisk SSD product for add to cart
    Then shows one product on checkout "1"
    When user click on checkout button
    Then user get on checkout page have text "Checkout form"
    And the product name is "SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s"
    And the cart size is shown "1"
    When user click on delete button
    Then the product "SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s" should not be visited
    And the cart size is shown "0"
    And the product total price is zero "$0.00"
    And shows zero product on checkout "0"

    # Omar
  Scenario: Search a item and it works correctly
    Given user visits webshop-agil-testautomatiserare.netlify.app/products
    When user type Pierced in the search field
    Then the product "Pierced Owl Rose Gold Plated Stainless Steel Double" should be visited
    And the product, item "Mens Casual Premium Slim Fit T-Shirts" should not be visited

    # Omar
  Scenario: Search a item in electronics works correctly
    Given user visits webshop-agil-testautomatiserare.netlify.app/products
    When user click on Electronics
    And user type Silicon in the search field
    Then the product Silicon Power "Silicon Power 256GB SSD 3D NAND A55 SLC Cache Performance Boost SATA III 2.5" should be visited

    # Omar
  Scenario: Search a item in Mens Clothing works correctly
    Given user visits webshop-agil-testautomatiserare.netlify.app/products
    When user click on Mens Clothing
    And user type Mens Casual Slim in the search field
    Then the product Mens Causal Slim "Mens Casual Slim Fit" should be visited

    # Omar
  Scenario: Search a item in Womens Clothing works correctly
    Given user visits webshop-agil-testautomatiserare.netlify.app/products
    When user click on Womens Clothing
    And user type Opna in the search field
    Then the product Opna in Womens clothing "Opna Women's Short Sleeve Moisture" should be visited

    # Omar
  Scenario: Search a item in Jewelery works correctly
    Given user visits webshop-agil-testautomatiserare.netlify.app/products
    When user click on category Jewelery
    And user type White Gold in the search field
    Then the product White Gold in Jewelery "White Gold Plated Princess" should be visited


