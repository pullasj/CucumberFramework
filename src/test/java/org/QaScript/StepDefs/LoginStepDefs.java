package org.QaScript.StepDefs;

import io.cucumber.java.en.*;
import org.QaScript.BaseClass;
import org.QaScript.PageObjects.HomePage;
import org.QaScript.PageObjects.LoginPage;
import org.QaScript.Utils.PropertiesUtil;

import java.util.Properties;

/**
 * Step Definitions class for handling login-related Cucumber steps.
 * Extends BaseClass to use shared WebDriver utilities.
 */
public class LoginStepDefs extends BaseClass {

    // Load application properties (e.g., URL, username, password) from the properties file.
    Properties properties = PropertiesUtil.loadApplicationProperties();

    /**
     * Step to enter a valid username in the login field.
     */
    @Given("User enters valid username in the username field")
    public void userEntersValidUsernameInTheUsernameField() {
        String username = properties.getProperty("username"); // Retrieve username from properties file
        LoginPage loginPage = new LoginPage(); // Create an instance of LoginPage
        loginPage.enterUsername(username); // Enter the retrieved username
    }

    /**
     * Step to enter a valid password in the login field.
     */
    @And("User enters valid password in the password field")
    public void userEntersValidPasswordInThePasswordField() {
        String password = properties.getProperty("password"); // Retrieve password from properties file
        LoginPage loginPage = new LoginPage(); // Create an instance of LoginPage
        loginPage.enterPassword(password); // Enter the retrieved password
    }

    /**
     * Step to click on the Login button.
     */
    @When("User clicks on the Login button")
    public void userClicksOnTheLoginButton() {
        LoginPage loginPage = new LoginPage(); // Create an instance of LoginPage
        loginPage.clickLogin(); // Click the login button
    }

    /**
     * Step to validate that the user has successfully logged in.
     */
    @Then("User is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        HomePage homePage = new HomePage(); // Create an instance of HomePage
        homePage.ValidateLogin("My Account"); // Validate successful login
    }

    /**
     * Step to enter an invalid username dynamically.
     */
    @Given("^User enters invalid (.*) in the username field$")
    public void userEntersInvalidUsernameInTheUsernameField(String username) {
        LoginPage loginPage = new LoginPage(); // Create an instance of LoginPage
        loginPage.enterUsername(username); // Enter the invalid username provided in the scenario
    }

    /**
     * Step to enter an invalid password dynamically.
     */
    @And("^User enters invalid (.*) in the password field$")
    public void userEntersInvalidPasswordInThePasswordField(String password) {
        LoginPage loginPage = new LoginPage(); // Create an instance of LoginPage
        loginPage.enterPassword(password); // Enter the invalid password provided in the scenario
    }

    /**
     * Step to verify that an error message is displayed for invalid login attempts.
     */
    @Then("error message will display")
    public void errorMessageWillDisplay() {
        LoginPage loginPage = new LoginPage(); // Create an instance of LoginPage
        loginPage.validateInvalidLogin("Warning: No match for E-Mail Address and/or Password."); // Validate error message
    }

    /**
     * Step to perform a complete login flow.
     * This method reuses existing steps for entering credentials and clicking the login button.
     */
    @Given("User is able to login Application")
    public void userIsAbleToLoginApplication() {
        userEntersValidUsernameInTheUsernameField(); // Call method to enter username
        userEntersValidPasswordInThePasswordField(); // Call method to enter password
        userClicksOnTheLoginButton(); // Call method to click login button
    }
}
