package org.QaScript.StepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.QaScript.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hooks class for setting up and tearing down WebDriver before and after each scenario.
 * This class extends BaseClass to use shared WebDriver methods.
 */
public class Hooks extends BaseClass {

    /**
     * This method runs before each scenario.
     * It initializes the WebDriver instance.
     */
    @Before
    public void Setup() {
        initializeDriver();
    }

    /**
     * This method runs after each scenario.
     * It closes the WebDriver instance.
     */
    @After
    public void Close() {
        closeDriver();
    }
}