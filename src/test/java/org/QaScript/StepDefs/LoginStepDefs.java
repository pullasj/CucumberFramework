package org.QaScript.StepDefs;

import io.cucumber.java.en.*;
import org.QaScript.BaseClass;
import org.QaScript.PageObjects.HomePage;
import org.QaScript.PageObjects.LoginPage;
import org.QaScript.Utils.PropertiesUtil;

import java.util.Properties;

public class LoginStepDefs extends BaseClass {

    Properties properties = PropertiesUtil.loadApplicationProperties();

    @Given("User enters valid username in the username field")
    public void userEntersValidUsernameInTheUsernameField() {
        String username = properties.getProperty("username");
        LoginPage loginPage = new LoginPage(); // Create an instance of LoginPage
        loginPage.enterUsername(username);
    }

    @And("User enters valid password in the password field")
    public void userEntersValidPasswordInThePasswordField() {
        String password = properties.getProperty("password");
        LoginPage loginPage = new LoginPage(); // Create an instance of LoginPage
        loginPage.enterPassword(password);
    }

    @When("User clicks on the Login button")
    public void userClicksOnTheLoginButton() {
        LoginPage loginPage = new LoginPage(); // Create an instance of LoginPage
        loginPage.clickLogin();
    }

    @Then("User is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        HomePage homePage = new HomePage(); // Create an instance of HomePage
        homePage.ValidateLogin("My Account");
    }

    @Given("^User enters invalid (.*) in the username field$")
    public void userEntersInvalidUsernameInTheUsernameField(String username) {
        LoginPage loginPage = new LoginPage(); // Create an instance of LoginPage
        loginPage.enterUsername(username);
    }

    @And("^User enters invalid (.*) in the password field$")
    public void userEntersInvalidPasswordInThePasswordField(String password) {
        LoginPage loginPage = new LoginPage(); // Create an instance of LoginPage
        loginPage.enterPassword(password);
    }

    @Then("error message will display")
    public void errorMessageWillDisplay() {
        LoginPage loginPage = new LoginPage(); // Create an instance of LoginPage
        loginPage.validateInvalidLogin("Warning: No match for E-Mail Address and/or Password.");
    }

    @Given("User is able to login Application")
    public void userIsAbleToLoginApplication() {
        userEntersValidUsernameInTheUsernameField();
        userEntersValidPasswordInThePasswordField();
        userClicksOnTheLoginButton();
    }

}
