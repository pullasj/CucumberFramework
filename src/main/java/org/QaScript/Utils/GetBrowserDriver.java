package org.QaScript.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GetBrowserDriver {

    public static WebDriver getBrowserDriver(String browser) {
        WebDriver driver;

        if (browser != null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = setChromeDriver();
                    break;
                case "firefox":
                    driver = setFirefoxDriver();
                    break;
                case "ie":
                    driver = setIEDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Browser " + browser + " is not supported.");
            }
        } else {
            throw new IllegalArgumentException("Browser name is null.");
        }
        return driver;
    }

    private static WebDriver setIEDriver() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    private static WebDriver setFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver setChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
