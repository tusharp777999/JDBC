package com.tushar.beans.transaction.isolation;

import java.sql.Connection;
import java.sql.DriverManager;

public class TransactionIsolationProgram {
	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
			System.out.println("Default: " + connection.getTransactionIsolation());
			
			connection.setTransactionIsolation(1);
			System.out.println("First Level: " + connection.getTransactionIsolation());
			
			connection.setTransactionIsolation(2);
			System.out.println("Second Level: " + connection.getTransactionIsolation());
			
			connection.setTransactionIsolation(4);
			System.out.println("Third Level: " + connection.getTransactionIsolation());
			
			connection.setTransactionIsolation(8);
			System.out.println("Fourth Level: " + connection.getTransactionIsolation());
			
			connection.setTransactionIsolation(3);
			System.out.println("Other trying which will occurs error: " + connection.getTransactionIsolation());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
