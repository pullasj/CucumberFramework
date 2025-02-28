# Feature file for User Login and Shopping Cart functionality
Feature: User Login

  # Background ensures every scenario starts with a successful login.
  Background:
    # Precondition: User logs in successfully before executing any scenario.
    Given User enters valid username in the username field
    And User enters valid password in the password field
    When User clicks on the Login button
    Then User is logged in successfully

  @smoke
  # Scenario for adding a product to the shopping cart and removing it
  Scenario: User is able to add products into the shopping cart
    # User navigates to the laptop and notebook section.
    Given User able to click show all laptops and notebooks link
    # User selects the MacBook product.
    And User click on Macbook product
    # User specifies the desired quantity.
    And User enters the Quantity
    # User adds the MacBook to the shopping cart.
    When User click on the add to cart button for the macbook product
    # User navigates to the shopping cart.
    And User Click the Shopping Cart
    # The MacBook should be added successfully.
    Then Macbook product is added to the shopping cart
    # User removes the MacBook from the cart.
    And Removed from the cart
