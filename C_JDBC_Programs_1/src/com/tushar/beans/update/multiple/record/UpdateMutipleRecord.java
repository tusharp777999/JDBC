package com.tushar.beans.update.multiple.record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateMutipleRecord {
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

				String sqlQuery = String.format("update employee set name = '%s' where id = %d", name, id);
				int rowCount = statement.executeUpdate(sqlQuery);

				if (rowCount > 0)
					System.out.println(rowCount + " record updated.");
				else
					System.out.println("record not updated.");

				System.out.println("Do you want to continue to update another record? Yes|No");
				String option = scanner.next();

				if ("No".equalsIgnoreCase(option))
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
