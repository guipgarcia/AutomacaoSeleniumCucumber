package actions.home_action;

import generic_methods.GenericMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.home_page.HomePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.By.xpath;
import static project_global_variables.GlobalVariables.DEMO_WEBSHOP_APPLICATION;
import static project_global_variables.GlobalVariables.KEY_EXTRA_CART_STEPS;

public class HomeAction extends HomePage {
    private String currentMapString = "";
    public GenericMethods genericMethods = new GenericMethods();

    public void clickOnLoginLink() {
        // Click on login link
        genericMethods.click(loginLink);

        // Validate Login Screen Visibility
        genericMethods.validateVisibilityOfElement(validateLoginScreen);

    }

    public void sucessLoginValidation() {
        // Validate the visibility of logout link> that means that the user is logged in
        genericMethods.validateVisibilityOfElement(logoutButton);
    }

    public void selectComputerOptionOnTopMenu(){
        genericMethods.validateVisibilityOfElement(topMenuComputers);
        genericMethods.click(topMenuComputers);
    }

    public void clickLogoutLink(){
        // Wait for logout link to be visible, then execute a click on it
        genericMethods.validateVisibilityOfElement(logoutLink);
        genericMethods.click(logoutLink);
    }

    public void validateHomePage(){
        Assert.assertEquals(DEMO_WEBSHOP_APPLICATION, driver.getCurrentUrl());
    }

    public void clickInRegisterLink(){
        // Wait for register link to be visible, then execute a click on it
        genericMethods.validateVisibilityOfElement(registerLink);
        genericMethods.click(registerLink);
    }

    public void clickInWishListLink(){
        // Wait for wishlist link to be visible, then execute a click on it
        genericMethods.validateVisibilityOfElement(wishListLink);
        genericMethods.click(wishListLink);
    }

    public void selectTopMenu(String menu){
        genericMethods.click(dynamicMapForTopMenu(menu));
    }


    public WebElement dynamicMapForTopMenu(String menu){
        currentMapString = "//ul[@class = 'top-menu']//a[contains(text(), '"+menu+"')]";
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath(currentMapString)));
        return driver.findElement(xpath(currentMapString));
    }

    public void addRandomProductToCartFromFeaturedProductsTab(){
        currentMapString = "//div[@class = 'product-grid home-page-product-grid']/div[@class = 'item-box']";
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath(currentMapString)));
        List<WebElement> featuredProductsElements = driver.findElements(xpath(currentMapString));
        Random randomNumber = new Random();
        int randomIndex = randomNumber.nextInt(featuredProductsElements.size());
        WebElement currentFeaturedProduct = driver.findElement(xpath(currentMapString+"["+randomIndex+"]//div[@class = 'buttons']"));
        genericMethods.click(currentFeaturedProduct);
        try{
            genericMethods.validateVisibilityOfElement(productAddedToCartMessage);
            genericMethods.addToHashMap(KEY_EXTRA_CART_STEPS, "false");
        }catch(Exception e){
            System.out.println("######### EXTRA STEPS FOR ADD TO CART ARE REQUIRED ########");
            genericMethods.addToHashMap(KEY_EXTRA_CART_STEPS, "true");
        }
    }
}
