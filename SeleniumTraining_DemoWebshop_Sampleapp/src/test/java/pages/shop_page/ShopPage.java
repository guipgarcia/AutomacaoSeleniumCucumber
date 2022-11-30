package pages.shop_page;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends BasePage {
    @FindBy(className = "page category-page")
    protected WebElement shopPage;

    @FindBy(xpath = "//*[contains(@id , 'add-to-wishlist-button')]")
    protected WebElement addToWishListBtn;

    @FindBy(xpath = "//p[@class = 'content' and text() = 'The product has been added to your ']/a[@href='/wishlist']")
    protected WebElement productAddedToWishlistMessage;
}
