#language: en

  Feature: Login on Demo Webshop Application

    Background:
      Given that I access demo webshop application
      And I click on login button

    @ExecuteTest @LoginScenario @PositiveAuth
    Scenario Outline: login on application using default credentials
      When input my "<username>" and "<password>"
      Then I can see the post login screen

      Examples:
      |   username    |password|
      |gt12@email.com |teste123|

    Scenario: login with default credentials and click and remember me checkbox


    @ExecuteTest @LoginScenario @NegativeAuth @WrongCredentials
    Scenario Outline: incorrect credentials on login form
      When input my "<username>" and "<password>"
      Then incorrect credentials error message appears on screen

      Examples:
        |   username    |password|
        |gt12@email.com |teste133|

    @ExecuteTest @LoginScenario @LoginWithoutEmail @NegativeAuth
    Scenario Outline: Do not fill email on login form
      When input my password "<password>"
      And press login button
      Then no customer account found error appears on screen

      Examples:
      |password|
      | teste123|

    @ExecuteTest @LoginScenario @LoginWithoutPassword @NegativeAuth
    Scenario Outline: Do not fill password on login form
      When input my email "<email>"
      And press login button
      Then incorrect credentials error message appears on screen

      Examples:
        |email|
        | gt13@email.com|