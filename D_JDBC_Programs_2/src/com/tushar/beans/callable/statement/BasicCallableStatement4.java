package com.tushar.beans.callable.statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class BasicCallableStatement4 {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root",
				"root")) {
			// Make sure Stored Procedure is already there in DB.
			// Create CallableStatement Object.
			CallableStatement callableStatement = connection.prepareCall("{call getAllEmployeeInfo()}");
			// Execute Procedure call.
			ResultSet resultSet = callableStatement.executeQuery();
			// Get results.
			// Process the result set
			while (resultSet.next()) {
				int id = resultSet.getInt("id"); // Replace "id" with your column name
				String name = resultSet.getString("name"); // Replace "name" with your column name
				String department = resultSet.getString("department"); // Replace with your column name
				System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*
 * 
 * Note: In MySQL how to create procedure that code is as below.
 * 
 * DELIMITER $$
 * 
 * CREATE PROCEDURE getAllEmployeeInfo() BEGIN -- Simply return the result set
 * SELECT * FROM employee; END$$
 * 
 * DELIMITER ; CALL getAllEmployeeInfo();
 * 
 */
