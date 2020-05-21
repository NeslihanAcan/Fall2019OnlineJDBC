package com.jdbc.utility;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MetaData {

    public static void main(String[] args) throws SQLException {

        System.out.println("User: " + DB_Utility.metaData.getUserName());
        System.out.println("Version: " + DB_Utility.metaData.getDriverVersion());
        System.out.println("DataBase Type: " + DB_Utility.metaData.getDatabaseProductName());

        ResultSet result = DB_Utility.getResult("select * from employees");
        ResultSetMetaData resultSetMetaData = result.getMetaData();
        System.out.println(resultSetMetaData.getColumnCount());
        System.out.println(resultSetMetaData.getColumnName(5));

        System.out.println("===================================");

        /**
         * Bu kisimdan itibaren bu iki loopdan ilki bana column nameleri sirasiyla yanyana veriyor
         * ikinci loop ise rowlardaki datalari sirasiyla veriyor. Boylece duzgun bir print ile butun employee e ait datayi gorebiliyorum.
         */
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            System.out.printf("%-20s", resultSetMetaData.getColumnName(i));
        }
        while (result.next()) {


            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.printf("%-20s", result.getString(i));

            }
            System.out.println(" ");
        }
    }
}