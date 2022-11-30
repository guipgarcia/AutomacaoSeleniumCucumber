package step_definition.shop;

import actions.shop_action.ShopAction;
import base.BasePage;
import io.cucumber.java.en.And;

public class ShopSteps extends BasePage {

    private ShopAction shopAction = new ShopAction();

    @And("I click on {string} inside the shop page")
    public void iClickOnInsideTheShopPage(String item) {
        shopAction.selectAnItemInShop(item);
    }

    @And("I click in add to wishlist button")
    public void iClickInAddToWishlistButton() {
        shopAction.clickAddToWishListButton();
    }

    @And("I click in wishlist link in product added to your wishlist message")
    public void iClickInWishlistLinkInProductAddedToYourWishlistMessage() {
        shopAction.clickOnProductAddedToWishlistLink();
    }
}
