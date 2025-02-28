package org.QaScript.PageObjects;

import org.QaScript.BaseClass;
import org.QaScript.Utils.browserUtils;
import org.openqa.selenium.By;

public class HomePage extends BaseClass {

    // Locator for the "My Account" text on the page
    private static String myAccountText = "(//div[@id='content']/h2)[1]";

    // Locator for the "Show All Laptops & Notebooks" link on the HomePage
    private static String linkShowAllLaptopsAndNotebooks = "//a[text()='Show AllLaptops & Notebooks']";

    // Locator for the "Laptops & Notebooks" menu item
    private static String linkLaptopsandNotebooks = "//a[text()='Laptops & Notebooks']";

    // Locator for the "Shopping Cart" link
    private static String linkShoppingCart = "//a[@title='Shopping Cart']";

    /**
     * Validates if the "My Account" text matches the expected text.
     * @param expectedText The text that should be displayed in the "My Account" section
     */
    public static void ValidateLogin(String expectedText) {
        browserUtils.validateText(myAccountText, expectedText); // Compare the actual text with expected text
    }

    /**
     * Hover over the "Laptops & Notebooks" menu item and click on "Show All Laptops & Notebooks" link.
     */
    public static void clickAllLaptopAndNotebooks() {
        browserUtils.hoverAndClickElements(linkLaptopsandNotebooks, linkShowAllLaptopsAndNotebooks); // Hover and click
    }

    /**
     * Clicks the "Shopping Cart" link to navigate to the shopping cart page.
     */
    public static void clickShoppingCart() {
        browserUtils.clickElement(linkShoppingCart); // Click the shopping cart link
    }
}
