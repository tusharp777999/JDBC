package com.tushar.beans.resultset.types;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ResultSetHoldabilityProgram11 {
	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement();
			System.out.println("Type: " + statement.getResultSetType());
			System.out.println("Concurrency: " + statement.getResultSetConcurrency());
			System.out.println("Holdability: " + statement.getResultSetHoldability());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
