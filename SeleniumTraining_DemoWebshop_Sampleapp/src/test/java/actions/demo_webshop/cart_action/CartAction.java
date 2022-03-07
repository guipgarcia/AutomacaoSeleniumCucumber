package actions.demo_webshop.cart_action;

import pages.demo_webshop.cart_page.CartPage;

public class CartAction extends CartPage {

    public void clickOnDesktopOption(){
        genericMethods.validateVisibilityOfElement(desktopOption);
        genericMethods.click(desktopOption);
    }
}
