#language: en

Feature: Wishlist functionality DemoWebshop Application

  Background:
    Given that I access demo webshop application
    When I click on login button
    And I input the default credentials


    @ExecuteTest @WishListScenario @AddToWishList @ValidateItemInWishListPage
    Scenario Outline: Inserting blue shoes item in my wishlist
      And I select "<menu>" menu in menu bar
      And I click on "<item>" inside the shop page
      And I click in add to wishlist button
      And I click in wishlist link in top bar
      Then I can see the selected item "<item>" inside wishlist table

      Examples:
      |menu               |item                      |
      | Apparel & Shoes   |  Blue and green Sneaker  |

      @ExecuteTest @WishListScenario @AddToWishList @ValidateItemInWishListPage @RemoveItemFromWishList
      Scenario Outline: Removing all items from wishlist
        And I select "<menu>" menu in menu bar
        And I click on "<item>" inside the shop page
        And I click in add to wishlist button
        And I click in wishlist link in top bar
        And I can see the selected item "<item>" inside wishlist table
        And I check remove checkbox for all items
        And I click in update wishlist button
        Then I can see the wishlist table empty

        Examples:
          |menu               |item                                         |
          | Apparel & Shoes   |  50's Rockabilly Polka Dot Top JR Plus Size |

    @ExecuteTest @WishListScenario @AddToWishList @ValidateItemInWishListPage
    Scenario Outline: Go to wishlist page via product added to wishlist message
      And I select "<menu>" menu in menu bar
      And I click on "<item>" inside the shop page
      And I click in add to wishlist button
      And I click in wishlist link in product added to your wishlist message
      And I can see the selected item "<item>" inside wishlist table
      And I check remove checkbox for all items
      And I click in update wishlist button
      Then I can see the wishlist table empty

      Examples:
        |menu               |item                          |
        | Jewelry           |  Black & White Diamond Heart |

  @ExecuteTest @WishListScenario @AddToWishList @ValidateItemInWishListPage @CartAndWishlist
    Scenario Outline: Move the item from wishlist to shop cartScenario Outline: Go to wishlist page via product added to wishlist message
      And I select "<menu>" menu in menu bar
      And I click on "<item>" inside the shop page
      And I click in add to wishlist button
      And I click in wishlist link in product added to your wishlist message
      And I can see the selected item "<item>" inside wishlist table
      And I check the selected item "<item>" add to cart checkbox
      And I click in add to cart button inside the wishlist page
      Then I can see the item "<item>" inside the cart table

      Examples:
          |menu               |item                          |
          | Jewelry           |  Black & White Diamond Heart |

  @ExecuteTest @WishListScenario @AddToWishList @ValidateItemInWishListPage @CartAndWishlist
   Scenario Outline: Add an item to wishlist and increase it quantity in wishlist page
     And I select "<menu>" menu in menu bar
     And I click on "<item>" inside the shop page
     And I click in add to wishlist button
     And I click in wishlist link in product added to your wishlist message
     And I can see the selected item "<item>" inside wishlist table
     And I modify them item "<item>" quantity to "<quantity>"
     Then I validate that the item "<item>" quantity was updated to "<quantity>"
     Examples:
       |menu               |item                          | quantity|
       | Jewelry           |  Black & White Diamond Heart | 3       |

  @ExecuteTest @WishListScenario @AddToWishList @ValidateItemInWishListPage @ValidateQuantityAndPrice
    Scenario Outline: Validate that increasing the item quantity it price will be increased as well
      And I click in wishlist link in top bar
      And I check remove checkbox for all items
      And I click in update wishlist button
      And I select "<menu>" menu in menu bar
      And I click on "<item>" inside the shop page
      And I click in add to wishlist button
      And I click in wishlist link in product added to your wishlist message
      And I can see the selected item "<item>" inside wishlist table
      And I modify them item "<item>" quantity to "<quantity>"
      And I validate that the item "<item>" quantity was updated to "<quantity>"
      Then I can see that the price item "<item>" was updated according it quantity
      Examples:
        |menu               |item                          | quantity|
        | Jewelry           |  Black & White Diamond Heart | 3       |
