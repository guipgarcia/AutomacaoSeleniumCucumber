package step_definition.home;

import actions.home_action.HomeAction;
import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static project_global_variables.GlobalVariables.DEMO_WEBSHOP_APPLICATION;

public class HomeSteps extends BasePage {

    private HomeAction homeAction = new HomeAction();

    @Given("that I access demo webshop application")
    public void that_i_access_demo_webshop_application() {
        // Passar demo webshop application
        genericMethods.openUrl(DEMO_WEBSHOP_APPLICATION);
    }

    @When("I click on login button")
    public void iClickOnLoginButton() {
        homeAction.clickOnLoginLink();
    }

    @When("I click in computers on top menu")
    public void i_click_in_computers_on_top_menu() {
        homeAction.selectComputerOptionOnTopMenu();
    }

    @And("I click in logout link")
    public void iClickInLogoutLink() {
        homeAction.clickLogoutLink();
    }

    @And("I am able to see the home page")
    public void iAmAbleToSeeTheHomePage() {
        homeAction.validateHomePage();
    }

    @And("I select {string} menu in menu bar")
    public void iSelectMenuInMenuBar(String menu) {
        homeAction.selectTopMenu(menu);
    }


    @And("I click in wishlist link in top bar")
    public void iClickInWishlistLinkInTopBar() {
        homeAction.clickInWishListLink();
    }

    @When("I add a random product to cart from featured products tab")
    public void iAddARandomProductToCartFromFeaturedProductsTab() {
        homeAction.addRandomProductToCartFromFeaturedProductsTab();
    }

    @And("I click in shopping cart menu")
    public void iClickInShoppingCartMenu() {
        homeAction.accessShoppingCart();
    }

    @And("I navigate to home page")
    public void iNavigateToHomePage() {
        homeAction.clickInHomePageImg();
    }
}
