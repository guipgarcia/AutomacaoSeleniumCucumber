package actions.login_action;

import generic_methods.GenericMethods;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.login_page.LoginPage;

import static org.openqa.selenium.By.xpath;
import static project_global_variables.GlobalVariables.CREDENTIALS_ERROR_MESSAGE;
import static project_global_variables.GlobalVariables.NO_CUSTOMER_ACCOUNT_FOUND;

public class LoginAction extends LoginPage {

    public void fillLoginForm(String username, String password){
        // Fill email field
        genericMethods.sendKeys(emailField, username);

        // Fill password field
        genericMethods.sendKeys(passwordField, password);

        // Click on login button
        clickLoginButton();
    }

    public void fillPasswordInLoginForm(String password){
        //Fill password field
        genericMethods.sendKeys(passwordField, password);

    }

    public void fillEmailInLoginForm(String email){
        //Fill Login field
        genericMethods.sendKeys(emailField, email);
    }

    public void checkRememberMeCheckbox(){
        if(rememberMeInput.getAttribute("value").equals("false"))
            genericMethods.click(rememberMeField);
    }

    public void validateFieldsAfterRememberMeChecked(String email, String password){
        Assert.assertEquals("true", rememberMeInput.getAttribute("value"));
        Assert.assertEquals(email, emailField.getText());
        Assert.assertEquals(password, passwordField.getText());
    }
    public void clickLoginButton(){
        genericMethods.click(loginButton);
    }

    public void loginSuccessValidation(String username){
        // Validate user's email presence after click on login button
        genericMethods.validateVisibilityOfElement(getValidationDinamicMap(username));
    }

    public void wrongCredentialsValidation(){
        genericMethods.validateVisibilityOfElement(loginErrorMessageLabel);
        Assert.assertEquals(CREDENTIALS_ERROR_MESSAGE, loginErrorMessageLabel.getText());
    }

    public void loginWithoutEmail(){
        genericMethods.validateVisibilityOfElement(loginErrorMessageLabel);
        Assert.assertEquals(NO_CUSTOMER_ACCOUNT_FOUND, loginErrorMessageLabel.getText());
    }

    // ####################### REUSABLES #######################
    private WebElement getValidationDinamicMap(String username){
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath("//div[@class='header-links']//a[@class='account' and text() = '"+username+"']")));
        return driver.findElement(xpath("//div[@class='header-links']//a[@class='account' and text() = '"+username+"']"));
    }
}
