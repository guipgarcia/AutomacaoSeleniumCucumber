#language: en

  Feature: Login on Demo Webshop Application

    Background:
      Given that I access demo webshop application
      And I click on login button

    @ExecuteTest
    Scenario Outline: login on application using default credentials
      When input my "<username>" and "<password>"
      Then I can see the post login screen

      Examples:
      |   username    |password|
      |gt12@email.com |teste123|

    @ExecuteTest
    Scenario Outline: incorrect credentials on login form
      When input my "<username>" and "<password>"
      Then incorrect credentials error message appears on screen

      Examples:
        |   username    |password|
        |gt12@email.com |teste133|