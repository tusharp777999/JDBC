package com.tushar.beans.callable.statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class BasicCallableStatement1 {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root",
				"root")) {
			// Make sure Stored Procedure is already there in DB.
			// Create CallableStatement Object.
			CallableStatement callableStatement = connection.prepareCall("{call AddTwoNumbers(?,?,?)}");
			// Provide values for every IN parameter by using corresponding setter methods.
			callableStatement.setInt(1, 100);
			callableStatement.setInt(2, 200);
			// Register every OUT parameter with JDBC types.
			callableStatement.registerOutParameter(3, Types.INTEGER);
			// Execute Procedure call.
			callableStatement.execute();
			// Get results.
			int result = callableStatement.getInt(3);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*
 * 
 * Note: In MySQL how to create procedure that code is as below.
 * 
 * DELIMITER //
 * 
 * CREATE PROCEDURE AddTwoNumbers( IN num1 INT, -- First input parameter IN num2
 * INT, -- Second input parameter OUT result INT -- Output parameter for the
 * result ) BEGIN SET result = num1 + num2; -- Add the two input numbers and
 * assign the result END //
 * 
 * DELIMITER ;
 * 
 * CALL AddTwoNumbers(5, 10, @output);
 * 
 * SELECT @output AS Result;
 */
