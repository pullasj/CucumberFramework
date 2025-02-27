package org.QaScript.PageObjects;

import org.QaScript.Utils.browserUtils;

import java.security.PrivateKey;

public class ProductsPage {
    private static String linkMacbook = "//a[text()='MacBook']";
    private static String linkProduct = "//h4/a[contains(@href,product_id)]";
    private static String btnAddToCart = "//button[@id='button-cart']";
    private static String txtPriceHeading = "(//div[@id='product']//ancestor::div)[5]//ul//li//h2";
    private static String txtProductHeading = "(//div[@id='product']//ancestor::div)[5]//h1";
    private static String txtBoxQuantity = "//input[@id='input-quantity']";

    public static void clickProduct(){
        browserUtils.clickElement(linkMacbook);
    }

    public static void validatePrice(String expectedPrice){
        browserUtils.validateText(txtPriceHeading,expectedPrice);
    }
    public static void validateProduct(String expectedProduct){
        browserUtils.validateText(txtProductHeading,expectedProduct);
    }

    public static void clickAddToCartButton(){
        browserUtils.clickElement(btnAddToCart);
    }

    public static void enterQuantity(String quantity) {
        browserUtils.enterText(txtBoxQuantity,quantity);
    }

    public static void clickProducts(){
        int index = 1;
        String xpath = "("+linkProduct+")" +"["+index+"]";
        browserUtils.clickElement(xpath);
    }
}
