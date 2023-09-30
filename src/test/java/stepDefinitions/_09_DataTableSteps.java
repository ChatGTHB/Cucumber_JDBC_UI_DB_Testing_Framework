package stepDefinitions;

import pages.DialogContent;
import pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _09_DataTableSteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Click on the element in LeftNav")
    public void clickOnTheElementInLeftNav(DataTable links) {
        List<String> linksList = links.asList(String.class);

        for (int i = 0; i < linksList.size(); i++) {
            String link = linksList.get(i);
            WebElement webElement = ln.getWebElement(link);
            ln.myClick(webElement);
        }
    }

    @And("Click on the element in Dialog")
    public void clickOnTheElementInDialog(DataTable buttons) {
        List<String> buttonsList = buttons.asList(String.class);

        for (int i = 0; i < buttonsList.size(); i++) {
            String button = buttonsList.get(i);
            WebElement webElement = dc.getWebElement(button);
            dc.myClick(webElement);
        }
    }

    @And("User sending the keys in Dialog")
    public void userSendingTheKeysInDialog(DataTable dataTable) {
        List<List<String>> items = dataTable.asLists(String.class);

        for (int i = 0; i < items.size(); i++) {
            List<String> item = items.get(i);
            WebElement webElement = dc.getWebElement(item.get(0)); // 0. Web Element
            String text = item.get(1); // The First Text
            dc.mySendKeys(webElement, text);
        }
    }

    @And("User delete the element from Dialog")
    public void userDeleteTheElementFromDialog(DataTable dataTable) {
        List<String> willBeDeleted = dataTable.asList(String.class);

        for (int i = 0; i < willBeDeleted.size(); i++) {
            String s = willBeDeleted.get(i);
            dc.deleteItem(s);
        }
    }
}
