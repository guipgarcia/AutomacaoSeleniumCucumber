package pages.login_page;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "Email")
    protected WebElement emailField;

    @FindBy(id = "Password")
    protected WebElement passwordField;

    @FindBy(id = "RememberMe")
    protected WebElement rememberMeField;

    @FindBy(xpath = "//a[text() = 'Forgot password?']")
    protected WebElement forgotPasswordLink;

    @FindBy(xpath = "//input[@value = 'Log in']")
    protected WebElement loginButton;

    @FindBy(xpath = "//div[@class='message-error']//li[text() = 'The credentials provided are incorrect']")
    protected WebElement incorrectCredentials;

}
