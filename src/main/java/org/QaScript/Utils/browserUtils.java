package org.QaScript.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.QaScript.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class browserUtils extends BaseClass {
    public static void clickElement(String element){
            driver.findElement(By.xpath(element)).isDisplayed();
            driver.findElement(By.xpath(element)).click();
    }

    public static void enterText(String element, String text){
        driver.findElement(By.xpath(element)).isDisplayed();
        driver.findElement(By.xpath(element)).clear();
        driver.findElement(By.xpath(element)).sendKeys(text);
    }

    public static void validateText(String element, String expectedText) {
        String actualText = driver.findElement(By.xpath(element)).getText();
        Assert.assertTrue("Expected Value: "+expectedText+"Actual Value: "+actualText,actualText.equals(expectedText));
    }

    public static void validateValue(String element, String expectedText,String attributeType) {
        String actualValue = driver.findElement(By.xpath(element)).getDomAttribute(attributeType);
        Assert.assertTrue("Expected Value: "+expectedText+"Actual Value: "+actualValue,actualValue.equals(expectedText));
    }

    public static void hoverAndClickElements(String hover, String click){
        WebElement e1 = driver.findElement(By.xpath(hover));
        WebElement e2 = driver.findElement(By.xpath(click));
        Actions actions = new Actions(driver);
        actions.moveToElement(e1).click(e2).build().perform();
    }
}

