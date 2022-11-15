package actions.home_action;

import generic_methods.GenericMethods;
import org.junit.Assert;
import pages.home_page.HomePage;

import static project_global_variables.GlobalVariables.DEMO_WEBSHOP_APPLICATION;

public class HomeAction extends HomePage {

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
}
