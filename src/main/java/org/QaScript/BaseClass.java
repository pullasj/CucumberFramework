package org.QaScript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.QaScript.Utils.PropertiesUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

import static org.QaScript.Utils.GetBrowserDriver.getBrowserDriver;

public class BaseClass {

    // WebDriver instance to control the browser
    public static WebDriver driver;

    /**
     * Initializes the WebDriver, sets up the browser, and navigates to the application URL.
     */
    public static void initializeDriver() {
        // Load application properties
        Properties properties = PropertiesUtil.loadApplicationProperties();
        String url = properties.getProperty("application.url"); // Get the application URL from properties file

        // Load framework properties
        Properties properties1 = PropertiesUtil.loadFrameworkProperties();
        String browser = properties1.getProperty("browser.driver"); // Get the browser driver name from properties file

        // For Headless browser setup (uncomment the section below for headless testing)
        WebDriverManager.chromedriver().setup(); // Setup ChromeDriver using WebDriverManager
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless"); // Add headless option for browser to run without UI
        driver = new ChromeDriver(options); // Initialize the WebDriver with the headless options

        // Uncomment the lines below for a normal browser (non-headless) setup
        // driver = getBrowserDriver(browser); // Initialize the WebDriver with the specified browser

        driver.get(url); // Navigate to the application URL
        driver.manage().window().maximize(); // Maximize the browser window
    }

    /**
     * Closes the WebDriver and quits the browser session.
     */
    public static void closeDriver() {
        driver.quit(); // Close the browser and end the session
    }
}
