package com.tushar.beans.resultset.types;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetTypeProgram6 {
	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
			/*
			 The updatable supported by only Type 1 and Type 2 Driver and the basic difference between this 2 drivers is that the Type 1 works with * in select
			 query where Type 2 driver needs column names in select query.
			*/
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet resultSet = statement.executeQuery("select * from student");

			//Update only 3rd record name and salary.
			resultSet.absolute(3);
			resultSet.updateString(2, "Mantra");
			resultSet.updateString(3, "IIT");
			resultSet.updateRow();
			System.out.println("3rd row updated.");
			
			/*
			 if you want to update all records salary below is the logic for it.
			 while(resultSet.next()){
			 	float salary = resultSet.getFloat(3);
			 	if(salary < 2500){
			 		resultSet.updateFloat(3, esal + 500);
			 		resultSet.updateRow();
			 	}
			 } 
			*/
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
