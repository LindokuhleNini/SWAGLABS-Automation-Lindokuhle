Feature: Order

  Scenario: User adds 4 items to cart and completes order
    Given the user is on the login page
    When the user logs in with valid credentials
    And the user adds 4 items to the cart
    Then the user should see 4 items in the cart
    When the user proceeds to checkout
    And the user enters their details
    Then the order total should be correct
    And the user completes the order
