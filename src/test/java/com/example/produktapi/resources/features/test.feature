Feature: ITHS.se

  Scenario: users visits google.se
    When User visits google.se
    Then URL is google.se

  Scenario: user visit webshop
    Given user visit https://webshop-agil-testautomatiserare.netlify.app/
    Then the title should be "Webbutiken"
