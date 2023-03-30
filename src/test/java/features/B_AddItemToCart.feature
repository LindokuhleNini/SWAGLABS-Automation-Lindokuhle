Feature: Add Items to Cart
  As a customer
  I want to add items to my cart
  So that I can purchase them later

  Scenario: Add n items to cart and log out
    Given the user is logged in
    When the user adds {n} items to the cart
    Then the cart should have {n} items
    When the user logs out
    Then the user should be redirected to the login page

  Scenario: Adding 3 items to the cart and removing 1 item
    Given the user is on the product page
    When the user adds 3 items to the cart
    Then the user should see all 3 items in the cart
    And the user navigates back to the All items page
    And the user removes 1 item from the cart
    Then the user should see only 2 items in the cart
    And the user logs out

  Scenario: Add n items to cart, verify all items are added, log out, log in, verify all items are still in cart
    Given the user is on the product page
    When the user adds n items to the cart again
    Then the cart should have "n" items
    And the user logs out again
    And the user logs back in
    Then the cart should still have "n" items
    And each item should still be displayed in the cart

