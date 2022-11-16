#language: en

Feature: Register on Demo Webshop Application

  Background:
    Given that I access demo webshop application
    When I click in register link in home page

    @ExecuteTest @RegisterScenario @RegisterPage
    Scenario: Access register page through home page link
      Then I can see the register page opened

    @ExecuteTest @RegisterScenario @PositiveRegister
    Scenario Outline: Complete user register with pre defined information
      And I fill "<first_name>" in firstname field
      And I fill "<last_name>" in lastname field
      And I fill "<email>" in email field
      And I fill "<password>" in password field
      And I fill "<confirm_password>" in confirm password field
      And I click in register button
      Then I can see that my registration was completed with success

      Examples:
      |first_name |last_name|email                |password|confirm_password|
      |ablublu    |test     |testablu@blumail.comd|123@abc |123@abc|


  @ExecuteTest @RegisterScenario @PositiveRegister @GenderSelection
  Scenario Outline: Complete user register selecting a gender
    And I select a gender "<gender>" for the user
    And I fill "<first_name>" in firstname field
    And I fill "<last_name>" in lastname field
    And I fill "<email>" in email field
    And I fill "<password>" in password field
    And I fill "<confirm_password>" in confirm password field
    And I click in register button
    Then I can see that my registration was completed with success

    Examples:
      |gender    |first_name  |last_name|email                 |password|confirm_password|
      |  male    |ablublu1    |test     |testablu1@blumail.comd|123@abc |123@abc         |

  @ExecuteTest @RegisterScenario @NegativeRegister @RequiredFieldsValidation
    Scenario: Click register button without fill any field
      When I click in register button
      Then all the required fields shows the errors
