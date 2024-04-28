package jdbc;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class _08_GetAllRowColumn extends JDBCParent {

    @Test
    public void test01() {
        String sql = "select * from language";
        List<List<String>> returningList = getListData(sql);

        for (int rowIndex = 0; rowIndex < returningList.size(); rowIndex++) {
            List<String> row = returningList.get(rowIndex);
            for (int columnIndex = 0; columnIndex < row.size(); columnIndex++) {
                System.out.printf("%-15s", row.get(columnIndex));
            }
            System.out.println();
        }
    }

    public List<List<String>> getListData(String sql) {
        List<List<String>> table = new ArrayList<>();

        try {
            ResultSet resultTable = statement.executeQuery(sql);
            ResultSetMetaData resultTableMetaData = resultTable.getMetaData();

            ArrayList<String> columnNames = new ArrayList<>();
            for (int i = 1; i <= resultTableMetaData.getColumnCount(); i++) {
                columnNames.add(resultTableMetaData.getColumnName(i));
            }

            table.add(columnNames);

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