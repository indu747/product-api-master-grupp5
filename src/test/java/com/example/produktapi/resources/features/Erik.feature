Feature: Erik

  ##HOMEPAGE FEATURE
  Scenario: All items exists with correct content on HomePage
    Given user is on "homepage"
    Then h2 is set to "This shop is all you need"
    And lead is set to "Welcome to The Shop, your premier online destination for all things fashion, electronics, and jewelry! At The Shop, we pride ourselves on offering a curated selection of high-quality products to cater to your diverse needs and desires."
    And "All products" button exist with correct text
    And Image is displayed

  Scenario:
    Given user is on "homepage"
    When user clicks on "All Products" - button
    Then user should get taken to Shop page
    And product cards should be displayed
  ##NAVBAR FEATURE
  #Erik Östlind
  Scenario Outline: Navbar contains all items and are clickable on any page
    Given user is on <page>
    Then navbar has 5 links
    Then the <nth_item> contains a <text>
    And the <nth_item> contain link to <href>
    When user clicks on the <nth_item>
    Then user should get taken to <href>
    Examples:
      |page           |nth_item |href                                                          |text            |
      |"homepage"     |0        |"https://webshop-agil-testautomatiserare.netlify.app/"        |"🛍️ The Shop"   |
      |"homepage"     |1        |"https://webshop-agil-testautomatiserare.netlify.app/"        |"Home"          |
      |"homepage"     |2        |"https://webshop-agil-testautomatiserare.netlify.app/products"|"Shop"          |
      |"about_page"   |3        |"https://webshop-agil-testautomatiserare.netlify.app/about"   |"About"         |
      |"homepage"     |4        |"https://webshop-agil-testautomatiserare.netlify.app/checkout"|"🛒 Checkout"   |
      |"about_page"   |3        |"https://webshop-agil-testautomatiserare.netlify.app/about"   |"About"         |
      |"shop_page"    |0        |"https://webshop-agil-testautomatiserare.netlify.app/"        |"🛍️ The Shop"   |
      |"shop_page"    |1        |"https://webshop-agil-testautomatiserare.netlify.app/"        |"Home"          |
      |"shop_page"    |2        |"https://webshop-agil-testautomatiserare.netlify.app/products"|"Shop"          |
      |"about_page"   |3        |"https://webshop-agil-testautomatiserare.netlify.app/about"   |"About"         |
      |"shop_page"    |4        |"https://webshop-agil-testautomatiserare.netlify.app/checkout"|"🛒 Checkout"   |
      |"checkout_page"|0        |"https://webshop-agil-testautomatiserare.netlify.app/"        |"🛍️ The Shop"   |
      |"checkout_page"|1        |"https://webshop-agil-testautomatiserare.netlify.app/"        |"Home"          |
      |"checkout_page"|2        |"https://webshop-agil-testautomatiserare.netlify.app/products"|"Shop"          |
      |"about_page"   |3        |"https://webshop-agil-testautomatiserare.netlify.app/about"   |"About"         |
      |"checkout_page"|4        |"https://webshop-agil-testautomatiserare.netlify.app/checkout"|"🛒 Checkout"   |

