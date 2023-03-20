package pages.shop_page;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends BasePage {
    @FindBy(className = "page category-page")
    protected WebElement shopPage;

    @FindBy(xpath = "//*[contains(@id , 'add-to-wishlist-button')]")
    protected WebElement addToWishListBtn;

    @FindBy(xpath = "//*[contains(@id, 'add-to-cart-button')]")
    protected WebElement addToCartBtn;

    @FindBy(xpath = "//p[@class = 'content' and text() = 'The product has been added to your ']/a[@href='/wishlist']")
    protected WebElement productAddedToWishlistMessage;

    @FindBy(xpath = "//p[@class = 'content' and text() = 'The product has been added to your ']/a[@href='/cart']")
    protected WebElement productAddedToCartMessage;

    @FindBy(id = "giftcard_2_RecipientName")
    protected WebElement recipientNameField;

    @FindBy(id = "giftcard_2_RecipientEmail")
    protected WebElement recipientEmailField;
    @FindBy(xpath = "//*[@for = 'giftcard_2_RecipientEmail']")
    protected WebElement recipientEmailLabel;

    @FindBy(xpath = "//*[@class = 'text-prompt' and contains(text(), 'HDD')]")
    protected WebElement hddLabel;

    @FindBy(xpath = "//ul[@class = 'option-list']//*[contains(text(), 'Slow')]")
    protected WebElement processorSlowOption;
}
