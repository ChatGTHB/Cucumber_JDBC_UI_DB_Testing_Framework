package jdbc;

import org.testng.annotations.*;

import java.sql.*;

public class JDBCParent {

    public static Connection connection;
    public static Statement statement;

    @BeforeClass
    public void DBConnectionOpen() {
        String HostUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(HostUrl, username, password);
            statement = connection.createStatement();
        } catch (Exception exception) {
            System.out.println("exception.getMessage() = " + exception.getMessage());
        }
    }

    @AfterClass
    public void DBConnectionClose() {
        try {
            connection.close();
        } catch (SQLException exception) {
            System.out.println("exception.getMessage() = " + exception.getMessage());
        }
    }
}
