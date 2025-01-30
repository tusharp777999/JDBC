package com.tushar.beans.resultset.types;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class ResultSetHoldabilityProgram9 {
	public static void main(String[] args) {
		/*
		 1.HOLD_CURSORS_OVER_COMMIT -> 1 (Default)
		 2.CLOSE_CURSORS_AT_COMMIT -> 2
		 
		 We can check the Holdability using Database Metadata.
		*/
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			System.out.println(databaseMetaData.getResultSetHoldability());
			if(databaseMetaData.supportsResultSetHoldability(1)) {
				System.out.println("Supports HOLD_CURSORS_OVER_COMMIT");
			}
			if(databaseMetaData.supportsResultSetHoldability(2)) {
				System.out.println("Supports CLOSE_CURSORS_AT_COMMIT");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
