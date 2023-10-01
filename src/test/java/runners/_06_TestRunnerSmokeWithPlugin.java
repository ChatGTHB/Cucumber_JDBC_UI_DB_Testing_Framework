package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@SmokeTest",
        features = {"src/test/java/featureFiles"},
        glue={"stepDefinitions"},
        plugin= {"html:target/site/cucumber-pretty.html"},
        dryRun = false
)
public class _06_TestRunnerSmokeWithPlugin extends AbstractTestNGCucumberTests {
}
