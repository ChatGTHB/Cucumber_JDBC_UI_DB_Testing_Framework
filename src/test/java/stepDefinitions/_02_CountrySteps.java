package stepDefinitions;

import io.cucumber.java.en.*;
import org.apache.commons.lang3.RandomStringUtils;
import pages.DialogContent;
import pages.LeftNav;

public class _02_CountrySteps {

    DialogContent dc = new DialogContent();
    LeftNav ln = new LeftNav();

    @And("Navigate to country")
    public void navigateToCountry() {
        ln.myClick(ln.setup);
        ln.myClick(ln.parameters);
        ln.myClick(ln.countries);
    }

    @When("Create a country")
    public void createACountry() {
        String countryName = RandomStringUtils.randomAlphanumeric(8);
        String countryCode = RandomStringUtils.randomNumeric(4);

        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput, countryName);
        dc.mySendKeys(dc.codeInput, countryCode);
        dc.myClick(dc.saveButton);
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.verifyContainsText(dc.successMessage, "success");
    }

    @When("Create a country that name as {string} code as {string}")
    public void createACountryThatNameAsCodeAs(String name, String code) {
        name = "RandomCountry" + RandomStringUtils.randomAlphanumeric(8);
        code = "RandomCode" + RandomStringUtils.randomNumeric(4);

        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput, name);
        dc.mySendKeys(dc.codeInput, code);
        dc.myClick(dc.saveButton);
    }
}

