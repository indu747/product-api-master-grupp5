Feature: Shop
Scenario: User sorts by category Jewelery
 Given User is on "https://webshop-agil-testautomatiserare.netlify.app/products"
  When user clicks on sort "Jewelery"
  Then 4 products should be displayed
  And  each product has a name
  And each product has a price
  And each product has a "Add to cart" button
  And each product has a description
