package jdbc;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _05_FirstLastGetRowGetType extends JDBCParent {

    @Test
    public void test01() throws SQLException {

        ResultSet resultTable = statement.executeQuery("select city from city");

        resultTable.last();  // Goes to the last line
        System.out.println("City name at the last line = " + resultTable.getString(1));

        resultTable.first(); // Goes to the first line
        System.out.println("City name at the first line = " + resultTable.getString(1));

        resultTable.last();  // Goes to the last line
        int whichRowAmIOn = resultTable.getRow(); // Get the row number I'm on --> The last line
        System.out.println("The Line I'm On = " + whichRowAmIOn);
    }
}
