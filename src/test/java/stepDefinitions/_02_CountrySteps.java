package stepDefinitions;

import io.cucumber.java.en.*;
import org.apache.commons.lang3.RandomStringUtils;
import pages.DialogContent;
import pages.LeftNav;

public class _02_CountrySteps {

    DialogContent dialogContent = new DialogContent();
    LeftNav leftNav = new LeftNav();

    @And("Navigate to country")
    public void navigateToCountry() {
        leftNav.myClick(leftNav.setup);
        leftNav.myClick(leftNav.parameters);
        leftNav.myClick(leftNav.countries);
    }

    @When("Create a country")
    public void createACountry() {
        String countryName = RandomStringUtils.randomAlphanumeric(8);
        String countryCode = RandomStringUtils.randomNumeric(4);

        dialogContent.myClick(dialogContent.addButton);
        dialogContent.mySendKeys(dialogContent.nameInput, countryName);
        dialogContent.mySendKeys(dialogContent.codeInput, countryCode);
        dialogContent.myClick(dialogContent.saveButton);
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dialogContent.verifyContainsText(dialogContent.successMessage, "success");
    }

    @When("Create a country that name as {string} code as {string}")
    public void createACountryThatNameAsCodeAs(String name, String code) {
        name = "RandomCountry" + RandomStringUtils.randomAlphanumeric(8);
        code = "RandomCode" + RandomStringUtils.randomNumeric(4);

        dialogContent.myClick(dialogContent.addButton);
        dialogContent.mySendKeys(dialogContent.nameInput, name);
        dialogContent.mySendKeys(dialogContent.codeInput, code);
        dialogContent.myClick(dialogContent.saveButton);
    }
}

