package actions.wishlist_action;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.wishlist_page.WishlistPage;

import java.util.List;

import static project_global_variables.GlobalVariables.WISHLIST_EMPTY_MESSAGE;

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

    public void validateWishlistTableEmpty(){
        genericMethods.validateVisibilityOfElement(wishlistTableEmpty);
        genericMethods.assertContains(wishlistTableEmpty, WISHLIST_EMPTY_MESSAGE);
    }

    public void clickUpdateWishlistBtn(){
        genericMethods.validateVisibilityOfElement(updateWishlistBtn);
        genericMethods.click(updateWishlistBtn);
    }

    public void checkRemoveCheckboxForAllItems(){
        itemBaseMap = "//tbody//td[@class = 'remove-from-cart']/input";
        wishListItems = driver.findElements(By.xpath(itemBaseMap));
        for(int i = 0; i < wishListItems.size(); i++)
            genericMethods.click(wishListItems.get(i));
    }

    public void addSpecificItemToCart(String productName){
        itemBaseMap = "//tbody/tr["+ getProductIndex(productName)
                +"]/td[@class = 'add-to-cart']/input";
        genericMethods.click(driver.findElement(By.xpath(itemBaseMap)));
    }

    public void clickAddToCartButton(){
        genericMethods.validateVisibilityOfElement(addToCartBtn);
        genericMethods.click(addToCartBtn);
    }
    private Integer getProductIndex(String productName){
        itemBaseMap = "//tbody//td[@class = 'product']//a";
        wishListItems = driver.findElements(By.xpath(itemBaseMap));
        for(int i = 0; i < wishListItems.size(); i++){
            if(wishListItems.get(i).getText().equals(productName))
                return i+1;
        }
        return 0;
    }

}
