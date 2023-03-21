Feature: Testing Shopping Cart Functionalities
  Background:
    Given that I access demo webshop application
    And I click on login button
    And I input the default credentials

  @Developing @ShoppingCart @AddRandomProductToTheCart
  Scenario: Add product inside Shopping Cart Table From HomePage
    And I click in shopping cart menu
    And I check remove checkbox for all shopping cart items
    And I navigate to home page
    When I add a random product to cart from featured products tab
    And I validate if it is necessary to proceed with extra information on product
    And I click in shopping cart menu
    Then I validate that the shopping cart got updated with the selected item


