package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ExcelUtility;
import utilities.GWD;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    @Before
    public void before() {
        System.out.println("The scenario has started.");
    }

    @After
    public void after(Scenario scenario) {
        ExcelUtility.writeToExcel("src/test/java/apachePOI/resource/ScenarioResults.xlsx", scenario, GWD.threadBrowserName.get());

        // Keep the extent report's plugin open while it is active
        if (scenario.isFailed()) {
            TakesScreenshot screenshot = (TakesScreenshot) GWD.getDriver();

            // Capture the screenshot in memory
            byte[] stateInMemory = screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(stateInMemory, "image/png", "screenshot name");

            // Save the screenshot as a file
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

            // Set the folder path and file name
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String screenshotName = "screenshot_" + timestamp + ".png";
            File destFile = new File("target/failed_screenshots/" + screenshotName);

            try {
                // Copy the screenshot to the specified directory
                FileUtils.copyFile(srcFile, destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("The scenario finished.");

        GWD.quitDriver();
    }
}

