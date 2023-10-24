package jdbc;

import jdbc.JDBCParent;
import org.testng.annotations.Test;

import java.sql.*;

public class _03_NextPrevAbsRel extends JDBCParent {

    @Test
    public void test1() throws SQLException {

        ResultSet resultTable = statement.executeQuery("select * from language");

        resultTable.next(); // One step forward --> 1. Row
        System.out.println("1.Row = " + resultTable.getString(2));      // 1. Row and 2. Column                  -ing

        resultTable.next();  // One step forward --> 2. Row
        System.out.println("2.Row = " + resultTable.getString("name")); // 2. Row and name Column (2. Column)    -ital

        resultTable.previous(); // One step previous --> 1.Row
        System.out.println("1.Row = " + resultTable.getString(2));      // 1. Row and 2. Column                   -ing
    }

    @Test
    public void test2() throws SQLException {

        ResultSet resultTable = statement.executeQuery("select * from film");

        resultTable.absolute(10); // Go directly to line 10
        System.out.println("10.Row title = " + resultTable.getString("title")); // alaaddin

        resultTable.absolute(5);  // Go directly to line 5
        System.out.println("5.Row title = " + resultTable.getString("title"));  // african

        resultTable.relative(5); // Wherever you are at the end, go 5 from there --> to line 10
        System.out.println("10.Row title = " + resultTable.getString("title")); // alaaddin

        resultTable.next(); // Goes to 11
    }

    // resultTable.next()          : Next Line
    // resultTable.previous        : Previous Line
    // resultTable.absolute(10)    : Moves forward to line 10 from the beginning.
    // resultTable.relative(10)    : It moves forward from its current position to the 10th line.
    // resultTable.absolute(-10)   : - (minus) means from the end, 10th line from the end
    // resultTable.relative(-5)    : - (minus) 5 lines back from where it is
}
