package step_definition.demo_webshop.cart;

import actions.demo_webshop.cart_action.CartAction;
import base.BasePage;
import io.cucumber.java.en.When;

public class CartSteps extends BasePage {

    private CartAction cartAction = new CartAction();

    @When("I select the desktop option")
    public void i_select_the_desktop_option() {
        cartAction.clickOnDesktopOption();
    }
}
