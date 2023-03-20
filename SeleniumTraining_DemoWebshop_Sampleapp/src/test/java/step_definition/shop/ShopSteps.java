package step_definition.shop;

import actions.shop_action.ShopAction;
import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static project_global_variables.GlobalVariables.KEY_EXTRA_CART_STEPS;

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

    @And("In shop page I click in Add to Cart button one more time")
    public void inShopPageIClickInAddToCartButtonOneMoreTime() {
        if(genericMethods.getValueFromHashMap(KEY_EXTRA_CART_STEPS).equalsIgnoreCase("true")) {
            shopAction.validateExtraStepsBeforeAddToCart();
            shopAction.clickOnAddToCartButton();
        }
    }

    @Then("I validate that the shopping cart got updated with the selected item")
    public void iValidateThatTheShoppingCartGotUpdatedWithTheSelectedItem() {
    }
}
