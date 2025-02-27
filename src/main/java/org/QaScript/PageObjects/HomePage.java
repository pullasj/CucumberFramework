package org.QaScript.PageObjects;

import org.QaScript.BaseClass;
import org.QaScript.Utils.browserUtils;
import org.openqa.selenium.By;

public class HomePage extends BaseClass{
    private static String myAccountText = "(//div[@id='content']/h2)[1]";
    private static String linkShowAllLaptopsAndNotebooks = "//a[text()='Show AllLaptops & Notebooks']";
    private static String linkLaptopsandNotebooks= "//a[text()='Laptops & Notebooks']";
    private static String linkShoppingCart = "//a[@title='Shopping Cart']";

    public static void ValidateLogin(String expectedText) {
        browserUtils.validateText(myAccountText,expectedText);

    }

    public static void clickAllLaptopAndNotebooks(){
        browserUtils.hoverAndClickElements(linkLaptopsandNotebooks,linkShowAllLaptopsAndNotebooks);
    }

    public static void clickShoppingCart() {
        browserUtils.clickElement(linkShoppingCart);
    }
}
