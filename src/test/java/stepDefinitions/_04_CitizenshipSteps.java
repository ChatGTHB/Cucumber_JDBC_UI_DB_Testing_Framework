package stepDefinitions;

import io.cucumber.java.en.*;
import org.apache.commons.lang3.RandomStringUtils;
import pages.DialogContent;
import pages.LeftNav;

public class _04_CitizenshipSteps {

    LeftNav leftNav =new LeftNav();
    DialogContent dialogContent =new DialogContent();
    @And("Navigate to citizenship")
    public void navigateToCitizenship() {
        leftNav.myClick(leftNav.setup);
        leftNav.myClick(leftNav.parameters);
        leftNav.myClick(leftNav.citizenship);
    }

    @When("Create a citizenship")
    public void createACitizenship() {
        String citizenshipName = RandomStringUtils.randomAlphanumeric(8);
        String citizenshipShortCode = RandomStringUtils.randomNumeric(4);

        dialogContent.myClick(dialogContent.addButton);
        dialogContent.mySendKeys(dialogContent.nameInput, citizenshipName);
        dialogContent.mySendKeys(dialogContent.shortName, citizenshipShortCode);
        dialogContent.myClick(dialogContent.saveButton);
    }

    @When("Create a citizenship that name as {string} short name as {string}")
    public void createACitizenshipThatNameAsShortNameAs(String name, String shortName) {
        dialogContent.myClick(dialogContent.addButton);
        dialogContent.mySendKeys(dialogContent.nameInput, name);
        dialogContent.mySendKeys(dialogContent.shortName, shortName);
        dialogContent.myClick(dialogContent.saveButton);
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dialogContent.verifyContainsText(dialogContent.alreadyExist, "already");
    }

    @When("User delete the citizenship that name as {string}")
    public void userDeleteTheCitizenshipThatNameAs(String name) {
        dialogContent.deleteItem(name);
    }
}
