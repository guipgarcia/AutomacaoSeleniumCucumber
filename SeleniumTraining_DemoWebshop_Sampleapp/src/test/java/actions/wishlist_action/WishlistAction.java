package actions.wishlist_action;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.wishlist_page.WishlistPage;

import java.util.List;

public class WishlistAction extends WishlistPage {

    private List<WebElement> wishListItems;
    private String item, itemBaseMap;

    private boolean isProductInWishlist(String productName){
        item = productName;
        itemBaseMap = "//tbody//tr";
        wishListItems = driver.findElements(By.xpath(itemBaseMap));
        for(int i = 1; i <= wishListItems.size(); i++) {
            if (driver.findElement(By.xpath(itemBaseMap + "[" + i + "]/td[@class='product']/a")).getText().contains(productName))
                return true;
        }
        return false;
    }

    public void validateProductInWishList(String productName){
        genericMethods.validateVisibilityOfElement(wishListPageTitle);
        Assert.assertTrue(isProductInWishlist(productName));
    }
}
