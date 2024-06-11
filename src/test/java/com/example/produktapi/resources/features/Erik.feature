Feature: Erik
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


#Erik östlind
  Scenario Outline: User sorts by category Jewelery and all cards contain all elements
    Given User is on page "https://webshop-agil-testautomatiserare.netlify.app/products"
    When user clicks on category "Jewelery"
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
      | nth  |image_link                                                        | product_name                                                                 | price   | description                                             |
      | 0    |"https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg"|"John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet" |"$ 695"  |"Silver drakens återkomst. Ett måste om man vill ha den!"|
      | 1    |"https://fakestoreapi.com/img/61sbMiUnoGL._AC_UL640_QL65_ML3_.jpg"|"SolGold Petite Micropave"                                                    |"$ 168"  |"Denna blir man glad av."                                |
      | 2    |"https://fakestoreapi.com/img/71YAIFU48IL._AC_UL640_QL65_ML3_.jpg"|"White Gold Plated Princess"                                                  |"$ 9.99" |"Prinsessans bästa vän. Köp för att få den i din ägo"    |
      | 3    |"https://fakestoreapi.com/img/51UDEzMJVpL._AC_UL640_QL65_ML3_.jpg"|"Pierced Owl Rose Gold Plated Stainless Steel Double"                         |"$ 10.99"|"Något med en uggla, och i guld och lite dubbel stål"    |