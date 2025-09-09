Feature: Search

  Background:
    Given the user is registered
    And the user is able to log in

    Scenario: Search an existing item
      When the user searches for an item
      Then the correct item should be displayed

    Scenario: Search a non-existing item
      When the user searches for a non existing item
      Then there should be no items in display and a message indicating no items found should be displayed

