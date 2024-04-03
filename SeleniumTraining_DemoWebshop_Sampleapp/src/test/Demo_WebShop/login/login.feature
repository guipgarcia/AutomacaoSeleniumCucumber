#language: en

  Feature: Login on Demo Webshop Application

    Background:
      Given that I access demo webshop application
      And I click on login button

    @ExecuteTest @LoginScenario @PositiveAuth @LoginRightCredentials
    Scenario Outline: login on application using default credentials
      When input my "<username>" and "<password>"
      Then I can see the post login screen

      Examples:
      |   username    |password|
      |gt12@email.com |teste123|

    @RememberMe @Issue
    Scenario Outline: login with default credentials and click and remember me checkbox
      When input my email "<username>"
      And input my password "<password>"
      And check remember me checkbox
      And press login button
      And I click in logout link
      Then I click on login button
      And I can see the remember me checkbox checked and my credentials filled out "<username>" and "<password>"

      Examples:
        |   username    |password|
        |gt12@email.com |teste123|

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
        | gt12@email.com|

    @ExecuteTest @LoginScenario @LoginWithoutPassword @NonExistentEmail @NegativeAuth @Issue
    Scenario Outline: Fill email with nonexistent value and do not place a password
      When input my email "<email>"
      And press login button
      Then incorrect credentials error message appears on screen
      Examples:
        |email|
        | gt13@email.com|


    @ExecuteTest @LoginScenario @NonExistentEmail @NegativeAuth @Issue
    Scenario Outline: Fill email with nonexistent value and right password
      When input my email "<email>"
      And input my password "<password>"
      And press login button
      Then incorrect credentials error message appears on screen
      Examples:
        |email|password|
        | gt13@email.com|teste123|


