#language: en

Feature: Register on Demo Webshop Application

  Background:
    Given that I access demo webshop application

    Scenario: Access register page through home page link
      When I click in register link in home page
      Then I can see the register page opened


