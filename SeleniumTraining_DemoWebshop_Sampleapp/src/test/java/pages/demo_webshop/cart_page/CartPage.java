package pages.demo_webshop.cart_page;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class ='sub-category-grid']//a[contains(@title, 'Desktops')]/parent::div[@class = 'picture']")
    protected WebElement desktopOption;
}
