package actions.shop_action;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.shop_page.ShopPage;

import static org.openqa.selenium.By.xpath;

public class ShopAction extends ShopPage {
    private String currentMapString = "";

    public void selectAnItemInShop(String item){
        // Wait for the visibility of shop page body, then execute a click on the desired item
        wait.until(ExpectedConditions.visibilityOf(shopPage));
        genericMethods.click(dynamicMapForSelectItem(item));
    }

    public WebElement dynamicMapForSelectItem(String item){
        // Saving the base path to search inside the page and concatenating with the class variable
        currentMapString = "//a[text() = '"+item+"']";

        // Waiting for the element to be located and returning it
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath(currentMapString)));
        return driver.findElement(xpath(currentMapString));
    }
}
