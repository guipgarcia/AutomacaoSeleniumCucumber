package step_definition.login;

import actions.home_action.HomeAction;
import actions.login_action.LoginAction;
import base.BasePage;
import generic_methods.GenericMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static project_global_variables.GlobalVariables.DEMO_WEBSHOP_APPLICATION;

public class LoginSteps extends BasePage {
    private String user = "";
    private final HomeAction homeAction = new HomeAction();
    private final LoginAction loginAction = new LoginAction();


    @And("I input the default credentials")
    public void inputDefaultCredentials(){
        String username = "gt12@email.com";
        String password = "teste123";
        loginAction.fillLoginForm(username, password);
        user = username;
    }

    @And("input my {string} and {string}")
    public void inputMyAnd(String username, String password) {
        loginAction.fillLoginForm(username, password);
        user = username;
    }

    @Then("I can see the post login screen")
    public void iCanSeeThePostLoginScreen() {
        loginAction.loginSuccessValidation(user);
        homeAction.sucessLoginValidation();
    }



    @And("press login button")
    public void pressLoginButton() {
        loginAction.clickLoginButton();
    }


    @Then("incorrect credentials error message appears on screen")
    public void incorrectCredentialsErrorMessageAppearsOnScreen() {
        loginAction.wrongCredentialsValidation();
    }

    @Then("no customer account found error appears on screen")
    public void noCustomerAccountFoundErrorAppearsOnScreen() {
        loginAction.loginWithoutEmail();
    }

    @When("input my password {string}")
    public void inputMyPassword(String password) {
        loginAction.fillPasswordInLoginForm(password);
    }

    @When("input my email {string}")
    public void inputMyEmail(String email) {
        loginAction.fillEmailInLoginForm(email);
        user = email;
    }

    @And("check remember me checkbox")
    public void checkRememberMeCheckbox() {
        loginAction.checkRememberMeCheckbox();
    }

    @Then("I can see the remember me checkbox checked and my credentials filled out {string} and {string}")
    public void iCanSeeTheRememberMeCheckboxCheckedAndMyCredentialsFilledOutAnd(String email, String password) {
        loginAction.validateFieldsAfterRememberMeChecked(email, password);
    }
}
