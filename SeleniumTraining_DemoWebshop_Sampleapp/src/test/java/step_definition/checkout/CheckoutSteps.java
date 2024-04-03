package step_definition.checkout;

import actions.checkout_action.CheckoutAction;
import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static project_global_variables.GlobalVariables.RANDOM_PRODUCT_NAME;

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

    @And("I click in continue button for shipping method page")
    public void iClickInContinueButtonForShippingMethodPage() {
        Assert.assertTrue(checkoutAction.isInShippingMethodTab());
        checkoutAction.clickInShippingMethodContinueBtn();
    }

    @And("I click in continue button for payment method page")
    public void iClickInContinueButtonForPaymentMethodPage() {
        Assert.assertTrue(checkoutAction.isInPaymentMethodTab());
        checkoutAction.clickInPaymentMethodContinueBtn();
    }

    @And("I click in continue button for payment information page")
    public void iClickInContinueButtonForPaymentInformationPage() {
        Assert.assertTrue(checkoutAction.isInPaymentInformationTab());
        checkoutAction.clickInPaymentInformationContinueBtn();
    }

    @Then("I validate that the selected product is inside confirm order page and click in confirm button")
    public void iValidateThatTheSelectedProductIsInsideConfirmOrderPageAndClickInConfirmButton() {
        Assert.assertTrue(checkoutAction.isProductInsideConfirmOrder(genericMethods.getValueFromHashMap(RANDOM_PRODUCT_NAME)));
        Assert.assertTrue(checkoutAction.isInConfirmOrderTab());
        checkoutAction.clickInConfirmOrderBtn();
    }

    @And("I validate that the order was processed with success")
    public void iValidateThatTheOrderWasProcessedWithSuccess() {
        Assert.assertTrue(checkoutAction.isOrderProcessedWithSuccessMessage());
    }

    @Then("I complete the whole process to buy a product just clicking in ok for each page")
    public void iCompleteTheWholeProcessToBuyAProductJustClickingInOkForEachPage() {
        Assert.assertTrue(checkoutAction.isInBillingAddressTab());
        checkoutAction.clickInBillingAddressContinueBtn();
        if (!genericMethods.getValueFromHashMap(RANDOM_PRODUCT_NAME).contains("Gift Card")) {
            Assert.assertTrue(checkoutAction.isInShippingAddressTab());
            checkoutAction.clickInShippingAddressContinueBtn();
            Assert.assertTrue(checkoutAction.isInShippingMethodTab());
            checkoutAction.clickInShippingMethodContinueBtn();
        }
        Assert.assertTrue(checkoutAction.isInPaymentMethodTab());
        checkoutAction.clickInPaymentMethodContinueBtn();
        Assert.assertTrue(checkoutAction.isInPaymentInformationTab());
        checkoutAction.clickInPaymentInformationContinueBtn();
    }
}
