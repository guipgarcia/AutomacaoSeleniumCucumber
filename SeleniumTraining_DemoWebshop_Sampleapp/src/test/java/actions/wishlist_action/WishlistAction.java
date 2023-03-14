package actions.wishlist_action;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        try{
            genericMethods.validateVisibilityOfElement(updateWishlistBtn);
            genericMethods.click(updateWishlistBtn);
        }catch (Exception e){
            System.out.println("############ WISHLIST UPDATE BUTTON IS NOT AVAILABLE ############");
        }
    }

    public void checkRemoveCheckboxForAllItems(){
        genericMethods.sleep(3000);
        itemBaseMap = "//tbody//td[@class = 'remove-from-cart']/input";
        try {
            wishListItems = driver.findElements(By.xpath(itemBaseMap));
            for (int i = 0; i < wishListItems.size(); i++)
                genericMethods.click(wishListItems.get(i));
        }catch(Exception e){
            System.out.println("########## WISHLIST WAS ALREADY EMPTY ##########");
        }

    }

    public void modifyProductQuantity(String productName, String quantity){
        WebElement mappedItem = getProductQuantityMap(productName);
        mappedItem.clear();
        genericMethods.sendKeys(mappedItem, quantity);
        genericMethods.sendKeys(mappedItem, String.valueOf(Keys.ENTER));
        genericMethods.sleep(10000);
    }

    public void validateProductQuantity(String productName, String quantity){
        WebElement mappedElement = getProductQuantityMap(productName);
        Assert.assertEquals(quantity,mappedElement.getAttribute("value"));
    }

    public void validateItemPriceAccordingItemQuantity(String productName){
        System.out.println("Product Price: " + getProductPriceMap(productName).getText()
                + "\nProduct Subtotal: " + getProductSubTotalMap(productName).getText()
                + "\nProduct Quantity: " + getProductQuantityMap(productName).getAttribute("value"));
        float price = Float.parseFloat(getProductPriceMap(productName).getText()),
                subtotal = Float.parseFloat(getProductSubTotalMap(productName).getText()),
                quantity = Integer.parseInt(getProductQuantityMap(productName).getAttribute("value"));

        Assert.assertTrue(quantity * price == subtotal);
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

    private WebElement getProductQuantityMap(String productName){
        itemBaseMap = "//tbody//td[@class = 'product']/*[text()=\""+productName+"\"]/ancestor::tr//input[contains(@name, 'itemquantity')]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(itemBaseMap)));
        return driver.findElement(By.xpath(itemBaseMap));
    }

    private WebElement getProductPriceMap(String productName){
        itemBaseMap = "//tbody//td[@class = 'product']/*[text()=\""+productName+"\"]/ancestor::tr//span[@class = 'product-unit-price']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(itemBaseMap)));
        return driver.findElement(By.xpath(itemBaseMap));
    }

    private WebElement getProductSubTotalMap(String productName){
        itemBaseMap = "//tbody//td[@class = 'product']/*[text()=\""+productName+"\"]/ancestor::tr//span[@class = 'product-subtotal']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(itemBaseMap)));
        return driver.findElement(By.xpath(itemBaseMap));
    }

}
