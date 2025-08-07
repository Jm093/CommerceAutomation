Feature: Login

  Background:
    Given user is in the registration page
    And user is registered

    Scenario: Login
      Given the user is on the login page
      When the user logs in with valid credentials
      Then the user should be redirected to home page