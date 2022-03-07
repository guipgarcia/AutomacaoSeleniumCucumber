package step_definition.demo_webshop.home;

import actions.demo_webshop.home_action.HomeAction;
import base.BasePage;
import io.cucumber.java.en.When;

public class HomeSteps extends BasePage {

    private HomeAction homeAction = new HomeAction();

    @When("I click in computers on top menu")
    public void i_click_in_computers_on_top_menu() {
        homeAction.selectComputerOptionOnTopMenu();
    }
}
