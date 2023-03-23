package pages.cart_page;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class ='sub-category-grid']//a[contains(@title, 'Desktops')]/parent::div[@class = 'picture']")
    protected WebElement desktopOption;

    @FindBy(name = "updatecart")
    protected WebElement updateCartButton;

    @FindBy(xpath = "//*[@class = 'page shopping-cart-page']//*[contains(text(), 'Your Shopping Cart is empty!')]")
    protected WebElement yourShoppingCartIsEmptyMessage;

    @FindBy(id = "ZipPostalCode")
    protected WebElement zipPostalCodeField;

    @FindBy(name = "estimateshipping")
    protected WebElement estimateShippingBtn;

    @FindBy(xpath = "//ul[@class = 'shipping-results']")
    protected WebElement shippingResults;

    @FindBy(id = "termsofservice")
    protected WebElement termsOfServiceCheckbox;

    @FindBy(id = "checkout")
    protected WebElement checkoutBtn;

    @FindBy(xpath = "//div[@class ='page-title']/*[text() = 'Checkout']")
    protected WebElement checkoutPageTitle;
}
