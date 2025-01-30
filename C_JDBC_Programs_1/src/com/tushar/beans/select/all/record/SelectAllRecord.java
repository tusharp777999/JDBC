package com.tushar.beans.select.all.record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectAllRecord {
	public static void main(String[] args) {
		// Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root");
				Scanner scanner = new Scanner(System.in);) {
			Statement statement = connection.createStatement();

			String sqlQuery = "select * from employee";
			ResultSet resultSet = statement.executeQuery(sqlQuery);

			if (!resultSet.next()) {
				System.out.println("No records found");
			} else {

				while (resultSet.next()) {
					System.out
							.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
