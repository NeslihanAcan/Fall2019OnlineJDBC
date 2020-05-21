package com.jdbc.I_lev_miktar;

import com.jdbc.utility.DB_Utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResultSet_Map {
    public static void main(String[] args) throws SQLException {
/**
 *  I can use this as an example in interview about map!!!!!!!
 */

     ResultSet result= DB_Utility.getResult("select * from employees");

        Map<String,Integer>employeeInfo=new LinkedHashMap<>();

        while (result.next()){

            String firstName=result.getString("first_name");
            String lastName=result.getString("last_name");
            String fullName=firstName+" "+lastName;

            Integer salary=result.getInt("salary");
            System.out.println(fullName+" "+salary);

            employeeInfo.put(fullName,salary);


        }
        System.out.println(employeeInfo);
        System.out.println(employeeInfo.get("Steven King")==24000);

        String sql="Update developers set name = 'Abdullah' where name= 'Nurullah'";

    }
}
