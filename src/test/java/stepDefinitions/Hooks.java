package stepDefinitions;

import io.cucumber.java.*;
import org.openqa.selenium.*;
import utilities.*;

public class Hooks {

    @Before
    public void before() {
        System.out.println("The scenario started.");
    }

    @After
    public void after(Scenario scenario) {
        ExcelUtility.writeToExcel("src/test/java/ApachePOI/resource/ScenarioResults2.xlsx",
                scenario);

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
