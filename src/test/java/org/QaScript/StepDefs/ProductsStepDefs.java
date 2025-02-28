package org.QaScript.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.QaScript.PageObjects.HomePage;
import org.QaScript.PageObjects.ProductsPage;
import org.QaScript.PageObjects.shoppingCartPage;

/**
 * Step Definitions class for handling product-related Cucumber steps.
 * Includes interactions with product pages and the shopping cart.
 */
public class ProductsStepDefs {

    /**
     * Step to click the "Show all laptops and notebooks" link on the HomePage.
     */
    @Given("User able to click show all laptops and notebooks link")
    public void userAbleToClickShowAllLaptopsAndNotebooksLink() {
        HomePage.clickAllLaptopAndNotebooks(); // Click the link on the HomePage to view all laptops and notebooks
    }

    /**
     * Step to click the "Add to Cart" button for the MacBook product.
     * Validates the product and its price before adding it to the cart.
     */
    @When("User click on the add to cart button for the macbook product")
    public void userClickOnTheAddToCartButtonForTheMacbookProduct() {
        ProductsPage.validateProduct("MacBook"); // Validate if the product is MacBook
        ProductsPage.validatePrice("$500.00"); // Validate the product's price
        ProductsPage.clickAddToCartButton(); // Click the "Add to Cart" button for the MacBook
    }

    /**
     * Step to validate that the MacBook product is added to the shopping cart.
     * Checks product name, quantity, price, and total price.
     */
    @Then("Macbook product is added to the shopping cart")
    public void macbookProductIsAddedToTheShoppingCart() {
        shoppingCartPage.validateProductName("MacBook"); // Validate the product name in the shopping cart
        shoppingCartPage.validateProductQuantity("2"); // Validate the quantity of the product in the cart
        shoppingCartPage.validateProductPrice("$500.00"); // Validate the product price in the cart
        shoppingCartPage.validateProductTotalPrice("500","2"); // Validate the total price based on quantity
    }

    /**
     * Step to click on the MacBook product to view its details.
     */
    @And("User click on Macbook product")
    public void userClickOnMacbookProduct() {
        ProductsPage.clickProduct(); // Click on the MacBook product to view its details
    }

    /**
     * Step to enter the desired quantity for the product (MacBook).
     */
    @And("User enters the Quantity")
    public void userEntersTheQuantity() {
        ProductsPage.enterQuantity("2"); // Enter the quantity (2) for the product
    }

    /**
     * Step to click the shopping cart link on the HomePage.
     */
    @And("User Click the Shopping Cart")
    public void userClickTheShoppingCart() {
        HomePage.clickShoppingCart(); // Click the shopping cart link to view the cart
    }
}
