Feature: Testing Shopping Cart Functionalities
  Background:
    Given that I access demo webshop application
    And I click on login button
    And I input the default credentials

  @Developings @ShoppingCart @AddRandomProductToTheCart
  Scenario: Add product inside Shopping Cart Table From HomePage
    And I click in shopping cart menu
    And I check remove checkbox for all shopping cart items
    And I navigate to home page
    When I add a random product to cart from featured products tab
    And I validate if it is necessary to proceed with extra information on product
    And I click in shopping cart menu
    Then I validate that the shopping cart got updated with the selected item


  @Developings @ShoppingCart @AddRandomProductToTheCart
  Scenario: Add a random product from home page and estimate the shipping for the selected product
    And I click in shopping cart menu
    And I check remove checkbox for all shopping cart items
    And I navigate to home page
    When I add a random product to cart from featured products tab
    And I validate if it is necessary to proceed with extra information on product
    And I click in shopping cart menu
    And I validate that the shopping cart got updated with the selected item
    And I fill a random zipcode in shopping cart
    And I click in estimate shipping in shopping cart page
    Then I validate that the shipping results panel is displayed


  @Developings @ShoppingCart @AddRandomProductToTheCart
  Scenario: Add a random product from home page and estimate the shipping for the selected product
    And I click in shopping cart menu
    And I check remove checkbox for all shopping cart items
    And I navigate to home page
    When I add a random product to cart from featured products tab
    And I validate if it is necessary to proceed with extra information on product
    And I click in shopping cart menu
    And I validate that the shopping cart got updated with the selected item
    And I fill a random zipcode in shopping cart
    And I click in estimate shipping in shopping cart page
    And I validate that the shipping results panel is displayed
    And I check terms of services checkbox in shopping cart page
    And I click in checkout button in shopping cart page
    Then I can see that the checkout page is displayed

  @Developing @ShoppingCart @AddRandomProductToTheCart
  Scenario: Buy a random product
    And I click in shopping cart menu
    And I check remove checkbox for all shopping cart items
    And I navigate to home page
    When I add a random product to cart from featured products tab
    And I validate if it is necessary to proceed with extra information on product
    And I click in shopping cart menu
    And I validate that the shopping cart got updated with the selected item
    And I fill a random zipcode in shopping cart
    And I click in estimate shipping in shopping cart page
    And I validate that the shipping results panel is displayed
    And I check terms of services checkbox in shopping cart page
    And I click in checkout button in shopping cart page
    And I can see that the checkout page is displayed
    And I click in continue button for billing address page
    And I click in continue button for shipping address page