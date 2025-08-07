Feature: Checkout

  Background:
    Given the user is registered
    And the user is able to log in

  Scenario: Add product to cart
    When the user searches for cellphone
    And adds the item to cart
    Then the cart should show the added item

  Scenario: Checkout the items in cart
    Given that an item is added to the cart
    When the user has agreed to TOS and clicked the checkout button
    And the user has filled up the address details with:

      | FirstName | Levi                |
      | LastName  | Colin               |
      | Email     | levicolin@gmail.com |
      | Country   | Afghanistan         |
      | City      | Cubao               |
      | Address   | 721 3rd floor       |
      | ZipCode   | 1900                |
      | PhoneNo   | 09454880872         |

    And the user has selected the Shipping method
    And the user has selected the Payment method
    And the user has selected the Payment information
    And the user has confirmed the order
    Then the user should be redirected to order confirmed page
