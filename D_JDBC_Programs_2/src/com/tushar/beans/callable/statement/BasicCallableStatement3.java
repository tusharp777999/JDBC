package com.tushar.beans.callable.statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class BasicCallableStatement3 {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root",
				"root")) {
			// Make sure Stored Procedure is already there in DB.
			// Create CallableStatement Object.
			CallableStatement callableStatement = connection.prepareCall("{call GetEmployeeNameAndSalary(?,?,?)}");
			// Provide values for every IN parameter by using corresponding setter methods.
			callableStatement.setInt(1, 2);
			// Register every OUT parameter with JDBC types.
			callableStatement.registerOutParameter(2, Types.VARCHAR);
			callableStatement.registerOutParameter(3, Types.DOUBLE);
			// Execute Procedure call.
			callableStatement.execute();
			// Get results.
			String name = callableStatement.getString(2);
			double salary = callableStatement.getDouble(3);
			System.out.println("Name: " + name + " " + "Salary: " + salary);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*
 * 
 * Note: In MySQL how to create procedure that code is as below.
 * 
 * DELIMITER // CREATE PROCEDURE GetEmployeeNameAndSalary( IN employee_id INT,
 * OUT employee_name VARCHAR(20), OUT employee_salary DECIMAL(10,2) ) BEGIN
 * SELECT name, salary INTO employee_name, employee_salary FROM employee WHERE
 * id = employee_id; IF employee_name IS NULL THEN SET employee_name = 'NA'; END
 * IF; IF employee_salary IS NULL THEN SET employee_salary = 0; END IF; END //
 * DELIMITER ;
 * 
 * CALL GetEmployeeNameAndSalary(1, @emp_name, @emp_salary); SELECT @emp_name AS
 * employee_name, @emp_salary AS employee_salary;
 * 
 */
