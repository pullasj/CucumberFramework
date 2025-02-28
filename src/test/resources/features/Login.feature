# Feature file for Login functionality
Feature: User Login
  # This feature verifies the login functionality with different scenarios.

  @smoke @regression
  # Scenario for successful login
  Scenario: Successful login with valid credentials
    # Given the user provides valid credentials, they should be able to log in successfully.
    Given User enters valid username in the username field
    And User enters valid password in the password field
    When User clicks on the Login button
    Then User is logged in successfully

  @smoke
  # Scenario for unsuccessful login due to invalid credentials
  Scenario Outline: Unsuccessful login with invalid credentials
    # When an invalid username and password are entered, an error message should be displayed.
    Given User enters invalid <username> in the username field
    And User enters invalid <password> in the password field
    When User clicks on the Login button
    Then error message will display

    # Test cases with different sets of invalid credentials
    Examples:
      | username            | password |
      | weqrdokl            | dsffds   |
      | weqrdokl@fmaaaa.dosa| dsffds   |

  @excel
  # Scenario for login using Excel credentials
  Scenario: Successful login with Excel credentials
    # The user logs in using credentials retrieved from an Excel sheet.
    Given User enters Excel username in the username field
    And User enters valid password in the password field
    When User clicks on the Login button
    Then User is logged in successfully
