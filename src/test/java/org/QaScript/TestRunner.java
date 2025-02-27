package org.QaScript;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// Specifies that this class should use the Cucumber test runner
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/ShopingCart.feature"}, // Path to feature files
        plugin = {
                "pretty", // Formats the output for better readability
                "html:target/cucumber.html", // Generates an HTML report
                "json:target/cucumber.json" // Generates a JSON report for test results
        },
        tags = "@smoke",
        publish = true
)


public class TestRunner {
}
