Feature: Login

  Background:
    Given the user is registered

    Scenario: Valid Login
      Given the user is on the login page
      When the user logs in with valid credentials
      Then the user should be redirected to home page

  Scenario Outline: Invalid Login
    Given the user is on the login page
    When the user logs in with invalid "<email>" & "<password>" credentials
    Then the email error "<expectedEmailError>" should be shown
    Then the user should encounter an "<expectedOverallError>" message and not proceed to home page

    Examples:
      | email           | password    | expectedEmailError                  | expectedOverallError                                              |
      | 1213@gmail.com  | Pass2025!   |                                     | Login was unsuccessful. Please correct the errors and try again.  |
      | $%^{}@gmail.com | Pass2025!   |                                     | Login was unsuccessful. Please correct the errors and try again.  |
      |                 | Pass2025!   | Please enter your email             |                                                                   |
      | valid@gmail.com |             |                                     | Login was unsuccessful. Please correct the errors and try again.  |
      | a               | Pass2025!   | Please enter a valid email address. |                                                                   |
      | a@gsx           | Pass2025!   | Wrong email                         |                                                                   |

  Scenario: Forgot Password with valid email
    Given the user is on the forgot password page
    When the user enters a valid email
    And submits the request
    Then the user should see a success notification

  Scenario: Forgot Password with invalid email
    Given the user is on the forgot password page
    When the user enters an invalid email
    And submits the request
    Then the user should see an error notification