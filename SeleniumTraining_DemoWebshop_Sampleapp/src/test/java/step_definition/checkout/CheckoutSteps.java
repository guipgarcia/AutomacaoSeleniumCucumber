package step_definition.checkout;

import actions.checkout_action.CheckoutAction;
import base.BasePage;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class CheckoutSteps extends BasePage {

    private CheckoutAction checkoutAction = new CheckoutAction();

    @And("I click in continue button for billing address page")
    public void iClickInContinueButtonForBillingAddressPage() {
        Assert.assertTrue(checkoutAction.isInBillingAddressTab());
        checkoutAction.clickInBillingAddressContinueBtn();
    }

    @And("I click in continue button for shipping address page")
    public void iClickInContinueButtonForShippingAddressPage() {
        Assert.assertTrue(checkoutAction.isInShippingAddressTab());
        checkoutAction.clickInShippingAddressContinueBtn();
    }
}
