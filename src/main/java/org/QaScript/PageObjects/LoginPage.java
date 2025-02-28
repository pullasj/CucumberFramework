package org.QaScript.PageObjects;

import org.QaScript.BaseClass;
//import org.QaScript.Utils.ExcelUtils; // Uncomment this if you plan to use ExcelUtils for Excel file operations
import org.QaScript.Utils.browserUtils;
import org.openqa.selenium.By;

import java.util.List;

public class LoginPage extends BaseClass {

    // Locator for the "Email" input field
    private static String txtEmail = "//input[@id='input-email']";

    // Locator for the "Password" input field
    private static String txtPassword = "//input[@id='input-password']";

    // Locator for the "Login" button
    private static String btnLogin = "//input[@value='Login']";

    // Locator for the "Forgotten Password" link
    private static String LinkForgotPassword = "(//a[text()='Forgotten Password'])[1]";

    // Locator for the alert error message when login fails
    private static String AlertLoginError = "//div[contains(@class,'alert-danger')]";

    // Uncomment if you plan to use ExcelUtils for reading data from Excel files
    // static ExcelUtils excelUtils = new ExcelUtils("src/test/resources/testData/Sample.xlsx");

    /**
     * Enters the username (email) into the email input field.
     * @param username The username (email) to be entered
     */
    public static void enterUsername(String username) {
        browserUtils.enterText(txtEmail, username); // Uses browserUtils to enter the username
    }

    /**
     * Enters the password into the password input field.
     * @param password The password to be entered
     */
    public static void enterPassword(String password) {
        browserUtils.enterText(txtPassword, password); // Uses browserUtils to enter the password
    }

    /**
     * Clicks the "Login" button to submit the login form.
     */
    public static void clickLogin() {
        browserUtils.clickElement(btnLogin); // Uses browserUtils to click the login button
    }

    /**
     * Clicks the "Forgotten Password" link to navigate to the password recovery page.
     */
    public static void forgetPassword() {
        driver.findElement(By.xpath(LinkForgotPassword)).click(); // Clicks the forgotten password link
    }

    /**
     * Validates if the error message displayed matches the expected message.
     * @param expectedMessage The expected error message after invalid login
     */
    public static void validateInvalidLogin(String expectedMessage) {
        browserUtils.validateText(AlertLoginError, expectedMessage); // Validates the error message displayed
    }

    // Uncomment this block to use ExcelUtils for reading the username from an Excel file
    /*
    public static void ExcelUsername() {
        List<String> userNames = excelUtils.readExcelData("Login", "Username"); // Read data from the "Login" sheet in the Excel file
        String username = userNames.get(0); // Get the first username
        System.out.println(username); // Prints the username
        browserUtils.enterText(txtEmail, username); // Enter the username in the email field
    }
    */
}
