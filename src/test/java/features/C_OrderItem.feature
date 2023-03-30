Feature: Order Processing

  Scenario: User adds items to cart, proceeds to checkout and completes order
    Given the user is on the login page
    When the user logs in with valid credentials
    Then the user should be redirected to the home page

    Given the user is on the home page
    When the user adds 4 items to the cart
    Then the cart should display all 4 items

    Given the user is on the cart page
    When the user proceeds to checkout
    Then the user should be redirected to the checkout page

    Given the user is on the checkout page
    When the user enters their details and confirms the order
    Then the order should be processed successfully

    Given the user is on the order confirmation page
    When the user checks the Total amount
    Then the Total amount should be equal to the sum of the Tax and Item total
