package com.tushar.beans.resultset.metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultSetMetaDataProgram {
	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from student");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			for(int i = 1; i <= columnCount; i++) {
				//Many database vendors don't supports for the ResultSet implementation so it is not guaranteed that below methods will work because 
				//database vendors provided support for it or not it depends on that.
				System.out.println("Column Number: " + i);
				System.out.println("Column Name: " + resultSetMetaData.getColumnName(i));
				System.out.println("Column Type: " + resultSetMetaData.getColumnType(i));
				System.out.println("Column Table Name: " + resultSetMetaData.getTableName(i));
				System.out.println("Column Catalog Name: " + resultSetMetaData.getCatalogName(i));
				System.out.println("Column Class Name: " + resultSetMetaData.getColumnClassName(i));
				System.out.println("Column Display Size: " + resultSetMetaData.getColumnDisplaySize(i));
				System.out.println("Column Lable: " + resultSetMetaData.getColumnLabel(i));
				System.out.println("===========================================");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
