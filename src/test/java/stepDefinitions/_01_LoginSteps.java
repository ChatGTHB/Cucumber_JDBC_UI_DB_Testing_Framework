package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DialogContent;
import utilities.GWD;


public class _01_LoginSteps {
    DialogContent dialogContent = new DialogContent();

    @Given("Navigate to campus")
    public void navigateToCampus() {
        GWD.getDriver().get("https://test.mersys.io/");
    }

    @When("Enter valid username and password and click login button")
    public void enterValidUsernameAndPasswordAndClickLoginButton() {
        dialogContent.mySendKeys(dialogContent.username, "turkeyts");
        dialogContent.mySendKeys(dialogContent.password, "TechnoStudy123");
        dialogContent.myClick(dialogContent.loginButton);
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        dialogContent.verifyContainsText(dialogContent.textTechnoStudy, "Internship");
    }
}
