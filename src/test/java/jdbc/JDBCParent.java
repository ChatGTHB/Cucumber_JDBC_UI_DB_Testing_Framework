package jdbc;

import org.testng.annotations.*;

import java.sql.*;

public class JDBCParent {

    public static Connection connection;
    public static Statement statement;

    @BeforeClass
    public void dbConnectionOpen() {
        String hostUrl="jdbc:mysql://demo.mersys.io:33906/sakila";
        String username="admin";
        String password="Techno24Study.%=";

        try {
            connection = DriverManager.getConnection(hostUrl, username, password);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (Exception exception) {
            System.out.println("exception.getMessage() = " + exception.getMessage());
        }
    }

    @AfterClass
    public void dbConnectionClose() {
        try {
            connection.close();
        } catch (SQLException exception) {
            System.out.println("exception.getMessage() = " + exception.getMessage());
        }
    }
}
