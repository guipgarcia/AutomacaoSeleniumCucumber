package step_definition.cart;

import actions.cart_action.CartAction;
import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static project_global_variables.GlobalVariables.KEY_CART_QUANTITY;

public class CartSteps extends BasePage {

    private CartAction cartAction = new CartAction();

    @When("I select the desktop option")
    public void i_select_the_desktop_option() {
        cartAction.clickOnDesktopOption();
    }

    @Then("I can see the item {string} inside the cart table")
    public void iCanSeeTheItemInsideTheCartTable(String productName) {
        cartAction.validateProductInsideCartTable(productName);
    }

    @And("I click in shopping cart menu")
    public void iClickInShoppingCartMenu() {
        cartAction.accessShoppingCart();
    }

    @Then("I validate that the product {string} was added to shopping cart table")
    public void iValidateThatTheProductWasAddedToShoppingCartTable(String productName) {
        Assert.assertTrue(cartAction.isProductInsideCartTable(productName));
    }

    @And("I take note from the {string} quantity inside the shopcart")
    public void iTakeNoteFromTheQuantityInsideTheShopcart(String productName) {
        genericMethods.addToHashMap(KEY_CART_QUANTITY,cartAction.getQuantityForDesiredProduct(productName).toString());
    }

    @And("I validate that the product {string} has the expected quantity {string}")
    public void iValidateThatTheProductHasTheExpectedQuantity(String productName, String quantity) {
        Integer oldQuantity = Integer.parseInt(genericMethods.getValueFromHashMap(KEY_CART_QUANTITY)),
                addedQuantity = Integer.parseInt(quantity);
        Assert.assertEquals((int) cartAction.getQuantityForDesiredProduct(productName), oldQuantity + addedQuantity);
    }
}
