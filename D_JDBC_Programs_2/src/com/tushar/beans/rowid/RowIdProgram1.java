package com.tushar.beans.rowid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RowIdProgram1 {
    public static void main(String[] args) {
    	/*
  	  		Actually the MySQL does not supports the RowId concept as Oracle can. It just an alternate way.
    	*/
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT UUID() AS rowid, id, name, department FROM student");

            while (resultSet.next()) {
                String rowIdString = resultSet.getString("rowid"); // Use getString instead of getRowId
                System.out.println(rowIdString + "\t" + resultSet.getInt("id") + "\t" + resultSet.getString("name") + "\t" + resultSet.getString("department"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

