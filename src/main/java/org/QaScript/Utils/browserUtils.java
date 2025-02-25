package org.QaScript.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.QaScript.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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
        Assert.assertTrue(actualText.equals(expectedText));
    }
}

