Feature: Login Functionality
  As a user
  I want to be able to log in to the system
  So that I can access my account

  Scenario: Login with wrong username
    Given I am on the login page
    When I enter wrong username "user" and correct password "secret_sauce"
    And click the login button
    Then I should see an error message

  Scenario: Login with empty username
    When I enter a correct password "secret_sauce" and an empty username ""
    And click the login button
    Then I should see an error message

  Scenario: Login with wrong password
    When I enter a correct username "standard_user" and a wrong password "secret_sos"
    And click the login button
    Then I should see an error message

  Scenario: Login with empty password
    When I enter a correct username "standard_user" and an empty password ""
    And click the login button
    Then I should see an error message

  Scenario: Login with wrong username and password
    When I enter a wrong username "standard_us" and a wrong password "secret"
    And click the login button
    Then I should see an error message

  Scenario: Successful Login
    When I enter a correct username "standard_user" and a correct password "secret_sauce"
    And click the login button
    Then I should be logged in to my account