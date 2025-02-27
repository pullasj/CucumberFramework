package org.QaScript.PageObjects;

import org.QaScript.Utils.browserUtils;

public class shoppingCartPage {
    private static String btnCheckout = "//a[text()='Checkout']";
    private static String btnContinueShopping = "//a[text()='Continue Shopping']";
    private static String linkProduct = "(//div[@id='content']//table)[1]//tbody//tr[1]//td[2]//a";
    private static String txtBoxQuantity = "(//div[@id='content']//table)[1]//tbody//tr[1]//td[4]//input";
    private static String txtPrice = "(//div[@id='content']//table)[1]//tbody//tr[1]//td[5]";
    private static String txtTotalPrice = "(//div[@id='content']//table)[1]//tbody//tr[1]//td[6]";

    public static void clickCheckout(){
        browserUtils.clickElement(btnCheckout);
    }

    public static void clickContinueShopping(){
        browserUtils.clickElement(btnContinueShopping);
    }

    public static void validateProductName(String expectedProductName){
        browserUtils.validateText(linkProduct,expectedProductName);
    }

    public static void validateProductQuantity(String expectedProductQuantity ){
        browserUtils.validateValue(txtBoxQuantity,expectedProductQuantity,"value");
    }

    public static void validateProductPrice(String expectedProductPrice){
        browserUtils.validateText(txtPrice,expectedProductPrice);
    }

    public static void validateProductTotalPrice(String expectedProductPrice, String expectedProductQuantity ){
        Integer expectedProductTotalPrice = Integer.parseInt(expectedProductPrice) * Integer.parseInt(expectedProductQuantity);
        browserUtils.validateText(txtTotalPrice,expectedProductTotalPrice.toString());
    }
}
