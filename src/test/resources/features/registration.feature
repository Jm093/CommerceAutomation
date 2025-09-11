Feature: Registration

  Scenario: Register User
  Given the user is in the registration page
  When the user fills up the registration form
  And clicks on the register button
  Then user should be successfully registered