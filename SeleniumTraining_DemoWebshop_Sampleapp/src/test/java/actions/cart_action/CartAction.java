package actions.cart_action;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.cart_page.CartPage;

public class CartAction extends CartPage {

    private String baseMap;
    public void clickOnDesktopOption(){
        genericMethods.validateVisibilityOfElement(desktopOption);
        genericMethods.click(desktopOption);
    }

    public void accessShoppingCart(){
        genericMethods.validateVisibilityOfElement(shoppingCartLink);
        genericMethods.click(shoppingCartLink);
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
}
