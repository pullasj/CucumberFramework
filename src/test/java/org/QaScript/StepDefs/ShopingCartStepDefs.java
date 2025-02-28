package org.QaScript.StepDefs;

import io.cucumber.java.en.And;
import org.QaScript.Utils.browserUtils;

/**
 * Step Definitions class for handling shopping cart-related Cucumber steps.
 * Includes interaction for removing an item from the shopping cart.
 */
public class ShopingCartStepDefs {

    // Locator for the "Remove" button in the shopping cart (second remove button)
    private String CartRemoveBtn = "(//button[contains(@class,'btn-danger')])[2]";

    /**
     * Step to remove an item from the shopping cart.
     * This clicks on the "Remove" button for the product in the cart.
     */
    @And("Removed from the cart")
    public void removedFromTheCart() {
        browserUtils.clickElement(CartRemoveBtn); // Click the "Remove" button for the product in the cart
    }
}
