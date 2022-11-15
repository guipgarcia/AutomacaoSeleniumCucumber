package step_definition.register;

import actions.home_action.HomeAction;
import actions.register_action.RegisterAction;
import base.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register extends BasePage {
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
}
