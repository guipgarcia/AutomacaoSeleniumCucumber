package step_definition.cart;

import actions.cart_action.CartAction;
import base.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps extends BasePage {

    private CartAction cartAction = new CartAction();

    @When("I select the desktop option")
    public void i_select_the_desktop_option() {
        cartAction.clickOnDesktopOption();
    }

    @Then("I can see the item {string} inside the cart table")
    public void iCanSeeTheItemInsideTheCartTable(String arg0) {
    }
}
