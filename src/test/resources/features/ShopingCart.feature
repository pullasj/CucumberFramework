
Feature: User Login
  Background:
    Given User enters valid username in the username field
    And User enters valid password in the password field
    When User clicks on the Login button
    Then User is logged in successfully

    @smoke
    Scenario: User is able to add products into the shopping cart
      Given User able to click show all laptops and notebooks link
      And User click on Macbook product
      And User enters the Quantity
      When User click on the add to cart button for the macbook product
      And User Click the Shopping Cart
      Then Macbook product is added to the shopping cart

