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

    @FindBy(xpath = "//li[@id = 'opc-shipping_method' and contains(@class, 'allow')]")
    protected WebElement shippingMethodTab;

    @FindBy(xpath = "//*[@id = 'shipping-method-buttons-container']/input")
    protected WebElement continueBtnForShippingMethod;


    @FindBy(xpath = "//li[@id = 'opc-payment_method' and contains(@class, 'allow')]")
    protected WebElement paymentMethodTab;

    @FindBy(xpath = "//*[@id = 'payment-method-buttons-container']/input")
    protected WebElement continueBtnForPaymentMethod;

    @FindBy(xpath = "//li[@id = 'opc-payment_info' and contains(@class, 'allow')]")
    protected WebElement paymentInformationTab;

    @FindBy(xpath = "//*[@id = 'payment-info-buttons-container']/input")
    protected WebElement continueBtnForPaymentInformation;

    @FindBy(xpath = "//li[@id = 'opc-confirm_order' and contains(@class, 'allow')]")
    protected WebElement confirmOrderTab;

    @FindBy(xpath = "//*[@id = 'confirm-order-buttons-container']/input")
    protected WebElement confirmBtnForConfirmOrder;

    @FindBy(xpath = "//div[@class ='section order-completed']//*[text() = 'Your order has been successfully processed!']")
    protected WebElement orderProcessedWithSuccessMsg;
}
