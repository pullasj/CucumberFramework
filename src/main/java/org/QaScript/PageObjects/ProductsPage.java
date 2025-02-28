package org.QaScript.PageObjects;

import org.QaScript.Utils.browserUtils;

public class ProductsPage {

    // Locator for the "MacBook" product link
    private static String linkMacbook = "//a[text()='MacBook']";

    // Locator for product links, used with a dynamic product ID
    private static String linkProduct = "//h4/a[contains(@href,product_id)]";

    // Locator for the "Add to Cart" button
    private static String btnAddToCart = "//button[@id='button-cart']";

    // Locator for the price heading of a product
    private static String txtPriceHeading = "(//div[@id='product']//ancestor::div)[5]//ul//li//h2";

    // Locator for the product heading (name) of a product
    private static String txtProductHeading = "(//div[@id='product']//ancestor::div)[5]//h1";

    // Locator for the quantity input box for the product
    private static String txtBoxQuantity = "//input[@id='input-quantity']";

    /**
     * Clicks the "MacBook" product link on the page.
     */
    public static void clickProduct() {
        browserUtils.clickElement(linkMacbook); // Click the MacBook product link
    }

    /**
     * Validates the price of the product by comparing the actual price with the expected price.
     * @param expectedPrice The expected price of the product
     */
    public static void validatePrice(String expectedPrice) {
        browserUtils.validateText(txtPriceHeading, expectedPrice); // Validate the displayed price
    }

    /**
     * Validates the name of the product by comparing the actual product name with the expected name.
     * @param expectedProduct The expected name of the product
     */
    public static void validateProduct(String expectedProduct) {
        browserUtils.validateText(txtProductHeading, expectedProduct); // Validate the displayed product name
    }

    /**
     * Clicks the "Add to Cart" button for the product.
     */
    public static void clickAddToCartButton() {
        browserUtils.clickElement(btnAddToCart); // Click the add to cart button
    }

    /**
     * Enters the quantity of the product to be added to the cart.
     * @param quantity The quantity of the product to be entered
     */
    public static void enterQuantity(String quantity) {
        browserUtils.enterText(txtBoxQuantity, quantity); // Enter the quantity in the input field
    }

    /**
     * Clicks on a specific product in the product list based on the index.
     * (Currently uses a hardcoded index value of 1)
     */
    public static void clickProducts() {
        int index = 1; // Index for the product to be clicked
        String xpath = "(" + linkProduct + ")" + "[" + index + "]"; // Construct the XPath using the index
        browserUtils.clickElement(xpath); // Click the specific product based on the index
    }
}
