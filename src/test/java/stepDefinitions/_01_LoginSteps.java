package stepDefinitions;

import io.cucumber.java.en.*;
import pages.DialogContent;
import utilities.GWD;


import java.time.Duration;

public class _01_LoginSteps {

    DialogContent dc = new DialogContent();

    @Given("Navigate to Campus")
    public void navigateToCampus() {
        GWD.getDriver().get("https://test.mersys.io/");
    }

    @When("Enter valid username and passsword and click login button")
    public void enterValidUsernameAndPassswordAndClickLoginButton() {
        dc.sendKeys(dc.username, "turkeyts");
        dc.sendKeys(dc.password, "TechnoStudy123");
        dc.click(dc.loginButton);
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
    }
}
