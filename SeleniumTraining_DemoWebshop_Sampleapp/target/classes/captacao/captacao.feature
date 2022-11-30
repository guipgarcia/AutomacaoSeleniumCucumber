#language: en

Feature: Buy on Demo Webshop Application

  Background:
    Given that I access demo webshop application
    And I click on login button
    And I input the default credentials
    And I can see the post login screen

    Scenario: Buy a desktop
      When I click in computers on top menu
      And I select the desktop option
