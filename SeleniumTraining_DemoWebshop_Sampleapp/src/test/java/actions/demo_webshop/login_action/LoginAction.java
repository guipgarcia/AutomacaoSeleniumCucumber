package actions.demo_webshop.login_action;

import generic_methods.GenericMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.demo_webshop.login_page.LoginPage;

import static org.openqa.selenium.By.xpath;

public class LoginAction extends LoginPage {

    public GenericMethods genericMethods = new GenericMethods();

    public void fillLoginForm(String username, String password){
        // Fill email field
        genericMethods.sendKeys(emailField, username);

        // Fill password field
        genericMethods.sendKeys(passwordField, password);

        // Click on login button
        genericMethods.click(loginButton);
    }

    public void loginSuccessValidation(String username){
        // Validate user's email presence after click on login button
        genericMethods.validateVisibilityOfElement(getValidationDinamicMap(username));
    }

    public void wrongCredentialsValidation(){
        genericMethods.validateVisibilityOfElement(incorrectCredentials);
    }

    // ####################### REUSABLES #######################
    private WebElement getValidationDinamicMap(String username){
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath("//div[@class='header-links']//a[@class='account' and text() = '"+username+"']")));
        return driver.findElement(xpath("//div[@class='header-links']//a[@class='account' and text() = '"+username+"']"));
    }
}
