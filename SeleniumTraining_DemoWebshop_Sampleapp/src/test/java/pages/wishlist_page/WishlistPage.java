package pages.wishlist_page;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends BasePage {

    @FindBy (xpath = "//div[@class = 'page-title']//*[contains(text(), 'Wishlist')]")
    protected WebElement wishListPageTitle;
}
