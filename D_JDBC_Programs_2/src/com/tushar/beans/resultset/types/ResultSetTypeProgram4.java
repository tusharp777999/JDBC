package com.tushar.beans.resultset.types;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetTypeProgram4 {
	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
			/*
			 The scroll sensitive supported by only Type 1 and Type 2 Driver and the basic difference between this 2 drivers is that the Type 1 works with * in select
			 query where Type 2 driver needs column names in select query.
			*/
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet resultSet = statement.executeQuery("select id, name, department from student");
			
			System.out.println("Records before updation: ");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
			}
			
			System.out.println("Application is going to pausing state, please update database: ");
			System.in.read();
			
			resultSet.beforeFirst();
			
			System.out.println("Records after updation: ");
			while(resultSet.next()) {
				resultSet.refreshRow();
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
