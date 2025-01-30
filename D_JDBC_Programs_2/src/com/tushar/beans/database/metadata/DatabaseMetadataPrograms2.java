package com.tushar.beans.database.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DatabaseMetadataPrograms2 {
	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
			int count = 0;
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			String catalog = null;
			String schemaPattern = null;
			String tablenamePattern = null;
			String[] types = null;
			
			ResultSet resultSet = databaseMetaData.getTables(catalog, schemaPattern, tablenamePattern, types);
			while(resultSet.next()) {
				count++;
				System.out.println(resultSet.getString(3));
			}
			System.out.println("The number of tables: " + count);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//tables -> schemas -> catalog -> database
	}
}
