package actions.demo_webshop.home_action;

import generic_methods.GenericMethods;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.demo_webshop.home_page.HomePage;

public class HomeAction extends HomePage {

    public GenericMethods genericMethods = new GenericMethods();

    public void clickOnLoginLink() {
        // Click on login link
        genericMethods.click(loginLink);

        // Validate Login Screen Visibility
        genericMethods.validateVisibilityOfElement(validateLoginScreen);

    }

    public void sucessLoginValidation() {
        genericMethods.validateVisibilityOfElement(logoutButton);
    }

    public void selectComputerOptionOnTopMenu(){
        genericMethods.validateVisibilityOfElement(topMenuComputers);
        genericMethods.click(topMenuComputers);
    }
}
