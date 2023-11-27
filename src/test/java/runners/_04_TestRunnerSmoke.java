package runners;

import io.cucumber.testng.*;

@CucumberOptions(
        tags = "@SmokeTest",
        features = {"src/test/java/featureFiles"},
        glue={"stepDefinitions"},
        plugin= {"json:target/cucumber/cucumber.json"} // JSON report for Jenkins
)
public class _04_TestRunnerSmoke extends AbstractTestNGCucumberTests {
}
