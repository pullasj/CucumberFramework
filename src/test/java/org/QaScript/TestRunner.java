package org.QaScript;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Test Runner class for running Cucumber tests.
 * This class is responsible for running the feature files with the specified configurations.
 */
@RunWith(Cucumber.class)  // Specifies that this class should use the Cucumber test runner
@CucumberOptions(
        features = {
                "src/test/resources/features/ShopingCart.feature", // Path to the ShopingCart.feature file
                "src/test/resources/features/Login.feature" // Path to the Login.feature file
        },
        plugin = {
                "pretty", // Outputs the test execution in a more readable format
                "html:target/cucumber.html", // Generates an HTML report of the test results
                "json:target/cucumber.json" // Generates a JSON report for the test results
        },
        tags = "@smoke", // Runs tests tagged with @smoke
        publish = true // Publishes the test results to the Cucumber dashboard
)
public class TestRunner {
        // This class is used to configure and run the Cucumber tests with the specified options.
}
