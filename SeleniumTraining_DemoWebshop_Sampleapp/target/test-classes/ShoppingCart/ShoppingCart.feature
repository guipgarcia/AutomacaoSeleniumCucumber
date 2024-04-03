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
    And I click in shopping cart menu
    Then I validate that the shopping cart got updated with the selected item


  @Developing @ShoppingCart @AddRandomProductToTheCart
  Scenario: Add a random product from home page and estimate the shipping for the selected product
    And I click in shopping cart menu
    And I check remove checkbox for all shopping cart items
    And I navigate to home page
    When I add a random product to cart from featured products tab
    And I click in shopping cart menu
    And I validate that the shopping cart got updated with the selected item
    Then I fill a random zipcode in shopping cart
    And I validate that the shipping estimation is present on screen


  @Developing @ShoppingCart @AddRandomProductToTheCart
  Scenario: Add a random product and go to checkout page
    And I click in shopping cart menu
    And I check remove checkbox for all shopping cart items
    And I navigate to home page
    When I add a random product to cart from featured products tab
    And I click in shopping cart menu
    And I validate that the shopping cart got updated with the selected item
    Then I check terms of services checkbox in shopping cart page
    And I click in checkout button in shopping cart page
    And I can see that the checkout page is displayed

  @Developing @ShoppingCart @AddRandomProductToTheCart
  Scenario: Buy a random product
    And I click in shopping cart menu
    And I check remove checkbox for all shopping cart items
    And I navigate to home page
    When I add a random product to cart from featured products tab
    And I click in shopping cart menu
    And I validate that the shopping cart got updated with the selected item
    And I complete the product checkout
    Then I complete the whole process to buy a product just clicking in ok for each page
    And I validate that the selected product is inside confirm order page and click in confirm button
    And I validate that the order was processed with success
