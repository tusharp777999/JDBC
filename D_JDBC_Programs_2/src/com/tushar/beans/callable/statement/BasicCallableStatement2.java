package com.tushar.beans.callable.statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class BasicCallableStatement2 {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root",
				"root")) {
			// Make sure Stored Procedure is already there in DB.
			// Create CallableStatement Object.
			CallableStatement callableStatement = connection.prepareCall("{call GetEmployeeSalary(?,?)}");
			// Provide values for every IN parameter by using corresponding setter methods.
			callableStatement.setInt(1, 2);
			// Register every OUT parameter with JDBC types.
			callableStatement.registerOutParameter(2, Types.DOUBLE);
			// Execute Procedure call.
			callableStatement.execute();
			// Get results.
			double result = callableStatement.getDouble(2);
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
 * CREATE PROCEDURE GetEmployeeSalary( IN p_employee_id INT, OUT p_salary
 * DECIMAL(10, 2) ) BEGIN -- Fetch the salary for the given user ID SELECT
 * salary INTO p_salary FROM employee WHERE id = p_employee_id;
 * 
 * -- If no record is found, set salary to NULL IF p_salary IS NULL THEN SET
 * p_salary = 0; END IF; END //
 * 
 * DELIMITER ;
 * 
 */
