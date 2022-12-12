package step_definition.wishlist;

import actions.wishlist_action.WishlistAction;
import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class WishListSteps extends BasePage {
    private WishlistAction wishlistAction = new WishlistAction();

    @Then("I can see the selected item {string} inside wishlist table")
    public void iCanSeeTheSelectedItemInsideWishlistTable(String productName) {
        wishlistAction.validateProductInWishList(productName);
    }

    @Then("I can see the wishlist table empty")
    public void iCanSeeTheWishlistTableEmpty() {
        wishlistAction.validateWishlistTableEmpty();
    }

    @And("I click in update wishlist button")
    public void iClickInUpdateWishlistButton() {
        wishlistAction.clickUpdateWishlistBtn();
    }

    @And("I check remove checkbox for all items")
    public void iCheckRemoveCheckboxForAllItems() {
        wishlistAction.checkRemoveCheckboxForAllItems();
    }

    @And("I check the selected item {string} add to cart checkbox")
    public void iCheckTheSelectedItemAddToCartCheckbox(String productName) {
        wishlistAction.addSpecificItemToCart(productName);
        genericMethods.sleep(5000);
    }

    @And("I click in add to cart button inside the wishlist page")
    public void iClickInAddToCartButtonInsideTheWishlistPage() {
        wishlistAction.clickAddToCartButton();
    }

    @And("I modify them item {string} quantity to {string}")
    public void iModifyThemItemQuantityTo(String productName, String quantity) {
        wishlistAction.modifyProductQuantity(productName, quantity);
    }

    @Then("I validate that the item {string} quantity was updated to {string}")
    public void iValidateThatTheItemQuantityWasUpdatedTo(String productName, String quantity) {
        wishlistAction.validateProductQuantity(productName, quantity);
    }

    @Then("I can see that the price item {string} was updated according it quantity")
    public void iCanSeeThatThePriceItemWasUpdatedAccordingItQuantity(String productItem) {
        wishlistAction.validateItemPriceAccordingItemQuantity(productItem);
    }
}
