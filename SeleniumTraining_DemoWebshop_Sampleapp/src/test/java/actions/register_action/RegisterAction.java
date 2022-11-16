package actions.register_action;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.register_page.RegisterPage;

import java.util.List;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;

public class RegisterAction extends RegisterPage {
    private WebElement genderElement;
    private List<WebElement> requiredErrorList;
    private List<String> expectedErrors;

    public void registerPageVisibility(){
        genericMethods.validateVisibilityOfElement(registerForm);
    }

    public void selectGenderRadioBox(String gender){
        gender = gender.toLowerCase();
        genderElement = dynamicMapForGender(gender);
        genderElement.click();
    }

    public void fillFirstName(String firstName){
        genericMethods.validateVisibilityOfElement(firstNameField);
        genericMethods.click(firstNameField);
        genericMethods.sendKeys(firstNameField, firstName);
    }

    public void fillLastName(String lastName){
        genericMethods.validateVisibilityOfElement(lastNameField);
        genericMethods.click(lastNameField);
        genericMethods.sendKeys(lastNameField, lastName);
    }

    public void fillEmail(String email){
        genericMethods.validateVisibilityOfElement(emailField);
        genericMethods.click(emailField);
        genericMethods.sendKeys(emailField, email);
    }

    public void fillPassword(String password){
        genericMethods.validateVisibilityOfElement(passwordField);
        genericMethods.click(passwordField);
        genericMethods.sendKeys(passwordField, password);
    }

    public void fillConfirmPassword(String confirmPassword){
        genericMethods.validateVisibilityOfElement(confirmPasswordField);
        genericMethods.click(confirmPasswordField);
        genericMethods.sendKeys(confirmPasswordField, confirmPassword);
    }

    public void clickRegisterButton(){
        genericMethods.validateVisibilityOfElement(registerButton);
        genericMethods.click(registerButton);
    }

    public void registerCompletedWithSuccess(){
        genericMethods.validateVisibilityOfElement(registrationStatus);
        genericMethods.assertContains(registrationStatus, "Your registration completed");
    }

    public void allRequiredFieldsNotFilledError(){
        String[] allErrorsList = {"FirstName", "LastName", "Email", "Password", "ConfirmPassword"},
        allErrorsValues = {"First name is required.", "Last name is required.", "Email is required.", "Password is required."
                , "Password is required."};
        for(int i = 0; i < allErrorsList.length; i++){
            Assert.assertEquals(allErrorsValues[i],
                    driver.findElement(xpath("//span[@for = '"+allErrorsList[i]+"']")).getText());
        }
    }

    // REUSABLE
    private WebElement dynamicMapForGender(String gender){
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath("//div[@class = 'gender']//*[@for = 'gender-"+gender+"']")));
        return driver.findElement(xpath("//div[@class = 'gender']//*[@for = 'gender-"+gender+"']"));
    }


}
