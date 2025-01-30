package com.tushar.beans.savepoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavepointProgram1 {
	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
			connection.setAutoCommit(false);
			
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into student values(1, 'Tushar', 'Science')");
			statement.executeUpdate("insert into student values(2, 'Kishor', 'Physics')");
			Savepoint savepoint = connection.setSavepoint();
			statement.executeUpdate("insert into student values(3, 'Ketan', 'Commerce')");
			System.out.println("Considering the error is occured and do rollback.");
			connection.rollback(savepoint);
			//If no issue occurs then we should not use the rollback based on condition and use 
			//connection.releaseSavepoint(savepoint);
			connection.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
