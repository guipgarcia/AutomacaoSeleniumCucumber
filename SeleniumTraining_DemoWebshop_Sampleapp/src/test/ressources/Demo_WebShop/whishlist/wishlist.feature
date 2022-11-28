#language: en

Feature: Wishlist functionality DemoWebshop Application

  Background:
    Given that I access demo webshop application
    When I click on login button
    And I input the default credentials


    @ExecuteTest @WishListScenario @AddToWishList @ValidateItemInWishListPage
    Scenario Outline: Putting blue shoes item in my wishlist
      And I select "<menu>" menu in menu bar
      And I click on "<item>" inside the shop page
      And I click in add to wishlist button
      And I click in wishlist link in top bar
      Then I can see the selected item "<item>" inside wishlist table

      Examples:
      |menu               |item                      |
      | Apparel & Shoes   |  Blue and green Sneaker  |
