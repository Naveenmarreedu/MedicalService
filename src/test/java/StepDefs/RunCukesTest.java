package StepDefs;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "FeatureFiles",
        glue = "StepDefs",
        plugin = {"pretty"})
public class RunCukesTest {
}
