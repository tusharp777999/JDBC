package com.tushar.beans.select.sorting.order.record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectAllRecordBySorting {
	public static void main(String[] args) {
		// Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root");
				Scanner scanner = new Scanner(System.in);) {
			Statement statement = connection.createStatement();

			String sqlQuery = "select * from employee order by id desc";
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
