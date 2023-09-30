package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;

public class _08_DataTableExample {
    @When("Write username {string}")
    public void writeUsername(String username) {
        System.out.println("username = " + username);
    }

    @And("Write username and password {string} and {string}")
    public void writeUsernameAndPasswordAnd(String username, String password) {
        System.out.print("Username = " + username);
        System.out.println("  Password = " + password);
    }

    @And("Write username as DataTable")
    public void writeUsernameAsDataTable(DataTable users) {
        List<String> listUsers = users.asList(String.class); // list

        for (String user : listUsers) {
            System.out.println("User = " + user);
        }
    }

    @And("Write username and password as DataTable")
    public void writeUsernameAndPasswordAsDataTable(DataTable usersAndPasswords) {
        List<List<String>> usersAndPasswordsLists = usersAndPasswords.asLists(String.class);

        for (List<String> usersAndPasswordsList : usersAndPasswordsLists) {
            System.out.printf("User = %-15s <--> Password = %s%n",
                    usersAndPasswordsList.get(0),  // username
                    usersAndPasswordsList.get(1)); // password
        }
    }
}
