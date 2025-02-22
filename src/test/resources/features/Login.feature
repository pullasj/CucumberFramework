# Feature file for Login functionality
Feature: User Login

  # Scenario for successful login
  Scenario: 1 Successful login with valid credentials
    Given User enters valid username in the username field
    And User enters valid password in the password field
    When User clicks on the Login button
    Then User is logged in successfully

  # Scenario for unsuccessful login due to invalid credentials
  Scenario: 2 Unsuccessful login with invalid credentials
    Given User enters invalid username in the username field
    And User enters invalid password in the password field
    When User clicks on the Login button
    Then error message will display
