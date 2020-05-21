package com.jdbc.I_lev_miktar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Statement_ResultSet {
    public static void main(String[] args) throws Exception{


        String userName="hr";
        String passWord="hr";
        String URL="jdbc:oracle:thin:@54.91.168.70:1521:xe";

        //Connection step:
        Connection connection= DriverManager.getConnection(URL,userName,passWord);
        System.out.println("Connected Successfully!!!");

        //Statement step:
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        System.out.println("Statement is created!!!");

        ResultSet resultSet=statement.executeQuery("select * from employees");
        System.out.println("Result set is completed!");

        String sql="Update developers set names = 'Mesut' where names= 'Safwan'";

        statement.executeUpdate(sql);





    }
}
