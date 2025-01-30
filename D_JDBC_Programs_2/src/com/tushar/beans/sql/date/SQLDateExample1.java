package com.tushar.beans.sql.date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SQLDateExample1 {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root",
				"root"); Scanner scanner = new Scanner(System.in);) {
			String sqlQuery = "insert into people values(?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			

			System.out.println("Enter the people id: ");
			int id = scanner.nextInt();

			System.out.println("Enter the people name: ");
			String name = scanner.next();

			System.out.println("Enter the people DOB(dd-MM-yyyy): ");
			String dob = scanner.next();

			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date = simpleDateFormat.parse(dob);

			preparedStatement.setDate(3, new java.sql.Date(date.getTime()));

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
