package utilities;

import java.sql.*;
import java.util.*;

public class DBUtility {
    public static Connection connection;
    public static Statement statement;

    public static List<List<String>> getDataList(String sql) {

        dbConnectionOpen();

        List<List<String>> dataList = new ArrayList<>();

        try {
            ResultSet resultTable = statement.executeQuery(sql);
            ResultSetMetaData resultTableMetaData = resultTable.getMetaData();

            while (resultTable.next()) {
                List<String> rowList = new ArrayList<>();
                for (int i = 1; i <= resultTableMetaData.getColumnCount(); i++) {
                    rowList.add(resultTable.getString(i));
                }
                dataList.add(rowList);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        dbConnectionClose();
        return dataList;
    }

    public static void dbConnectionOpen() {
        String hostUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(hostUrl, username, password);
            statement = connection.createStatement();
        } catch (Exception exception) {
            System.out.println("exception.getMessage() = " + exception.getMessage());
        }
    }

    public static void dbConnectionClose() {
        try {
            connection.close();
        } catch (SQLException exception) {
            System.out.println("exception.getMessage() = " + exception.getMessage());
        }
    }
}
