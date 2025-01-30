package com.tushar.beans.resultset.types;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetHoldabilityProgram8 {
	public static void main(String[] args) {
		/*
		 1.HOLD_CURSORS_OVER_COMMIT -> 1 (Default)
		 2.CLOSE_CURSORS_AT_COMMIT -> 2
		 
		 There are two ways to check the Holdability as below using Statement and ResultSet.
		*/
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println(statement.getResultSetHoldability());
			
			ResultSet resultSet = statement.executeQuery("select * from student");
			System.out.println(resultSet.getHoldability());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
