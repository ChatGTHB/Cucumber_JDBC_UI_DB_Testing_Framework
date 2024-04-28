package jdbc;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _07_GetMetaData extends JDBCParent {

    @Test
    public void test01() throws SQLException {

        ResultSet resultTable = statement.executeQuery("select city_id, city, country_id from city");

        resultTable.last(); // I have gone to last row

        String stringID = resultTable.getString(1); // The last row and first column --> city_id
        System.out.println("String ID = " + stringID);

        int intID = resultTable.getInt(1); // If the field type is suitable, conversion can also be made to int type.
        System.out.println("int ID = " + intID); // The last row and first column --> city_id
    }

    @Test
    public void test02() throws SQLException {

        ResultSet resultTable = statement.executeQuery("select * from city");

        ResultSetMetaData resultSetMetaData = resultTable.getMetaData(); // Other information other than data

        int columnCount = resultSetMetaData.getColumnCount(); // Number of columns

        resultTable.next(); // I has gone to the first row

        for (int i = 1; i <= columnCount; i++) {
            System.out.println("Column " + i + " header: " + resultSetMetaData.getColumnName(i) + " " + resultSetMetaData.getColumnTypeName(i) + "\t");
            // I printed the names and types of the columns
        }

        System.out.println();

        for (int i = 1; i <= columnCount; i++) {
            System.out.println("Column " + i + ")- " + resultTable.getString(i) + "\t");
            // I can print data in all columns
        }
    }

    @Test
    public void test03() throws SQLException {

        /**
         Language tablosundaki tüm satır ve sütun içeriklerini tablodaki şekliyle yazdırınız.
         ------------------------------------------------------------------------------------
         Print the contents of all rows and columns in the Language table as in the table.
         */

        ResultSet resultTable = statement.executeQuery("select * from language");

        ResultSetMetaData resultSetMetaData = resultTable.getMetaData(); // Other information other than data
        int columnCount = resultSetMetaData.getColumnCount(); // Number of columns

        resultTable.last();
        int numberOfRows = resultTable.getRow(); // Number of Rows

        for (int i = 1; i <= columnCount; i++) {
            System.out.print(resultSetMetaData.getColumnName(i) + "\t");
        }

        resultTable.first();
        for (int i = 1; i <= numberOfRows; i++) {
            System.out.println();
            for (int j = 1; j <= columnCount; j++) {
                System.out.print(resultTable.getString(j) + "\t");
            }
            resultTable.next();
        }
    }

    @Test
    public void test03_Solution2() throws SQLException {

        /**
         Language tablosundaki tüm satır ve sütun içeriklerini tablodaki şekliyle yazdırınız.
         ------------------------------------------------------------------------------------
         Print the contents of all rows and columns in the Language table as in the table.
         */

        ResultSet resultTable = statement.executeQuery("select * from language");
        ResultSetMetaData resultTableMetaData = resultTable.getMetaData();

        for (int i = 1; i <= resultTableMetaData.getColumnCount(); i++) {
            System.out.printf("%-20s", resultTableMetaData.getColumnName(i));
        }

        System.out.println();

        while (resultTable.next()) {
            for (int i = 1; i <= resultTableMetaData.getColumnCount(); i++) {
                System.out.printf("%-20s", resultTable.getString(i));
            }
            System.out.println();
        }

        /**
         % : points to the value of the variable
         - : prints left aligned, default right aligned
         20: how many digits will be used each time its information
         s: is used for string values, d is used for numeric values
         "%5.2f" : use 5 digits for number, 2 digits for decimal part
         ------------------------------------------------------------
         % : değişkenin değerini işaret eder
         - : sola dayalı yazdırır, default sağa dayalı
         20: kaç hane kullanılacak herzaman onun bilgisi
         s : string değerler içis , sayısal değerler için d kullanılır
         "%5.2f" : sayı için 5 hane kullan, ondalıklı kısım için 2 hane
         */
    }
}

// TODO (Challenge): Database den Customer tablosunu okuyarak, yeni bir EXCELE yazdırınız.
// TODO (Challenge): Read the Customer table from the database and print a new EXCEL.

