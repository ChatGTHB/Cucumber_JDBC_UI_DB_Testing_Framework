package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@SmokeTest",
        features = {"src/test/java/featureFiles"},
        glue={"stepDefinitions"},
        dryRun = false,
        plugin= {"html:target/site/cucumber-pretty.html"}
)
public class _06_TestRunnerSmokeWithPlugin extends AbstractTestNGCucumberTests {
}
