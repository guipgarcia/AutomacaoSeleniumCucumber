#language: en

Feature: Register on Demo Webshop Application

  Background:
    Given that I access demo webshop application
    And I click in register link in home page

    @ExecuteTest @RegisterScenario @RegisterPage
    Scenario: Access register page through home page link
      Then I can see the register page opened

    @ExecuteTest @RegisterScenario @PositiveRegister
    Scenario Outline: Complete user register with pre defined information
      When I fill "<first_name>" in firstname field
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
      When I select a gender "<gender>" for the user
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

    @ExecuteTest @RegisterScenario @NegativeRegister @RequiredFieldsValidation @FillOnlyOneRequired
    Scenario Outline: Fill <field> field and verify the required errors
      When I fill a specific field "<field>" with value "<value>"
      And I click in register button
      Then Except for the filled field "<field>" the form must display the required errors

      Examples:
      |field             |value              |
      | FirstName        | TestName          |
      | LastName         | TestName          |
      | Email            | Testmail@mail.com |
      | Password         | TestPass          |
      | ConfirmPassword  | TestPass          |

    @ExecuteTest @RegisterScenario @NegativeRegister @RequiredFieldsValidation @WrongEmailValidation
      Scenario Outline: Fill email with wrong format
        When I fill "<email>" in email field
        And I click in register button
        Then I get wrong email message from register page
        Examples:
        |email                |
        |  abcde              |
        |     @               |
        |   test_test.com     |
        |   abcde@some.com1   |

    @ExecuteTest @RegisterScenario @NegativeRegister @RequiredFieldsValidation @WrongPasswordValidation
      Scenario Outline: Fill Password with 5 characters
        When I fill "<password>" in password field
        And I press tab button in password field
        Then I get password range error message
        Examples:
        |password|
        |  12345 |

    @ExecuteTest @RegisterScenario @NegativeRegister @RequiredFieldsValidation @WrongPasswordValidation
      Scenario Outline: Fill confirm password with a different value than password field
        When I fill "<password>" in password field
        And I fill "<confirmPassword>" in confirm password field
        And I click in register button
        Then I get password not matches error
        Examples:
        |password   | confirmPassword|
        | 123456    | 12345y         |
