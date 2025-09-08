Feature: Logout

  Background:
    Given the user is registered
    And the user is able to log in

  Scenario: Successful logout
    When the user clicks logout
    Then the user should be redirected to home page
    And the user should no longer have access to their account info

  Scenario: Back button behavior after logout
    When the user clicks logout
    And the user clicks the back button
    Then the system should not show logged-in pages