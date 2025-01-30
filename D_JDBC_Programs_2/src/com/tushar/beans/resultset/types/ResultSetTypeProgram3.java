package com.tushar.beans.resultset.types;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetTypeProgram3 {
	public static void main(String[] args) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root")) {
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet resultSet = statement.executeQuery("select * from student");
			System.out.println("Results in original order: ");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
			}
			resultSet.first();
			System.out.println("first(): " + resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
			
			resultSet.last();
			System.out.println("last(): " + resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
			
			resultSet.relative(-1);
			System.out.println("relative(): " + resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
			
			resultSet.absolute(2);
			System.out.println("absolute(): " + resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
