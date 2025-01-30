package com.tushar.beans.database.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DatabaseMetadataPrograms1 {
	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			System.out.println("Database Product Name: " + databaseMetaData.getDatabaseProductName());
			System.out.println("Database Product Version: " + databaseMetaData.getDatabaseProductVersion());
			System.out.println("Database Major Version: " + databaseMetaData.getDatabaseMajorVersion());
			System.out.println("Database Minor Version: " + databaseMetaData.getDatabaseMinorVersion());
			System.out.println("JDBC Major Version: " + databaseMetaData.getJDBCMajorVersion());
			System.out.println("JDBC Minor Version: " + databaseMetaData.getJDBCMinorVersion());
			System.out.println("Driver Name: " + databaseMetaData.getDriverName());
			System.out.println("Driver Version: " + databaseMetaData.getDriverVersion());
			System.out.println("Driver Major Version: " + databaseMetaData.getDriverMajorVersion());
			System.out.println("Driver Minor Version: " + databaseMetaData.getDriverMinorVersion());
			System.out.println("Meta Data: " + databaseMetaData.getURL());
			System.out.println("User Name: " + databaseMetaData.getUserName());
			System.out.println("Max User Name Length: " + databaseMetaData.getMaxUserNameLength());
			
			
			System.out.println("Max Column Name Length: " + databaseMetaData.getMaxColumnNameLength());
			System.out.println("Max Columns In Group By: " + databaseMetaData.getMaxColumnsInGroupBy());
			System.out.println("Max Columns In Index: " + databaseMetaData.getMaxColumnsInIndex());
			System.out.println("Max Columns In Order By: " + databaseMetaData.getMaxColumnsInOrderBy());
			System.out.println("Max Columns In Select: " + databaseMetaData.getMaxColumnsInSelect());
			System.out.println("Max Columns In Table: " + databaseMetaData.getMaxColumnsInTable());
			
			System.out.println("Max Row Size: " + databaseMetaData.getMaxRowSize());
			
			System.out.println("Max Statements: " + databaseMetaData.getMaxStatements());
			System.out.println("Max Statement Length: " + databaseMetaData.getMaxStatementLength());
			
			System.out.println("Max Tables In Select: " + databaseMetaData.getMaxTablesInSelect());
			System.out.println("Max Table Name Length: " + databaseMetaData.getMaxTableNameLength());
			
			System.out.println("SQL Keywords: " + databaseMetaData.getSQLKeywords());
			System.out.println("Numeric Functions: " + databaseMetaData.getNumericFunctions());
			System.out.println("String Functions: " + databaseMetaData.getStringFunctions());
			System.out.println("System Functions: " + databaseMetaData.getSystemFunctions());
			
			System.out.println("Supports Full Outer Joins: " + databaseMetaData.supportsFullOuterJoins());
			System.out.println("Supports Stored Procedures: " + databaseMetaData.supportsStoredProcedures());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
