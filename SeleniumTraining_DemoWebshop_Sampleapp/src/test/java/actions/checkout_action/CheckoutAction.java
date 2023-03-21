package actions.checkout_action;

import pages.checkout_page.CheckoutPage;

public class CheckoutAction extends CheckoutPage {
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
}
