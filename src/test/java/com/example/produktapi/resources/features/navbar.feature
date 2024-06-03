Feature: Navbar

  Scenario Outline: Navbar contains all items and are clickable on homepage
    Given user is on homepage
    Then navbar has four links
    Then the <nth Item> contains a <text>
    And the <nth Item> contain link to <href>
    When user clicks on the <nth Item>
    Then user should get taken to <href>
    Examples:
      |nth Item|href|text|
      |0    |"https://webshop-agil-testautomatiserare.netlify.app/"|"🛍️ The Shop"|
      |1    |"https://webshop-agil-testautomatiserare.netlify.app/"|"Home"       |
      |2    |"https://webshop-agil-testautomatiserare.netlify.app/products"|"Shop"|
      |3    |"https://webshop-agil-testautomatiserare.netlify.app/checkout"|"🛒 Checkout"|
