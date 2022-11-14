package actions.cart_action;

import pages.cart_page.CartPage;

public class CartAction extends CartPage {

    public void clickOnDesktopOption(){
        genericMethods.validateVisibilityOfElement(desktopOption);
        genericMethods.click(desktopOption);
    }
}
