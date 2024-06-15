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



