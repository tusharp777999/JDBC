package com.tushar.beans.sql.injection.attack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SQLInjectionAttackPreventByPreparedStatement {
	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root");
				Scanner scanner = new Scanner(System.in);) {

			System.out.println("Enter username: ");
			String username = scanner.next();

			System.out.println("Enter password: ");
			String password = scanner.next();

			/*
			 * String sqlQuery1 = "select count(*) from users where username='" + username +
			 * "' and password='" + password + "'";
			 * 
			 * PreparedStatement preparedStatement1 =
			 * connection.prepareStatement(sqlQuery1); ResultSet resultSet1 =
			 * preparedStatement1.executeQuery();
			 * 
			 * int count1 = 0; if(resultSet1.next()) count1 = resultSet1.getInt(1);
			 * 
			 * if(count1 == 0) System.out.println("Invalid credentials 1."); else
			 * System.out.println("Valid credentials 1.");
			 */

			String sqlQuery2 = "select count(*) from users where username=? and password=?";
			PreparedStatement preparedStatement2 = connection.prepareStatement(sqlQuery2);

			preparedStatement2.setString(1, username);
			preparedStatement2.setString(2, password);

			ResultSet resultSet2 = preparedStatement2.executeQuery();

			int count2 = 0;
			if (resultSet2.next())
				count2 = resultSet2.getInt(1);

			if (count2 == 0)
				System.out.println("Invalid credentials 2.");
			else
				System.out.println("Valid credentials 2.");

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