package step_definition.cart;

import actions.cart_action.CartAction;
import base.BasePage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static project_global_variables.GlobalVariables.KEY_CART_QUANTITY;
import static project_global_variables.GlobalVariables.RANDOM_PRODUCT_NAME;

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

    @Then("I validate that the shopping cart got updated with the selected item")
    public void iValidateThatTheShoppingCartGotUpdatedWithTheSelectedItem() {
        Assert.assertTrue(cartAction.isProductInsideCartTable(genericMethods.getValueFromHashMap(RANDOM_PRODUCT_NAME)));
    }

    @And("I check remove checkbox for all shopping cart items")
    public void iCheckRemoveCheckboxForAllShoppingCartItems() {
        cartAction.removeAllItemsFromShoppingCart();
    }

    @And("I fill a random zipcode in shopping cart")
    public void iFillARandomZipcodeInShoppingCart() {
        if(!genericMethods.getValueFromHashMap(RANDOM_PRODUCT_NAME).equalsIgnoreCase("$25 Virtual Gift Card")){
            Faker faker = new Faker();
            cartAction.fillZipPostalCode(faker.idNumber().toString());
        }else{
            System.out.println("######### NO NEED TO INPUT THE ZIPCODE ##########");
        }
    }

    @And("I click in estimate shipping in shopping cart page")
    public void iClickInEstimateShippingInShoppingCartPage() {
        cartAction.clickEstimateShippingButton();
    }

    @Then("I validate that the shipping results panel is displayed")
    public void iValidateThatTheShippingResultsPanelIsDisplayed() {
        Assert.assertTrue(cartAction.isEstimateShippingResults());
    }

    @And("I check terms of services checkbox in shopping cart page")
    public void iCheckTermsOfServicesCheckboxInShoppingCartPage() {
        cartAction.checkTermsOfServiceCheckbox();
    }

    @Then("I click in checkout button in shopping cart page")
    public void iClickInCheckoutButtonInShoppingCartPage() {
        cartAction.clickCheckouBtn();
    }

    @Then("I can see that the checkout page is displayed")
    public void iCanSeeThatTheCheckoutPageIsDisplayed() {
        Assert.assertTrue(cartAction.isInCheckoutPage());
    }
}
