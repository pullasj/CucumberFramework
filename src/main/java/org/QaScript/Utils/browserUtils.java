package org.QaScript.Utils;

import org.QaScript.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class browserUtils extends BaseClass {

    /**
     * Clicks an element identified by its XPath.
     * @param element The XPath of the element to click
     */
    public static void clickElement(String element){
        // Ensures the element is displayed before clicking
        driver.findElement(By.xpath(element)).isDisplayed();
        driver.findElement(By.xpath(element)).click(); // Click the element
    }

    /**
     * Enters text into an input field identified by its XPath.
     * @param element The XPath of the input field
     * @param text The text to be entered
     */
    public static void enterText(String element, String text){
        // Ensures the element is displayed before interacting with it
        driver.findElement(By.xpath(element)).isDisplayed();
        driver.findElement(By.xpath(element)).clear(); // Clear any existing text
        driver.findElement(By.xpath(element)).sendKeys(text); // Enter the new text
    }

    /**
     * Validates the text of an element against an expected value.
     * @param element The XPath of the element to validate
     * @param expectedText The expected text value
     */
    public static void validateText(String element, String expectedText) {
        String actualText = driver.findElement(By.xpath(element)).getText(); // Get the actual text from the element
        // Assert that the actual text matches the expected text
        Assert.assertTrue("Expected Value: "+expectedText+" Actual Value: "+actualText, actualText.equals(expectedText));
    }

    /**
     * Validates the value of an element’s attribute.
     * @param element The XPath of the element
     * @param expectedText The expected value of the attribute
     * @param attributeType The attribute type (e.g., "value", "src")
     */
    public static void validateValue(String element, String expectedText, String attributeType) {
        String actualValue = driver.findElement(By.xpath(element)).getDomAttribute(attributeType); // Get the attribute value
        // Assert that the actual attribute value matches the expected value
        Assert.assertTrue("Expected Value: "+expectedText+" Actual Value: "+actualValue, actualValue.equals(expectedText));
    }

    /**
     * Performs a hover action on an element and then clicks on another element.
     * @param hover The XPath of the element to hover over
     * @param click The XPath of the element to click
     */
    public static void hoverAndClickElements(String hover, String click){
        WebElement e1 = driver.findElement(By.xpath(hover)); // The element to hover over
        WebElement e2 = driver.findElement(By.xpath(click)); // The element to click after hovering
        Actions actions = new Actions(driver); // Create an Actions object for mouse interactions
        actions.moveToElement(e1).click(e2).build().perform(); // Hover and click the elements
    }
}
