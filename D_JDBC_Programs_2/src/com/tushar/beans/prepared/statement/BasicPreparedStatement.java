package com.tushar.beans.prepared.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BasicPreparedStatement {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root");
				Scanner scanner = new Scanner(System.in);) {
				String sqlQuery = "insert into employee values(?, ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

				while (true) {
					System.out.println("Enter the employee id: ");
					int employeeId = scanner.nextInt();
	
					System.out.println("Enter the employee name: ");
					String name = scanner.next();
	
					System.out.println("Enter the employee department: ");
					String department = scanner.next();
	
					preparedStatement.setInt(1, employeeId);
					preparedStatement.setString(2, name);
					preparedStatement.setString(3, department);
	
					int insertedCount = preparedStatement.executeUpdate();
					if (insertedCount > 0)
						System.out.println(insertedCount + "records inserted.");
					else
						System.out.println("records not inserted.");
	
					System.out.println("Do you want to insert one more records? Yes | No");
					String option = scanner.next();
	
					if ("No".equalsIgnoreCase(option))
						break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
