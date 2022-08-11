package testRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Here some tags can be set, for example, tags = {"@Example", "~@ignore"},
        tags = {"@US1S1T11_12_15"},
        plugin = {"html:target/cucumber", "json:target/cucumber.json"},
        features = {"src/test/resources/features/"},
        glue = {"stepDefinitions"}
)

public class UniversalRunner {
}
