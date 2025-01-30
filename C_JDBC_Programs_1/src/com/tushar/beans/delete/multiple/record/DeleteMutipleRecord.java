package com.tushar.beans.delete.multiple.record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteMutipleRecord {
	public static void main(String[] args) {
		// Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root");
				Scanner scanner = new Scanner(System.in);) {
			Statement statement = connection.createStatement();

			while (true) {
				System.out.println("Enter employee name: ");
				String name = scanner.next();

				String sqlQuery = String.format("delete from employee where name = '%s'", name);
				int rowCount = statement.executeUpdate(sqlQuery);

				if (rowCount > 0)
					System.out.println(rowCount + " record deleted.");
				else
					System.out.println("record not deleted.");

				System.out.println("Do you want to continue to delete another record? Yes|No");
				String option = scanner.next();

				if ("No".equalsIgnoreCase(option))
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
