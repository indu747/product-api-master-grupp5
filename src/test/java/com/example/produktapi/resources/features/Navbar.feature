Feature: Navbar
  #Erik Östlind
  Scenario Outline: Navbar contains all items and are clickable on any page
    Given user is on <page>
    Then navbar has four links
    Then the <nth_item> contains a <text>
    And the <nth_item> contain link to <href>
    When user clicks on the <nth_item>
    Then user should get taken to <href>
    Examples:
      |page           |nth_item |href                                                          |text            |
      |"homepage"     |0        |"https://webshop-agil-testautomatiserare.netlify.app/"        |"🛍️ The Shop"   |
      |"homepage"     |1        |"https://webshop-agil-testautomatiserare.netlify.app/"        |"Home"          |
      |"homepage"     |2        |"https://webshop-agil-testautomatiserare.netlify.app/products"|"Shop"          |
      |"homepage"     |3        |"https://webshop-agil-testautomatiserare.netlify.app/checkout"|"🛒 Checkout"   |
      |"shop_page"    |0        |"https://webshop-agil-testautomatiserare.netlify.app/"        |"🛍️ The Shop"   |
      |"shop_page"    |1        |"https://webshop-agil-testautomatiserare.netlify.app/"        |"Home"          |
      |"shop_page"    |2        |"https://webshop-agil-testautomatiserare.netlify.app/products"|"Shop"          |
      |"shop_page"    |3        |"https://webshop-agil-testautomatiserare.netlify.app/checkout"|"🛒 Checkout"   |
      |"checkout_page"|0        |"https://webshop-agil-testautomatiserare.netlify.app/"        |"🛍️ The Shop"   |
      |"checkout_page"|1        |"https://webshop-agil-testautomatiserare.netlify.app/"        |"Home"          |
      |"checkout_page"|2        |"https://webshop-agil-testautomatiserare.netlify.app/products"|"Shop"          |
      |"checkout_page"|3        |"https://webshop-agil-testautomatiserare.netlify.app/checkout"|"🛒 Checkout"   |
  #Erik Östlind
  Scenario:User clicks on Logo
    Given user is on "homepage"
    When user clicks on "🛍️ The Shop"
    Then user should get taken to "https://webshop-agil-testautomatiserare.netlify.app/"
  #Erik Östlind
  Scenario: User clicks on Home
    Given user is on "homepage"
    When user clicks on "Home"
    Then user should get taken to "https://webshop-agil-testautomatiserare.netlify.app/"
  #Erik Östlind
  Scenario: User clicks on Shop
    Given user is on "homepage"
    When user clicks on "Shop"
    Then user should get taken to "https://webshop-agil-testautomatiserare.netlify.app/products"
  #Erik Östlind
  Scenario: User clicks on Checkout
    Given user is on "homepage"
    When user clicks on "🛒 Checkout"
    Then user should get taken to "https://webshop-agil-testautomatiserare.netlify.app/checkout"


