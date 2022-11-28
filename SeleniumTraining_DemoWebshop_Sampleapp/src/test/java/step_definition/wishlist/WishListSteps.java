package step_definition.wishlist;

import actions.wishlist_action.WishlistAction;
import base.BasePage;
import io.cucumber.java.en.Then;

public class WishListSteps extends BasePage {
    private WishlistAction wishlistAction = new WishlistAction();

    @Then("I can see the selected item {string} inside wishlist table")
    public void iCanSeeTheSelectedItemInsideWishlistTable(String productName) {
        wishlistAction.validateProductInWishList(productName);
    }

}
