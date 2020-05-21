package com.jdbc.I_lev_miktar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Printing_Result {

    public static void main(String[] args) throws Exception{

        String userName="hr";
        String passWord="hr";
        String URL="jdbc:oracle:thin:@54.91.168.70:1521:xe";


        Connection connection= DriverManager.getConnection(URL,userName,passWord);

        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet=statement.executeQuery("select * from employees");

        while(resultSet.next()){

            String firstName=resultSet.getString(2);
            String lastName=resultSet.getString(3);
            int salary=resultSet.getInt("salary");
            System.out.println(firstName+"     "+lastName+"      $"+salary);

        }


    }
}
