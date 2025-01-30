package com.tushar.beans.resultset.types;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class ResultSetTypeProgram1 {
	public static void main(String[] args) {
		/*
		 Allowed values for type:
		 ResultSet.TYPE_FORWARD_ONLY -> 1003
		 ResultSet.TYPE_SCROLL_INSENSITIVE -> 1004
		 ResultSet.TYPE_SCROLL_SENSITIVE -> 1005 //MySQL does not supports this but Oracle supports.
		 
		 Allowed values for mode:
		 ResultSet.CONCUR_READ_ONLY -> 1007
		 ResultSet.CONCUR_UPDATABLE -> 1008
		 
		 Even you need to check the Database supports this above type or not.
		 databaseMetaData.supportsResultSetConcurrency(int type, int concurrency);
		 databaseMetaData.supportsResultSetType(int type);
		*/
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			System.out.println("Forward Only Read Only: " + databaseMetaData.supportsResultSetConcurrency(1003, 1007));
			System.out.println("Forward Only Updatable: " + databaseMetaData.supportsResultSetConcurrency(1003, 1008));
			System.out.println("Forward Only: " + databaseMetaData.supportsResultSetType(1003));
			System.out.println("Scroll Insesitive: " + databaseMetaData.supportsResultSetType(1004));
			System.out.println("Scroll Sensitive: " + databaseMetaData.supportsResultSetType(1005));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
