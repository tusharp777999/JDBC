package com.tushar.beans.sql.injection.attack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SQLInjectionAttack2 {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root");
				Scanner scanner = new Scanner(System.in);) {

			System.out.println("Enter user id: ");
			String userid = scanner.next();

			Statement statement = connection.createStatement();

			String sqlQuery = "select * from users where id=" + userid;
			ResultSet resultSet = statement.executeQuery(sqlQuery);

			System.out.println("The result is: ");

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "---" + resultSet.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
//Need to check with id as a String data type in db.