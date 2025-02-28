package org.QaScript.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GetBrowserDriver {

    /**
     * Returns a WebDriver instance based on the specified browser name.
     *
     * @param browser The name of the browser (e.g., "chrome", "firefox", "ie")
     * @return WebDriver instance for the specified browser
     */
    public static WebDriver getBrowserDriver(String browser) {
        WebDriver driver;

        // Check if the browser string is not null and match it with the case-insensitive browser name
        if (browser != null) {
            switch (browser.toLowerCase()) {
                case "chrome":  // Case for Chrome browser
                    driver = setChromeDriver();
                    break;
                case "firefox": // Case for Firefox browser
                    driver = setFirefoxDriver();
                    break;
                case "ie":      // Case for Internet Explorer browser
                    driver = setIEDriver();
                    break;
                default:
                    // If the browser is not recognized, throw an exception
                    throw new IllegalArgumentException("Browser " + browser + " is not supported.");
            }
        } else {
            // If the browser name is null, throw an exception
            throw new IllegalArgumentException("Browser name is null.");
        }
        return driver;  // Return the WebDriver instance for the selected browser
    }

    /**
     * Sets up the Internet Explorer (IE) driver and returns an instance.
     *
     * @return WebDriver instance for Internet Explorer
     */
    private static WebDriver setIEDriver() {
        WebDriverManager.iedriver().setup(); // Setup WebDriver for Internet Explorer
        return new InternetExplorerDriver(); // Return a new instance of IE WebDriver
    }

    /**
     * Sets up the Firefox driver and returns an instance.
     *
     * @return WebDriver instance for Firefox
     */
    private static WebDriver setFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup(); // Setup WebDriver for Firefox
        return new FirefoxDriver(); // Return a new instance of Firefox WebDriver
    }

    /**
     * Sets up the Chrome driver and returns an instance.
     *
     * @return WebDriver instance for Chrome
     */
    private static WebDriver setChromeDriver() {
        WebDriverManager.chromedriver().setup(); // Setup WebDriver for Chrome
        return new ChromeDriver(); // Return a new instance of Chrome WebDriver
    }
}
