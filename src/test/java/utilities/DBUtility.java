package utilities;

import java.sql.*;
import java.util.*;

public class DBUtility {

    public static Connection connection;
    public static  Statement statement;


    public static List<List<String>> getDataList(String sql){
        DBConnectionOpen();

        List<List<String>> dataList=new ArrayList<>();

        try {
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData rsmd=rs.getMetaData();

            while (rs.next()) {
                List<String> rowList=new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    rowList.add(rs.getString(i));
                }

                dataList.add(rowList);
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        DBConnectionClose();
        return dataList;
    }



    public static void DBConnectionOpen()
    {
        String HostUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(HostUrl, username, password);
            statement = connection.createStatement();
        }
        catch(Exception ex){
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }

    public static void DBConnectionClose()
    {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }



}
