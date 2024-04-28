package jdbc;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class _08_GetAllRowColumn extends JDBCParent {

    @Test
    public void test01() {
        /**
         Bir metoda sorguyu("select * from language") gönderiniz;
         metod size sorgunun datasını bir ArrayList olarak döndürsün.
         -----------------------------------------------------------
         Send the sql("select * from language") to a method;
         Let the method return you the sql data as an ArrayList.
         */

        String sql = "select * from language";
        List<List<String>> returningList = getListData(sql);

        for (int i = 0; i < returningList.size(); i++) {
            System.out.println(returningList.get(i));
        }
        // System.out.println("returningList = " + returningList);
    }

    public List<List<String>> getListData(String sql) {

        List<List<String>> table = new ArrayList<>();

        try {
            ResultSet resultTable = statement.executeQuery(sql);
            ResultSetMetaData resultTableMetaData = resultTable.getMetaData();

            // Column names added to the first row of the table
            ArrayList<String> kolonSatiri = new ArrayList<>();
            for (int i = 1; i <= resultTableMetaData.getColumnCount(); i++)
                kolonSatiri.add(resultTableMetaData.getColumnName(i));
            table.add(kolonSatiri);

            while (resultTable.next()) {

                List<String> row = new ArrayList<>();

                for (int i = 1; i <= resultTableMetaData.getColumnCount(); i++) {
                    row.add(resultTable.getString(i));
                }
                table.add(row);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return table;
    }

    // TODO (Challenge): Database den Customer tablosunu okuyarak, yeni bir EXCELE yazdırınız.
    // TODO (Challenge): Read the Customer table from the database and print a new EXCEL.
}
