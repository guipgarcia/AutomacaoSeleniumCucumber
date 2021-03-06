package step_definition.demo_webshop.login;

import actions.demo_webshop.home_action.HomeAction;
import actions.demo_webshop.login_action.LoginAction;
import base.BasePage;
import generic_methods.GenericMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static project_global_variables.GlobalVariables.DEMO_WEBSHOP_APPLICATION;

public class LoginSteps extends BasePage {
    private String user = "";
    public GenericMethods genericMethods = new GenericMethods();
    private HomeAction homeAction = new HomeAction();
    private LoginAction loginAction = new LoginAction();

    @Given("that I access demo webshop application")
    public void that_i_access_demo_webshop_application() {
        // Passar demo webshop application
        genericMethods.openUrl(DEMO_WEBSHOP_APPLICATION);
    }

    @When("I click on login button")
    public void iClickOnLoginButton() {
        homeAction.clickOnLoginLink();
    }

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

    @Then("incorrect credentials error message appears on screen")
    public void incorrectCredentialsErrorMessageAppearsOnScreen() {
        loginAction.wrongCredentialsValidation();
    }
}
