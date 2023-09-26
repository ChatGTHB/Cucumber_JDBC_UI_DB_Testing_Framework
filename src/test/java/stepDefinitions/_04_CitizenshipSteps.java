package stepDefinitions;

import io.cucumber.java.en.*;
import org.apache.commons.lang3.RandomStringUtils;
import pages.DialogContent;
import pages.LeftNav;

public class _04_CitizenshipSteps {

    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();
    @And("Navigate to Citizenship")
    public void navigateToCitizenship() {
        ln.myClick(ln.setup);
        ln.myClick(ln.parameters);
        ln.myClick(ln.citizenship);
    }

    @When("Create a Citizenship")
    public void createACitizenship() {
        String citizenshipName = RandomStringUtils.randomAlphanumeric(8);
        String citizenshipShortCode = RandomStringUtils.randomNumeric(4);

        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput, citizenshipName);
        dc.mySendKeys(dc.shortName, citizenshipShortCode);
        dc.myClick(dc.saveButton);
    }

    @When("Create a Citizenship that name as {string} short name as {string}")
    public void createACitizenshipThatNameAsShortNameAs(String name, String shortName) {
        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput, name);
        dc.mySendKeys(dc.shortName, shortName);
        dc.myClick(dc.saveButton);

    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.verifyContainsText(dc.alreadyExist, "already");
    }

    @When("User delete the {string}")
    public void userDeleteThe(String name) {
        dc.deleteItem(name);
    }
}
