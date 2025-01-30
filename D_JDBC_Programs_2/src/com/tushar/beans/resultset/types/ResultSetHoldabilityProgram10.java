package com.tushar.beans.resultset.types;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetHoldabilityProgram10 {
	public static void main(String[] args) {
		/*
		 1.HOLD_CURSORS_OVER_COMMIT -> 1 (Default)
		 2.CLOSE_CURSORS_AT_COMMIT -> 2
		 
		 We can check the Holdability using Database Metadata.
		*/
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.CLOSE_CURSORS_AT_COMMIT);
			ResultSet resultSet = statement.executeQuery("select * from student");
			connection.commit();
			resultSet.last();
			resultSet.deleteRow();
			System.out.println("Lase record deleted.");
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
