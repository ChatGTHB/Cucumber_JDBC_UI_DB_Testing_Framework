package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@SmokeTest or @Regression",
        features = {"src/test/java/featureFiles"},
        glue={"stepDefinitions"}
)
public class _05_TestRunnerRegression extends AbstractTestNGCucumberTests {
}
