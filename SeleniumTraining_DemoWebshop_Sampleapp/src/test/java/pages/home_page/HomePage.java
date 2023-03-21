package pages.home_page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//div[@class='header-links']//a[text() = 'Log in']")
    protected WebElement loginLink;

    @FindBy(className = "ico-logout")
    protected WebElement logoutLink;

    @FindBy(xpath =  "//div[@class='page-title']/*[contains(text(), 'Please Sign In')]")
    protected WebElement validateLoginScreen;

    @FindBy(xpath = "//div[@class='header-links']//a[@class='ico-logout']")
    protected WebElement logoutButton;

    @FindBy(xpath = "//ul[@class='top-menu']//a[contains(text(),'Computers')]")
    protected WebElement topMenuComputers;

    @FindBy(id = "topcartlink")
    protected WebElement shoppingCartLink;

    @FindBy(className = "ico-register")
    protected WebElement registerLink;

    @FindBy(className = "ico-wishlist")
    protected WebElement wishListLink;

    @FindBy(xpath = "//p[@class = 'content' and text() = 'The product has been added to your ']/a[@href='/cart']")
    protected WebElement productAddedToCartMessage;

    @FindBy(xpath = "//*[@id = 'bar-notification']//span")
    protected WebElement closeMessage;

    @FindBy(xpath = "//*[@alt = 'Tricentis Demo Web Shop']")
    protected WebElement homePageImg;
}

