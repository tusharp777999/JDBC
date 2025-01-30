package com.tushar.beans.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionProgram {
	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from accounts");
			System.out.println("Data before transaction: ");
			while(resultSet.next())
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getDouble(3));
			
			System.out.println("Transaction is started: ");
			
			connection.setAutoCommit(false);
			
			statement.executeUpdate("update accounts set balance = balance - 1000 where name = 'Tushar'");
			statement.executeUpdate("update accounts set balance = balance + 1000 where name = 'Keshav'");
			
			System.out.println("Can you please confirm this Transaction of 1000? [Yes|No]");
			Scanner scanner = new Scanner(System.in);
			
			String option = scanner.next();
			
			if(option.equalsIgnoreCase("Yes")) {
				connection.commit();
				System.out.println("Transaction committed.");
			} else {
				connection.rollback();
				System.out.println("Transaction Roll back");
			}
			
			System.out.println("Data after transaction: ");
			ResultSet resultSet1 = statement.executeQuery("select * from accounts");
			while(resultSet1.next())
				System.out.println(resultSet1.getInt(1) + "\t" + resultSet1.getString(2) + "\t" + resultSet1.getDouble(3));
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
