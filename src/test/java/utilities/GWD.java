package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            Logger logger = Logger.getLogger("");
            logger.setLevel(Level.SEVERE);

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        }

        return driver;
    }

    public static void quitDriver() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver != null) {
            driver.quit();
            driver = null;

        }
    }
}
