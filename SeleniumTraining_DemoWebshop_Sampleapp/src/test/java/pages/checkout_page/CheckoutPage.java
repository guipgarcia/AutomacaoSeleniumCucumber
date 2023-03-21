package pages.checkout_page;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    @FindBy(xpath = "//li[@id = 'opc-billing' and contains(@class, 'active')]")
    protected WebElement billingAddressTab;

    @FindBy(xpath = "//*[@id = 'billing-buttons-container']/input")
    protected WebElement continueBtnForBillingAddress;

    @FindBy(xpath = "//li[@id = 'opc-shipping' and contains(@class, 'allow')]")
    protected WebElement shippingAddressTab;

    @FindBy(xpath = "//*[@id = 'shipping-buttons-container']/input")
    protected WebElement continueBtnForShippingAddress;
}
