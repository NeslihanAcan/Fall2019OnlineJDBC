package com.jdbc.day1;

import java.sql.*;

public class BasicTest {
    public static void main(String[] args) throws SQLException {

        String URL="jdbc:oracle:thin:@54.91.168.70:1521:xe";
        String userName="hr";
        String passWord="hr";


        //to establish connection with a database
        Connection connection= DriverManager.getConnection(URL,userName,passWord);
                                                     //make it scrollable,So you can go from top to bottom and back in the result set
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        //in executeQuery method we provide query as a parameter
        ResultSet resultSet=statement.executeQuery("select * from employees");

            // returns true until it reaches the last row,and jumps to next row, if there is some row with data
        while(resultSet.next()){
            //get data from second column in every row
            //2nd column is a first name info
            System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "
                    +resultSet.getString(3)+" "+resultSet.getString("salary"));

       }
        resultSet.beforeFirst();//to comeback to the beginning of result set
        System.out.println("#########################");
        // some technical information about database
        DatabaseMetaData databaseMetaData=connection.getMetaData();
        // some technical information about database
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
        System.out.println("Jdbc driver: "+databaseMetaData.getDriverName());
        System.out.println("Jdbc driver version: "+databaseMetaData.getDriverVersion());
        System.out.println("Database name "+databaseMetaData.getDatabaseProductName());
        System.out.println("Database version "+databaseMetaData.getDatabaseProductVersion());
        System.out.println("Number of columns "+resultSetMetaData.getColumnCount());
        System.out.println("Label of 1st column is: "+resultSetMetaData.getColumnTypeName(1));
        System.out.println("########################");

        //this loop will loop through columns
        for (int columnIndex = 1; columnIndex <=resultSetMetaData.getColumnCount(); columnIndex++) {
            System.out.printf("%-20s",resultSetMetaData.getColumnName(columnIndex));
        }


        //iterate rows
       while(resultSet.next()) {
           //iterate columns
           for (int columnIndex = 1; columnIndex <=resultSetMetaData.getColumnCount(); columnIndex++) {
               System.out.printf("%-20s",resultSet.getString(columnIndex));
           }
           System.out.println(" ");
       }
        resultSet.close();
        statement.close();
        connection.close();

    }
}
