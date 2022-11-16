package step_definition.register;

import actions.home_action.HomeAction;
import actions.register_action.RegisterAction;
import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps extends BasePage {
    private HomeAction homeAction = new HomeAction();
    private RegisterAction registerAction = new RegisterAction();
    @When("I click in register link in home page")
    public void i_click_in_register_link_in_home_page() {
        homeAction.clickInRegisterLink();
    }

    @Then("I can see the register page opened")
    public void i_can_see_the_register_page_opened() {
        registerAction.registerPageVisibility();
    }

    @And("I fill {string} in firstname field")
    public void iFillInFirstnameField(String firstName) {
        registerAction.fillFirstName(firstName);
    }

    @And("I fill {string} in lastname field")
    public void iFillInLastnameField(String lastName) {
        registerAction.fillLastName(lastName);
    }

    @And("I fill {string} in email field")
    public void iFillInEmailField(String email) {
        registerAction.fillEmail(email);
    }

    @And("I fill {string} in password field")
    public void iFillInPasswordField(String password) {
        registerAction.fillPassword(password);
    }

    @And("I fill {string} in confirm password field")
    public void iFillInConfirmPasswordField(String confirmPassword) {
        registerAction.fillConfirmPassword(confirmPassword);
    }

    @And("I click in register button")
    public void iClickInRegisterButton() {
        registerAction.clickRegisterButton();
    }

    @Then("I can see that my registration was completed with success")
    public void iCanSeeThatMyRegistrationWasCompletedWithSuccess() {
        registerAction.registerCompletedWithSuccess();
    }

    @And("I select a gender {string} for the user")
    public void iSelectAGenderForTheUser(String gender) {
        registerAction.selectGenderRadioBox(gender);
    }

    @Then("all the required fields shows the errors")
    public void allTheRequiredFieldsShowsTheErrors() {
        registerAction.allRequiredFieldsNotFilledError();
    }
}
