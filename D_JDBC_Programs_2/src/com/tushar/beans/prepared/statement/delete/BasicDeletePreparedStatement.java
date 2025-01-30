package com.tushar.beans.prepared.statement.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BasicDeletePreparedStatement {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root");
				Scanner scanner = new Scanner(System.in);) {
			String sqlQuery = "delete from employee where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

			while (true) {
				System.out.println("Enter the employee id: ");
				int employeeId = scanner.nextInt();

				preparedStatement.setInt(1, employeeId);

				int deletedCount = preparedStatement.executeUpdate();
				if (deletedCount > 0)
					System.out.println(deletedCount + "records deleted.");
				else
					System.out.println("records not deleted.");

				System.out.println("Do you want to delete one more records? Yes | No");
				String option = scanner.next();

				if ("No".equalsIgnoreCase(option))
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
