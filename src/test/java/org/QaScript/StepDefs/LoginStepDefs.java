package org.QaScript.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.QaScript.BaseClass;
import org.QaScript.PageObjects.HomePage;
import org.QaScript.PageObjects.LoginPage;
import org.QaScript.Utils.PropertiesUtil;
import java.util.Properties;

public class LoginStepDefs extends BaseClass {

    Properties properties = PropertiesUtil.loadApplicationProperties(); // Corrected to call static method directly

    @Given("User enters valid username in the username field")
    public void userEntersValidUsernameInTheUsernameField() {
        String username = properties.getProperty("username");
        LoginPage.enterUsername(username);
    }

    @And("User enters valid password in the password field")
    public void userEntersValidPasswordInThePasswordField() {
        String password = properties.getProperty("password");
        LoginPage.enterPassword(password);
    }

    @When("User clicks on the Login button")
    public void userClicksOnTheLoginButton() {
        LoginPage.clickLogin();
    }

    @Then("User is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        HomePage.ValidateLogin("My Account");
    }

    @Given("^User enters invalid (.*) in the username field$")
    public void userEntersInvalidUsernameInTheUsernameField(String username) {
        LoginPage.enterUsername(username);
    }

    @And("^User enters invalid (.*) in the password field$")
    public void userEntersInvalidPasswordInThePasswordField(String password) {
        LoginPage.enterPassword(password);
    }

    @Then("error message will display")
    public void errorMessageWillDisplay() {
        LoginPage.validateInvalidLogin("Warning: No match for E-Mail Address and/or Password.");
    }
}
