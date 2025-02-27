package org.QaScript.StepDefs;

import io.cucumber.java.en.And;
import org.QaScript.Utils.browserUtils;


public class ShopingCartStepDefs {

    private String CartRemoveBtn = "(//button[contains(@class,'btn-danger')])[2]";

    @And("Removed from the cart")
    public void removedFromTheCart() {
        browserUtils.clickElement(CartRemoveBtn);
    }
}
