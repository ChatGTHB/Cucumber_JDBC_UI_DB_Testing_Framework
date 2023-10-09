package stepDefinitions;

import io.cucumber.java.en.*;
import pages.DialogContent;
import utilities.ExcelUtility;

import java.util.ArrayList;

public class _12_ApachePOISteps {

    DialogContent dc = new DialogContent();

    @When("User create citizenship with ApachePOI")
    public void userCreateCitizenshipWithApachePOI() {

        ArrayList<ArrayList<String>> table =
                ExcelUtility.getData
                        ("src/test/java/ApachePOI/resource/ApacheExcel.xlsx",
                                "testCitizen", 2);

        for (int i = 0; i < table.size(); i++) {
            ArrayList<String> row = table.get(i);
            dc.myClick(dc.addButton);
            dc.mySendKeys(dc.nameInput, row.get(0));
            dc.mySendKeys(dc.shortName, row.get(1));
            dc.myClick(dc.saveButton);
            dc.verifyContainsText(dc.successMessage, "success");
        }
    }

    @Then("User delete citizenship with ApachePOI")
    public void userDeleteCitizenshipWithApachePOI() {

        ArrayList<ArrayList<String>> table =
                ExcelUtility.getData
                        ("src/test/java/ApachePOI/resource/ApacheExcel.xlsx",
                                "testCitizen", 2);

        for (int i = 0; i < table.size(); i++) {
            ArrayList<String> row = table.get(i);
            dc.deleteItem(row.get(0));
            dc.verifyContainsText(dc.successMessage, "success");
        }
    }
}
