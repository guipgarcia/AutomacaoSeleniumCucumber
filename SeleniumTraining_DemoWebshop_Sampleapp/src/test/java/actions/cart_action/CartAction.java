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

    public void validateProductInsideCartTable(String productName){
        baseMap = "//tbody//td[@class = 'product']/*[text()=\""+productName+"\"]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(baseMap)));
        WebElement product = driver.findElement(By.xpath(baseMap));
        genericMethods.validateVisibilityOfElement(product);
        genericMethods.highlight(product);
    }
}