#SHOP FEATURE
#Erik östlind
  Scenario Outline: User sorts by category Jewelery and all cards contain all elements
    Given User is on page "https://webshop-agil-testautomatiserare.netlify.app/products"
    When user clicks on category <category>
    Then 4 products should be displayed
    And the <nth> card should have <image_link> as image link
    And the <nth> card should have <product_name> as alt text
    And the <nth> card should have visible image
    And the <nth> card should have <product_name> as title
    And the <nth> card should have <price> as price
    And the <nth> card should have <description> as description
    And the <nth> card should have a checkout button
    And the <nth> card checkout button should have text "➕ Add to cart"
    Examples:
      |category | nth    |image_link                                                        | product_name                                                                 | price   | description                                             |
      |"Jewelery"| 0      |"https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg"|"John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet" |"$ 695"  |"Silver drakens återkomst. Ett måste om man vill ha den!"|
      |"Jewelery"| 1      |"https://fakestoreapi.com/img/61sbMiUnoGL._AC_UL640_QL65_ML3_.jpg"|"SolGold Petite Micropave"                                                    |"$ 168"  |"Denna blir man glad av."                                |
      |"Jewelery"| 2      |"https://fakestoreapi.com/img/71YAIFU48IL._AC_UL640_QL65_ML3_.jpg"|"White Gold Plated Princess"                                                  |"$ 9.99" |"Prinsessans bästa vän. Köp för att få den i din ägo"    |
      |"Jewelery"| 3      |"https://fakestoreapi.com/img/51UDEzMJVpL._AC_UL640_QL65_ML3_.jpg"|"Pierced Owl Rose Gold Plated Stainless Steel Double"                         |"$ 10.99"|"Något med en uggla, och i guld och lite dubbel stål"    |

    Scenario Outline:User searches in shop page
      Given user is on "shop_page"
      When user searches for <title>
      Then only cards containing <title> should be visible
      Examples:
        | title                     |
        |"men"                      |
        |"women"                    |
        |"gold"                     |
        |"solgold petite micropave"|

      Scenario Outline: User adds an item to cart and can see it on checkout page
        Given User is on page "https://webshop-agil-testautomatiserare.netlify.app/products"
        When user clicks on category <category>
        And add a product with title <title> to cart
        Then the checkout button should have 1 in it
        When user clicks the checkout button
        Then the user can see selected product <title> in cart
        And the product should have correct <category> in cartlist
        And the total price is <double>

        Examples:
          | category  | title                                                                       | double|
          | "Jewelery"|"SolGold Petite Micropave"                                                   |168.0  |
          | "Jewelery"|"John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet"|695.0  |
          | "Jewelery"|"White Gold Plated Princess"                                                 |9.99   |
          | "Jewelery"|"Pierced Owl Rose Gold Plated Stainless Steel Double"                        |10.99  |


  Scenario Outline: User adds multiple items to cart and total price is correct on checkout page
    Given User is on page "https://webshop-agil-testautomatiserare.netlify.app/products"
    When user clicks on category <category>
    And add a product with title <title> to cart
    And add a product with title <title2> to cart
    Then the checkout button should have 2 in it
    When user clicks the checkout button
    And the total price is <total>
    Examples:
          | category  | title                       |title2                                                                        | total|
          | "Jewelery"|"SolGold Petite Micropave"   | "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet"|863.0 |
          | "Jewelery"|"White Gold Plated Princess" |"Pierced Owl Rose Gold Plated Stainless Steel Double"                         |20.98 |

Scenario Outline: Validation works on all fields in billing section
  Given user is on "checkout_page"
  When user enter nothing into <locatorID> field and press enter
  Then on the <nth> field should have <correct label> as label
  Then <invalid message> should be displayed for <nth> field
  When user enter <validinput> into <locatorID> field and press enter
  Then validation should pass on <nth> field
  Examples:
    | locatorID | nth | invalid message                                          | validinput    |correct label|
    |"firstName"|0    |"Valid first name is required."                           |"Erik"         |"First name" |
    |"lastName" |1    |"Valid last name is required."                            | "Östlind"     |"Last name"  |
    |"email"    |2    |"Please enter a valid email address for shipping updates."|"erik@erik.com"|"Email"      |
    |"address"  |3    |"Please enter your shipping address."                     |"adress 1"     |"Address"     |
    |"country"  |4    |"Please select a valid country."                          |"Sweden"       |"Country"    |
    |"city"     |5    |"Please provide a valid state."                           |"stockholm"    |"City"       |
    |"zip"      |6    |"Zip code required."                                      |"666 66"       |"Zip"        |

Scenario Outline: Validation works on all fields in card section
  Given user is on "checkout_page"
  When user scrolls down to <nth> card field
  When user enter nothing into <nth> field and press enter
  Then <invalid message> error message should be displayed for <nth> field
  Then on the <nth> field should have <correct label> as label in the card section
  When  user enter <validinput> into <nth> field and press enter
  Then Then validation should pass on <nth> field
  Examples:
    | nth | invalid message                  | correct label        | validinput        |
    |  0  | "Name on card is required"       | "Name on card"       | "Erik Östlind"    |
    |  1  | "Credit card number is required" | "Credit card number" | "1234567898765432"|
    |  2  | "Expiration date required"       | "Expiration"         | "12/28"           |
    |  3  |"Security code required"          | "CVV"                | "123"             |













