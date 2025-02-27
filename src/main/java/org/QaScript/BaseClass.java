package org.QaScript;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.QaScript.Utils.PropertiesUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

import static org.QaScript.Utils.GetBrowserDriver.getBrowserDriver;

public class BaseClass {

    public static WebDriver driver;

    public static void initializeDriver() {
        Properties properties = PropertiesUtil.loadApplicationProperties();
        String url = properties.getProperty("application.url");
        Properties properties1 = PropertiesUtil.loadFrameworkProperties();
        String browser = properties1.getProperty("browser.driver");

//        For Headless browser
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);

//        Uncomment this one for head browser comments above four lines
//        driver = getBrowserDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void closeDriver() {
        driver.quit();
    }
}
