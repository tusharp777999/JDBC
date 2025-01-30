package com.tushar.beans.insert.multiple.record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertMutipleRecord {
	public static void main(String[] args) {
		// Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root");
				Scanner scanner = new Scanner(System.in);) {
			Statement statement = connection.createStatement();

			while (true) {
				System.out.println("Enter employee id: ");
				int id = scanner.nextInt();

				System.out.println("Enter employee name: ");
				String name = scanner.next();

				System.out.println("Enter department: ");
				String department = scanner.next();

				String sqlQuery = String.format("insert into employee values(%d, '%s', '%s')", id, name, department);
				int rowCount = statement.executeUpdate(sqlQuery);

				if (rowCount > 0)
					System.out.println(rowCount + " record inserted.");
				else
					System.out.println("record not inserted.");

				System.out.println("Do you want to continue to insert another record? Yes|No");
				String option = scanner.next();

				if ("No".equalsIgnoreCase(option))
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
