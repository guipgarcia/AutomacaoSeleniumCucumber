package actions.shop_action;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.shop_page.ShopPage;

import java.util.List;
import java.util.Random;

import static org.openqa.selenium.By.xpath;

public class ShopAction extends ShopPage {
    private String currentMapString = "";

    public void selectAnItemInShop(String item){
        // Wait for the visibility of shop page body, then execute a click on the desired item
        genericMethods.click(dynamicMapForSelectItem(item));
    }

    public void clickAddToWishListButton(){
        // Wait for the visibility of add to wishlist button, then execute a click on it
        genericMethods.validateVisibilityOfElement(addToWishListBtn);
        genericMethods.click(addToWishListBtn);

        // Wait for product added to your wishlist message to appear
        genericMethods.validateVisibilityOfElement(productAddedToWishlistMessage);
    }

    public void clickOnProductAddedToWishlistLink(){
        genericMethods.click(productAddedToWishlistMessage);
    }

    public WebElement dynamicMapForSelectItem(String item){
        // Saving the base path to search inside the page and concatenating with the class variable
        currentMapString = "//*[@class ='product-title']//a[text() = \""+item+"\"]";
        System.out.println(currentMapString);
        // Waiting for the element to be located and returning it
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath(currentMapString)));
        return driver.findElement(xpath(currentMapString));
    }

    public void validateExtraStepsBeforeAddToCart(){
        genericMethods.validateVisibilityOfElement(productDetailsPage);
        try{
            genericMethods.sendKeys(recipientNameField, "TestName");
            genericMethods.sendKeys(recipientEmailField, "TestName@email.com");
        }catch(Exception e){
            try{
                currentMapString = "//*[contains(text(), '320 GB')]/ancestor::ul/li";
                List<WebElement> randomOption = driver.findElements(xpath(currentMapString));
                Random random = new Random();
                int  randomIndex = random.nextInt(randomOption.size());
                genericMethods.click(driver.findElement(xpath(currentMapString+"["+randomIndex+"]/input")));
            }catch(Exception es){
                genericMethods.click(processorSlowOption);
            }
        }
    }
    public void clickOnAddToCartButton(){
        genericMethods.validateVisibilityOfElement(addToCartBtn);
        genericMethods.click(addToCartBtn);
        genericMethods.validateVisibilityOfElement(productAddedToCartMessage);
        genericMethods.click(closeMessage);
        wait.until(ExpectedConditions.invisibilityOf(closeMessage));
    }


}
