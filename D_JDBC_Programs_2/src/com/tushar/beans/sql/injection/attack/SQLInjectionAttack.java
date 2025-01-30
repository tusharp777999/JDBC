package com.tushar.beans.sql.injection.attack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SQLInjectionAttack {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root");
				Scanner scanner = new Scanner(System.in);) {

			System.out.println("Enter username: ");
			String username = scanner.next();

			System.out.println("Enter password: ");
			String password = scanner.next();

			String sqlQuery = "select count(*) from users where username='" + username + "' and password='" + password
					+ "'";

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sqlQuery);

			int count = 0;
			if (resultSet.next())
				count = resultSet.getInt(1);

			if (count == 0)
				System.out.println("Invalid credentials.");
			else
				System.out.println("Valid credentials.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/*
 * Enter username: Raju'## Enter password: hjahdf Valid credentials.
 * 
 * Note: For MySQL use '#' for comments and for Oracle use '--'
 */