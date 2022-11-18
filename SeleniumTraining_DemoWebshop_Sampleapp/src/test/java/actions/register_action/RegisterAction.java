package actions.register_action;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.register_page.RegisterPage;

import java.util.List;

import static org.openqa.selenium.By.xpath;
import static project_global_variables.GlobalVariables.WRONG_EMAIL_TEXT;

public class RegisterAction extends RegisterPage {
    private WebElement genderElement;
    private List<WebElement> requiredErrorList;
    private String[] adjustedErrorList,

            allErrorsList = {"FirstName", "LastName", "Email", "Password", "ConfirmPassword"},
            allErrorsValues = {"First name is required.", "Last name is required.", "Email is required.", "Password is required."
                    , "Password is required."};

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
        for(int i = 0; i < allErrorsList.length; i++){
            Assert.assertEquals(allErrorsValues[i],
                    driver.findElement(xpath("//span[@for = '"+allErrorsList[i]+"']")).getText());
        }
    }

    public void fillSpecificField(String fieldName, String fieldValue){
        switch (fieldName){
            case "FirstName":
                fillFirstName(fieldValue);
                break;
            case "LastName":
                fillLastName(fieldValue);
                break;
            case "Email":
                fillEmail(fieldValue);
                break;
            case "Password":
                fillPassword(fieldName);
                break;
            case "ConfirmPassword":
                fillConfirmPassword(fieldName);
                break;
        }
    }

    public void validateWrongEmailMessage(){
        genericMethods.validateVisibilityOfElement(emailError);
        Assert.assertEquals(WRONG_EMAIL_TEXT, emailError.getText());
    }

    public void fillOneFieldAndVerifyErrors(String errorToRemove){
        for(int i = 0; i < allErrorsList.length; i++ ){
            if(!allErrorsList[i].contains(errorToRemove)){
                Assert.assertEquals(allErrorsValues[i],
                        driver.findElement(xpath("//span[@for = '"+allErrorsList[i]+"']")).getText());
            }
        }
    }

    // REUSABLE
    private WebElement dynamicMapForGender(String gender){
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath("//div[@class = 'gender']//*[@for = 'gender-"+gender+"']")));
        return driver.findElement(xpath("//div[@class = 'gender']//*[@for = 'gender-"+gender+"']"));
    }


}
