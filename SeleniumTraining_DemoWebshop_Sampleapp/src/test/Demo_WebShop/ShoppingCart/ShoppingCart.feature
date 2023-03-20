Feature: Testing Shopping Cart Functionalities
  Background:
    Given that I access demo webshop application
    And I click on login button
    And I input the default credentials

  @Developing
  Scenario: Add product inside Shopping Cart Table From HomePage
    When I add a random product to cart from featured products tab
    And In shop page I click in Add to Cart button one more time
    And I click in shopping cart menu
    Then I validate that the shopping cart got updated with the selected item

