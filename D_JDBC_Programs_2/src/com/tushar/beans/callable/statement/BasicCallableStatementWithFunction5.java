package com.tushar.beans.callable.statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class BasicCallableStatementWithFunction5 {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root",
				"root")) {
			// Make sure Stored Procedure is already there in DB.
			// Create CallableStatement Object.
			CallableStatement callableStatement = connection.prepareCall("{? = call GetCombinedSalary(?,?)}");
			callableStatement.setInt(2, 1);
			callableStatement.setInt(3, 2);
			callableStatement.registerOutParameter(1, Types.DOUBLE);
			// Execute Procedure call.
			callableStatement.execute();
			// Process the result set
			double result = callableStatement.getDouble(1);
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*
 * 
 * Note: In MySQL how to create function that code is as below.
 * 
 * DELIMITER $$
 * 
 * CREATE FUNCTION GetCombinedSalary(empId1 INT, empId2 INT) RETURNS FLOAT
 * DETERMINISTIC BEGIN DECLARE salary1 FLOAT; DECLARE salary2 FLOAT; DECLARE
 * result FLOAT;
 * 
 * -- Fetch the first employee's salary SELECT salary INTO salary1 FROM employee
 * WHERE id = empId1;
 * 
 * -- Fetch the second employee's salary SELECT salary INTO salary2 FROM
 * employee WHERE id = empId2;
 * 
 * -- Combine the salaries (you can change this logic as needed) SET result =
 * salary1 + salary2;
 * 
 * -- Return the result RETURN result; END$$
 * 
 * DELIMITER ;
 * 
 */
