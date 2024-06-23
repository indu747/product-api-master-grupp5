Feature: Patricia

  Scenario: Mens Clothing - Fjallraven
    Given the user is on mans clothing
    Then the title of the product should be "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"


  Scenario: Mens Clothing - Fjallraven pris
    Given the user is on mans clothing
    Then the price should be "$ 109.95"

  Scenario: Mens Clothing - T-Shirt
    Given the user is on mans clothing
    Then the tittle of the product should be "Mens Casual Premium Slim Fit T-Shirts"

  Scenario: : Mens Clothing - T-Shirt Price
    Given the user is on mans clothing
    Then the price of the t-shirt should be "$ 22.3"

  Scenario: Mans Clothing - Jacket
    Given the user is on mans clothing
    Then the title should be "Mens Cotton Jacket"

  Scenario: Mans Clothing - Jacket price
    Given the user is on mans clothing
    Then the price of the jacket should be "$ 55.99"

  Scenario: Mans Clothing - Polo
    Given the user is on mans clothing
    Then the title of the polo should be "Mens Casual Slim Fit"

  Scenario: Mans Clothing - Polo Price
    Given the user is on mans clothing
    Then the price of the polo should be "$ 15.99"

  Scenario: Desription Fjallraven is correct
    Given the user is on mans clothing
    Then the description fjallraven should be "Fin väska me plats för dator"

  Scenario: Description T-shirt is correct
    Given the user is on mans clothing
    Then the desription t-shirt shoud be "Vilken härlig t-shirt, slim fit o casual i ett!"

    Scenario: Description Jacket is correct
      Given the user is on mans clothing
      Then the description Jacket should be "Bomullsjacka, vad finns det mer att säga?!"

    Scenario: Desription Polo is correct
      Given the user is on mans clothing
      Then the desription Polo shpuld be "Mer casual än såhär blir det inte!"

    Scenario: User should be able to use the homepage in mobilesize
      Given the user is on the homepage
      When user use it with mobilesize
      Then user should be able to click on "All products" in the middle of the page

    Scenario: Verify headings are visible - Mens clothing
      Given the user is on mans clothing
      Then heading should be "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"
      And Tshirt "Mens Casual Premium Slim Fit T-Shirts"
      And Jacket "Mens Cotton Jacket"
      And Slim fit "Mens Casual Slim Fit"

    Scenario: Verify heading are clickable - Mens
      Given the user is on mans clothing
      When user clicks on All
      Then all products will shown

    Scenario: Verify heading are clickable - Jelewery
      Given the user is on mans clothing
      When user clicks Jewelery
      Then Jewelery will shown

      Scenario: Verify heading are clickable - electronics
        Given the user is on mans clothing
        When user clicks on electronics
        Then electronics will shown

      Scenario: Verify the text on the homepage 1
        Given the user is on the homepage
        Then the text should be "Welcome to The Shop, your premier online destination for all things fashion, electronics, and jewelry! At The Shop, we pride ourselves on offering a curated selection of high-quality products to cater to your diverse needs and desires."

      Scenario: Verify the text on the homepage 2
        Given the user is on the homepage
        Then the text should be this "This shop is all you need"

      Scenario: Verify that you can add a fjallraven to checkout
        Given the user is on mans clothing
        When user add fjallraven
        Then the product will be added to checkout "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"

      Scenario: Veriyfy that you can add a Tshirt to Checkout
        Given the user is on mans clothing
        When user add t-shirt
        Then t-shirt should be added to checkout "Mens Casual Premium Slim Fit T-Shirts"








