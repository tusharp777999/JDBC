package com.tushar.beans.sql.date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class SQLDateExample2 {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root",
				"root"); Scanner scanner = new Scanner(System.in)) {
			String sqlQuery = "insert into people values(?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

			System.out.println("Enter the people id: ");
			int id = scanner.nextInt();

			System.out.println("Enter the people name: ");
			String name = scanner.next();

			System.out.println("Enter the people DOB(yyyy-mm-dd): ");// Only this format needed if you want to use
																		// directly Date class of sql package.
			String dob = scanner.next();

			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);

			java.sql.Date date = java.sql.Date.valueOf(dob);
			preparedStatement.setDate(3, date);

			int insertedCount = preparedStatement.executeUpdate();

			if (insertedCount > 0)
				System.out.println("Record inserted.");
			else
				System.out.println("Record not inserted.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
