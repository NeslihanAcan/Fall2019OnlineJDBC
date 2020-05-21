package com.jdbc.I_lev_miktar;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class SimpleConnection {
    public static void main(String[] args) throws SQLException {

       String userName="hr";
        String passWord="hr";
        String URL="jdbc:oracle:thin:@54.91.168.70:1521:xe";


        Connection connection= DriverManager.getConnection(URL,userName,passWord);
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        System.out.println("Connected Successfully");



    }
}
