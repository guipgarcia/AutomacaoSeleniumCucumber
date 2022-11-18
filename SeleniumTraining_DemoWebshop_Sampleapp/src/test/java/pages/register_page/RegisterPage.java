package pages.register_page;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
    @FindBy(className = "page registration-page")
    protected WebElement registerForm;

    @FindBy(id = "FirstName")
    protected WebElement firstNameField;

    @FindBy(id = "LastName")
    protected WebElement lastNameField;

    @FindBy(id = "Email")
    protected WebElement emailField;

    @FindBy(id = "Password")
    protected WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    protected WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    protected WebElement registerButton;

    @FindBy(className = "result")
    protected WebElement registrationStatus;

    @FindBy(xpath = "//*[@class = 'field-validation-error']//span[@for = 'Email']")
    protected WebElement emailError;

}
