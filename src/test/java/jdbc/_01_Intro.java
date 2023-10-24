package jdbc;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {
    @Test
    public void test1() throws SQLException {

        // What is done to make a query work
        String hostUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        // 1)- We entered the connection information --> Connection information was set.
        Connection connection= DriverManager.getConnection(hostUrl,username,password);

        // 2)- We have chose the database --> This information was added to hostUrl (/sakila); no other additional action was taken

        // 3)- We opened the query screen
        Statement statement= connection.createStatement();

        // 4)- We wrote the query to query screen then I was run
        ResultSet resultTable=statement.executeQuery("select * from customer");

        // 5)- The results appeared below
        resultTable.next(); // At this stage we have completed the first line

        String name=resultTable.getString("first_name");   // I got the information he wanted in this line
        String surname=resultTable.getString("last_name"); // I got the information he wanted in this line
        System.out.println("name = " + name);
        System.out.println("surname = " + surname);

        resultTable.next(); // At this stage we have completed the second line

        name=resultTable.getString("first_name");   // I got the information he wanted in this line
        surname=resultTable.getString("last_name"); // I got the information he wanted in this line
        System.out.println("name = " + name);
        System.out.println("surname = " + surname);

        connection.close();
    }
}
