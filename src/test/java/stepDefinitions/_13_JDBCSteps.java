package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.DialogContent;
import utilities.DBUtility;

import java.util.List;

public class _13_JDBCSteps {

    DialogContent dialogContent = new DialogContent();

    @Then("Send the query the database {string} and control match")
    public void sendTheQueryTheDatabaseAndControlMatch(String sql) {
        // Read from DB
        List<List<String>> dbList = DBUtility.getDataList(sql); // I read from db

        for (int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i).get(0));          // I check the DB information I read
        }

        System.out.println("-------------------------");

        // Read from UI
        List<WebElement> UIList = dialogContent.nameList;
        for (int i = 0; i < UIList.size(); i++) {
            System.out.println(UIList.get(i).getText());       // I check the UI information I read
        }

        // Compare
        for (int i = 0; i < dbList.size(); i++) {
            System.out.println(dbList.get(i).get(0) + " - " + UIList.get(i).getText());
            Assert.assertEquals(dbList.get(i).get(0).trim(), UIList.get(i).getText().trim(), "Pairing failed");
        }
    }
}
