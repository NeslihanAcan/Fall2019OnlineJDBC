package com.jdbc.I_lev_miktar;

import com.jdbc.utility.DB_Utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSet_DataStructures {
    public static void main(String[] args) throws SQLException {

        ResultSet result= DB_Utility.getResult("select * from employees");
        List<String>employeeNames=new ArrayList<>();

        while(result.next()){
            String firstName=result.getString("first_name");
            String lastName=result.getString("last_name");
            String fullName=firstName+" "+lastName;

            employeeNames.add(fullName);

        }
        System.out.println(employeeNames.contains("Steven King"));
        //Assert.AsserTrue(employeeNames.contains("Steven King"));

        DB_Utility.tearDown();
    }

}
