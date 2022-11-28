package pages.shop_page;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends BasePage {
    @FindBy(className = "page category-page")
    protected WebElement shopPage;

    @FindBy(xpath = "//*[contains(@id , 'add-to-wishlist-button')]")
    protected WebElement addToWishListBtn;
}
