package org.QaScript.PageObjects;

import org.QaScript.Utils.browserUtils;

public class shoppingCartPage {

    // Locator for the "Checkout" button
    private static String btnCheckout = "//a[text()='Checkout']";

    // Locator for the "Continue Shopping" button
    private static String btnContinueShopping = "//a[text()='Continue Shopping']";

    // Locator for the product name link in the cart
    private static String linkProduct = "(//div[@id='content']//table)[1]//tbody//tr[1]//td[2]//a";

    // Locator for the quantity input box in the cart
    private static String txtBoxQuantity = "(//div[@id='content']//table)[1]//tbody//tr[1]//td[4]//input";

    // Locator for the product price in the cart
    private static String txtPrice = "(//div[@id='content']//table)[1]//tbody//tr[1]//td[5]";

    // Locator for the total price of the product in the cart
    private static String txtTotalPrice = "(//div[@id='content']//table)[1]//tbody//tr[1]//td[6]";

    /**
     * Clicks the "Checkout" button to proceed with the checkout process.
     */
    public static void clickCheckout(){
        browserUtils.clickElement(btnCheckout); // Click the checkout button
    }

    /**
     * Clicks the "Continue Shopping" button to return to the shopping page.
     */
    public static void clickContinueShopping(){
        browserUtils.clickElement(btnContinueShopping); // Click the continue shopping button
    }

    /**
     * Validates the product name in the cart against the expected product name.
     * @param expectedProductName The expected name of the product
     */
    public static void validateProductName(String expectedProductName){
        browserUtils.validateText(linkProduct, expectedProductName); // Validate product name
    }

    /**
     * Validates the quantity of the product in the cart against the expected quantity.
     * @param expectedProductQuantity The expected quantity of the product
     */
    public static void validateProductQuantity(String expectedProductQuantity){
        browserUtils.validateValue(txtBoxQuantity, expectedProductQuantity, "value"); // Validate the product quantity
    }

    /**
     * Validates the price of the product in the cart against the expected price.
     * @param expectedProductPrice The expected price of the product
     */
    public static void validateProductPrice(String expectedProductPrice){
        browserUtils.validateText(txtPrice, expectedProductPrice); // Validate the product price
    }

    /**
     * Validates the total price of the product in the cart by calculating it using the price and quantity.
     * @param expectedProductPrice The expected price of the product
     * @param expectedProductQuantity The expected quantity of the product
     */
    public static void validateProductTotalPrice(String expectedProductPrice, String expectedProductQuantity){
        // Calculate the expected total price
        Integer expectedProductTotalPrice = Integer.parseInt(expectedProductPrice) * Integer.parseInt(expectedProductQuantity);
        int number = expectedProductTotalPrice;
        int mod;
        StringBuilder comm = new StringBuilder();

        // Format the total price with commas
        while (number > 0) {
            mod = number % 1000;
            number = number / 1000;
            if (number > 0) {
                comm.insert(0, String.format(",%03d", mod)); // Insert commas for thousand separators
            } else {
                comm.insert(0, mod);
            }
        }

        // Expected formatted price
        String Expected = "$" + comm.toString() + ".00";
        browserUtils.validateText(txtTotalPrice, Expected); // Validate the total price
    }
}
