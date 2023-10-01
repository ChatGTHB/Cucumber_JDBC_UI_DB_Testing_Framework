package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ExcelUtility;
import utilities.GWD;

public class Hooks {

    @Before
    public void before() {
        System.out.println("The scenario started.");
    }

    @After
    public void after(Scenario scenario) {
//        ExcelUtility.writeToExcel("src/test/java/ApachePOI/resource/ScenarioResults3.xlsx",
//                scenario);

        // Keep the extent report's plugin open while it is active
        if (scenario.isFailed()){
            TakesScreenshot screenshot=((TakesScreenshot) GWD.getDriver());
            byte[] stateInMemory=screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(stateInMemory, "image/png", "screenshot name");
        }
        System.out.println("The scenario finished.");
        GWD.quitDriver();
    }
}
