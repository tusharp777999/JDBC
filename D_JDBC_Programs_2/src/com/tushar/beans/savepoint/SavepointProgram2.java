package com.tushar.beans.savepoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavepointProgram2 {
	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
			connection.setAutoCommit(false);
			
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into student values(3, 'Chetan', 'Science')");
			statement.executeUpdate("insert into student values(4, 'Damodar', 'Physics')");
			Savepoint savepoint = connection.setSavepoint();
			statement.executeUpdate("insert into student values(5, 'Shaktimaan', 'Commerce')");
			System.out.println("Considering the error is not occured and do rollback.");
			connection.releaseSavepoint(savepoint);
			connection.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
