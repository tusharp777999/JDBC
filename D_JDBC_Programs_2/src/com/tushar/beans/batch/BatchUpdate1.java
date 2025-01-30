package com.tushar.beans.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BatchUpdate1 {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root");
				Scanner scanner = new Scanner(System.in);) {
			String sqlQuery = "insert into employee values(?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

			while (true) {
				System.out.println("Enter the employee id: ");
				int employeeId = scanner.nextInt();

				System.out.println("Enter the employee name: ");
				String name = scanner.next();

				System.out.println("Enter the employee department: ");
				String department = scanner.next();

				System.out.println("Enter the employee salary: ");
				double salary = scanner.nextDouble();

				preparedStatement.setInt(1, employeeId);
				preparedStatement.setString(2, name);
				preparedStatement.setString(3, department);
				preparedStatement.setDouble(4, salary);
				preparedStatement.addBatch();// Adding to the batch

				System.out.println("Do you want to insert one more records? Yes | No");
				String option = scanner.next();

				if ("No".equalsIgnoreCase(option))
					break;
			}
			int[] insertedArray = preparedStatement.executeBatch();

			System.out.println("Records inserted successfully.");

			int count = 0;

			for (int insertedArrayValue : insertedArray) {
				count++;
			}
			System.out.println("Inserted number of records: " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
