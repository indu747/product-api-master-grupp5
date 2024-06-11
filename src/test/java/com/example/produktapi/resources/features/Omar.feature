Feature: The Shop

    # Omar
    Scenario: Electronics should show and works correctly
        Given user visits webshop-agil-testautomatiserare.netlify.app/products
        When user click on Electronics
        Then have a catergory-text "WD 2TB Elements Portable External Hard Drive - USB 3.0"

    # Omar
    Scenario: Checkout, the items added and works correctly
        Given user visits webshop-agil-testautomatiserare.netlify.app/products
        When user click on Electronics
        And added to cart a product SanDisk SSD
        Then shows one product on checkout "1"
        When user click on checkout button
        Then user get on checkout page have text "Checkout form"
        And the product name is "SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s"
        And the product price is "$109"
        And the product Total (USD) is "Total (USD)"
        And the product total price is "$109.00"
