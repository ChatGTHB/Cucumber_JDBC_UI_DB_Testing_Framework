package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import pages.DialogContent;
import pages.LeftNav;

import java.util.List;

public class _09_DataTableSteps {

    LeftNav leftNav = new LeftNav();
    DialogContent dialogContent = new DialogContent();

    @And("Click on the element in LeftNav")
    public void clickOnTheElementInLeftNav(DataTable links) {

        List<String> linksList = links.asList(String.class);

        for (int i = 0; i < linksList.size(); i++) {
            String link = linksList.get(i);
            WebElement webElement = leftNav.getWebElement(link);
            leftNav.myClick(webElement);
        }
    }

    @And("Click on the element in Dialog")
    public void clickOnTheElementInDialog(DataTable buttons) {

        List<String> buttonsList = buttons.asList(String.class);

        for (int i = 0; i < buttonsList.size(); i++) {
            String button = buttonsList.get(i);
            WebElement webElement = dialogContent.getWebElement(button);
            dialogContent.myClick(webElement);
        }
    }

    @And("User sending the keys in Dialog")
    public void userSendingTheKeysInDialog(DataTable dataTable) {

        List<List<String>> items = dataTable.asLists(String.class);

        for (int i = 0; i < items.size(); i++) {
            List<String> item = items.get(i);
            WebElement webElement = dialogContent.getWebElement(item.get(0)); // 0. Web Element
            String text = item.get(1); // The First Text
            dialogContent.mySendKeys(webElement, text);
        }
    }

    @And("User delete the element from Dialog")
    public void userDeleteTheElementFromDialog(DataTable dataTable) {

        List<String> willBeDeleted = dataTable.asList(String.class);

        for (int i = 0; i < willBeDeleted.size(); i++) {
            String s = willBeDeleted.get(i);
            dialogContent.deleteItem(s);
        }
    }
}