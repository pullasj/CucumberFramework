package org.QaScript.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.QaScript.PageObjects.HomePage;
import org.QaScript.PageObjects.ProductsPage;
import org.QaScript.PageObjects.shoppingCartPage;

public class ProductsStepDefs {
    @Given("User able to click show all laptops and notebooks link")
    public void userAbleToClickShowAllLaptopsAndNotebooksLink() {
        HomePage.clickAllLaptopAndNotebooks();
    }

    @When("User click on the add to cart button for the macbook product")
    public void userClickOnTheAddToCartButtonForTheMacbookProduct() {
        ProductsPage.validateProduct("MacBook");
        ProductsPage.validatePrice("$500.00");
        ProductsPage.clickAddToCartButton();
    }

    @Then("Macbook product is added to the shopping cart")
    public void macbookProductIsAddedToTheShoppingCart() {
        shoppingCartPage.validateProductName("MacBook");
        shoppingCartPage.validateProductQuantity("2");
        shoppingCartPage.validateProductPrice("$500.00");
        shoppingCartPage.validateProductTotalPrice("500","2");
    }

    @And("User click on Macbook product")
    public void userClickOnMacbookProduct() {
        ProductsPage.clickProduct();
    }

    @And("User enters the Quantity")
    public void userEntersTheQuantity() {
        ProductsPage.enterQuantity("2");
    }

    @And("User Click the Shopping Cart")
    public void userClickTheShoppingCart() {
        HomePage.clickShoppingCart();

    }
}
