package actions.checkout_action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.checkout_page.CheckoutPage;

public class CheckoutAction extends CheckoutPage {

    private String baseMap;
    WebElement baseElement;
    public boolean isInBillingAddressTab(){
        try{
            genericMethods.validateVisibilityOfElement(billingAddressTab);
        return true;
        }catch (Exception ignore){}
        return false;
    }
    public void clickInBillingAddressContinueBtn(){
        genericMethods.validateVisibilityOfElement(continueBtnForBillingAddress);
        genericMethods.click(continueBtnForBillingAddress);
    }

    public boolean isInShippingAddressTab(){
        try{
            genericMethods.validateVisibilityOfElement(shippingAddressTab);
            return true;
        }catch (Exception ignore){}
        return false;
    }

    public void clickInShippingAddressContinueBtn(){
        genericMethods.validateVisibilityOfElement(continueBtnForShippingAddress);
        genericMethods.click(continueBtnForShippingAddress);
    }

    public boolean isInShippingMethodTab(){
        try{
            genericMethods.validateVisibilityOfElement(shippingMethodTab);
            return true;
        }catch (Exception ignore){}
        return false;
    }

    public void clickInShippingMethodContinueBtn(){
        genericMethods.validateVisibilityOfElement(continueBtnForShippingMethod);
        genericMethods.click(continueBtnForShippingMethod);
    }

    public boolean isInPaymentMethodTab(){
        try{
            genericMethods.validateVisibilityOfElement(paymentMethodTab);
            return true;
        }catch (Exception ignore){}
        return false;
    }

    public void clickInPaymentMethodContinueBtn(){
        genericMethods.validateVisibilityOfElement(continueBtnForPaymentMethod);
        genericMethods.click(continueBtnForPaymentMethod);
    }

    public boolean isInPaymentInformationTab(){
        try{
            genericMethods.validateVisibilityOfElement(paymentInformationTab);
            return true;
        }catch (Exception ignore){}
        return false;
    }

    public void clickInPaymentInformationContinueBtn(){
        genericMethods.validateVisibilityOfElement(continueBtnForPaymentInformation);
        genericMethods.click(continueBtnForPaymentInformation);
    }

    public boolean isProductInsideConfirmOrder(String productName){
        baseMap = "//table[@class= 'cart']//td/a[text() = '"+productName+"']";
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(baseMap)));
            baseElement = driver.findElement(By.xpath(baseMap));
            genericMethods.highlight(baseElement);
            return true;
        }catch (Exception ignored){}
        return false;
    }

    public boolean isInConfirmOrderTab(){
        try{
            genericMethods.validateVisibilityOfElement(confirmOrderTab);
            return true;
        }catch (Exception ignore){}
        return false;
    }

    public void clickInConfirmOrderBtn(){
        genericMethods.validateVisibilityOfElement(confirmBtnForConfirmOrder);
        genericMethods.click(confirmBtnForConfirmOrder);
    }

    public boolean isOrderProcessedWithSuccessMessage(){
        try{
            genericMethods.validateVisibilityOfElement(orderProcessedWithSuccessMsg);
            genericMethods.highlight(orderProcessedWithSuccessMsg);
            return true;
        }catch (Exception ignored){}
        return false;
    }
}
