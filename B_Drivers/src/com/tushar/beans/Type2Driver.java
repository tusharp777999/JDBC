package com.tushar.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Type2Driver {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from employee");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " +resultSet.getString(2) + " " + resultSet.getString(3));
			}
			
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
