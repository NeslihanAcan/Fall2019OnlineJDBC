package com.jdbc.day1;

import java.sql.*;

public class InsertAndDeleteTest {

    static String URL="jdbc:oracle:thin:@54.91.168.70:1521:xe";
    static String username="hr";
    static String password="hr";

    public static void main(String[] args) throws SQLException {

        Connection connection= DriverManager.getConnection(URL,username,password);
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);


        String INSERT_QUERY="INSERT INTO employees VALUES(230,'Neslihan','Acan','neslihan@cybertek.com','777-777-7777',SYSDATE,'SDET',16999,0,NULL,NULL)";
        String DELETE_QUERY="delete from employees where employee_id=230";
       ResultSet resultSet=statement.executeQuery(INSERT_QUERY);

        resultSet.close();
        statement.close();
        connection.close();
    }
}
