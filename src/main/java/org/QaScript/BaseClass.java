package org.QaScript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.QaScript.Utils.PropertiesUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

import static org.QaScript.Utils.GetBrowserDriver.getBrowserDriver;

public class BaseClass {

    public static WebDriver driver;

    public static void initializeDriver() {
        Properties properties = PropertiesUtil.loadApplicationProperties();
        String url = properties.getProperty("application.url");
        Properties properties1 = PropertiesUtil.loadFrameworkProperties();
        String browser = properties1.getProperty("browser.driver");

        driver = getBrowserDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void closeDriver() {
        driver.quit();
    }
}
