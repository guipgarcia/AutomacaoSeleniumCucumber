package actions.cart_action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.cart_page.CartPage;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class CartAction extends CartPage {

    private String baseMap;
    public void clickOnDesktopOption(){
        genericMethods.validateVisibilityOfElement(desktopOption);
        genericMethods.click(desktopOption);
    }

    public void validateProductInsideCartTable(String productName){
        baseMap = "//tbody//td[@class = 'product']/*[text()=\""+productName+"\"]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(baseMap)));
        WebElement product = driver.findElement(By.xpath(baseMap));
        genericMethods.validateVisibilityOfElement(product);
        genericMethods.highlight(product);
    }

    public boolean isProductInsideCartTable(String productName){
        baseMap = "//tbody//td[@class = 'product']/*[text()=\""+productName+"\"]";
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(baseMap)));
            WebElement product = driver.findElement(By.xpath(baseMap));
            genericMethods.highlight(product);
            return true;
        }catch(Exception e){}
        return false;
    }

    private int getProductQuantity(String productName){
        baseMap = "//table[@class = 'cart']//tr[@class = 'cart-item-row']//a[text() = '"+productName+"']";
        String quantityText = "";
        int productQty = 0;
        try{
            WebElement itemQuantity = driver.findElement(By.xpath(baseMap+"/../../td[@class='qty nobr']/input"));
            quantityText = itemQuantity.getAttribute("value");
            productQty = Integer.parseInt(quantityText);
        }catch (Exception e){}
        return productQty;
    }
    public Integer getQuantityForDesiredProduct(String productName){
        boolean isProductExists = isProductInsideCartTable(productName);
        if(isProductExists){
            return getProductQuantity(productName);
        }else
            return 0;
    }

    public void removeAllItemsFromShoppingCart(){
        try {
            baseMap = "//td[@class = 'remove-from-cart']";
            List<WebElement> removeFromCart = driver.findElements(xpath(baseMap));
            for (int i = 0; i < removeFromCart.size(); i++) {
                genericMethods.click(removeFromCart.get(i));
            }
            genericMethods.click(updateCartButton);
        }catch (Exception e){}
        genericMethods.validateVisibilityOfElement(yourShoppingCartIsEmptyMessage);
    }

    public void fillZipPostalCode(String zipcode){
        genericMethods.validateVisibilityOfElement(zipPostalCodeField);
        genericMethods.sendKeys(zipPostalCodeField, zipcode);
    }

    public void clickEstimateShippingButton(){
        genericMethods.validateVisibilityOfElement(estimateShippingBtn);
        genericMethods.click(estimateShippingBtn);
    }

    public boolean isEstimateShippingResults(){
       try {
           genericMethods.validateVisibilityOfElement(shippingResults);
           genericMethods.highlight(shippingResults);
           return true;
       }catch (Exception e){}
       return false;
    }

    public void checkTermsOfServiceCheckbox(){
        genericMethods.click(termsOfServiceCheckbox);
    }

    public void clickCheckouBtn(){
        genericMethods.click(checkoutBtn);
    }

    public boolean isInCheckoutPage(){
        try {
            genericMethods.validateVisibilityOfElement(checkoutPageTitle);
            return true;
        }catch (Exception ignored){}
        return false;
    }
}
