package stepDefinitions;

import io.cucumber.java.en.*;
import pages.DialogContent;
import utilities.GWD;


public class _01_LoginSteps {
    DialogContent dc = new DialogContent();

    @Given("Navigate to Campus")
    public void navigateToCampus() {
        GWD.getDriver().get("https://test.mersys.io/");
    }

    @When("Enter valid username and password and click login button")
    public void enterValidUsernameAndPassswordAndClickLoginButton() {
        dc.mySendKeys(dc.username, "turkeyts");
        dc.mySendKeys(dc.password, "TechnoStudy123");
        dc.myClick(dc.loginButton);
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        dc.verifyContainsText(dc.textTechnoStudy, "Techno Study");
    }
}
